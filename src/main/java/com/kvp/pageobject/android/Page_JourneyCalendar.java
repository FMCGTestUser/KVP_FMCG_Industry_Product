package com.kvp.pageobject.android;



import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.kvp.project.reusableutils.Util_AndroidActions;
import com.kvp.project.reusableutils.Util_PropertyConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_JourneyCalendar extends Util_AndroidActions {
	
	AndroidDriver driver;
	public Page_JourneyCalendar(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
		
	@AndroidFindBy(xpath = "//android.view.View[3]")
	private List<WebElement> monthHeading;
	
    @AndroidFindBy(xpath = "//android.view.View[5]/android.view.View/android.view.View")
    private WebElement calendersection;
    
    @AndroidFindBy(xpath = "//android.view.View/android.view.View[6]/android.view.View/android.view.View")
    private List<WebElement> journeys;
    
    public int userDateSplit(int index) throws IOException { //DD/MM/YYYY splitter will save under index 0,1 and 2 
    	Util_PropertyConfig prop = new Util_PropertyConfig();
    	String splitDate[] = prop.propertyFetch("journyDate").split(",");
    	int converToInt = Integer.parseInt(splitDate[index]);
		return converToInt;	    	
    }
          
    public String getMonthHeading() throws InterruptedException { //returns month name heading in app ex:February 2024
    	Thread.sleep(2000);
    	String monthHeadingtext =monthHeading.get(0).getAttribute("content-desc");
		return monthHeadingtext;  	
    }

    public int getMonthNumber() throws InterruptedException {  //returns month in number ex: If month is February in calendar widget it return 2
    	String monthName = getMonthHeading().substring(0,getMonthHeading().length()-5);
        Month month = Month.valueOf(monthName.toUpperCase());
        String monthNumeric = String.format("%02d", month.getValue());
        int monthNumber = Integer.parseInt(monthNumeric);
        return monthNumber;
    }
    
    public String getDayOfWeek() throws IOException { //todays day of the week is shown
    	LocalDate date = LocalDate.of(userDateSplit(2), userDateSplit(1), userDateSplit(0));
    	String day = date.format(DateTimeFormatter.ofPattern("E", Locale.ENGLISH));
    	return day;
    }
    
    public int getMonth(String dateText) { //get month from date text to handle between months in integer ex:Sunday, March 31, 2024
    	String[] splitText = dateText.split(",");
		int length = splitText[1].length()-2;  
        Month monthName = Month.valueOf(splitText[1].substring(0,length).replace(" ","").toUpperCase());
        String monthNumeric = String.format("%02d", monthName.getValue());
        int monthNumber = Integer.parseInt(monthNumeric);
        return monthNumber;  
    }
    
    public int getDate(String dateText) { //app text date in integer
    	int length = dateText.length();  
    	String text = dateText.substring(length-8,length-6).replace(" ","");
        int converToInt = Integer.parseInt(text);
    	return converToInt;
    }
    
    public int week(String weekDay){  
    	if(weekDay.contains("Sun")) {
    		return 1;
    	}else if(weekDay.contains("Mon")) {
        	return 2;
    	}else if(weekDay.contains("Tue")) {
        	return 3;
    	}else if(weekDay.contains("Wed")) {
        	return 4;
    	}else if(weekDay.contains("Thu")) {
        	return 5;
    	}else if(weekDay.contains("Fri")) {
        	return 6;
    	}else {
    		return 7;
    	}
    }
    
    public WebElement dateElement(int dayIndex){ //return required date web element for action
    String element = "//android.view.View[5]/android.view.View/android.view.View/android.view.View["+dayIndex+"]";
	return driver.findElement(By.xpath(element));
    }
       
    public void calenderScrollRight() {   
    	calenderScroll(calendersection,936,474,100,474);
    }
    
    public void calenderScrollLeft() {
    	calenderScroll(calendersection,100,474,936,474);
    }
    
    public void calenderAction() throws IOException, InterruptedException  {   
    	 int index = week(getDayOfWeek());
    	 int userMonth = userDateSplit(1);
    	 int userDate = userDateSplit(0);   	 
    	   while(userMonth!=getMonthNumber()) {
    		   if (userMonth==getMonth(dateElement(index).getAttribute("content-desc"))) { // checked to handle dates of 2 months are display in 1 screen
    			   dateElement(index).click();
    		   }else {
    	   			if(userDateSplit(1)>getMonthNumber()){
    	   					calenderScrollRight();
    	   			}else{
    	   					calenderScrollLeft();
    	   			}
    	   			Thread.sleep(1000);    	   			
    	   		}
    	   }
    	if (userMonth==getMonthNumber()) { 	
    			while (userDate!=getDate(dateElement(index).getAttribute("content-desc"))) {
    				if (userDate>getDate(dateElement(index).getAttribute("content-desc"))) {
	            	calenderScrollRight();
    				} else {
	            	calenderScrollLeft();
    				}
    				Thread.sleep(1000);    	   
    			}
	        dateElement(index).click();
    	   	Thread.sleep(2000);  
    		
    	 } 
    	updateLog().debug("Selected the particular date provided by User");
   	}	
    
    public void startJourney() throws InterruptedException, IOException {
    	calenderAction();
    	for(int i=0;i<journeys.size();i++) {
    		if(journeys.get(i).getAttribute("content-desc").contains("Not Started")) {
				journeys.get(i).click();				
				Thread.sleep(1000);
			}else {
				journeys.get(0).click();
				Thread.sleep(2000);
			}
    	}
				
    	Thread.sleep(1000);
    	updateLog().debug("Journey started for the provided calendar date");
    }  
}
