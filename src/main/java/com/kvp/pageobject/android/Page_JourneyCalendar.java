package com.kvp.pageobject.android;


import java.time.LocalDate;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.kvp.project.reusableutils.Util_AndroidActions;
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
	private WebElement monthHeading;
	
    @AndroidFindBy(xpath = "//android.view.View[5]/android.view.View/android.view.View/android.view.View[4]")
    private WebElement calenderDate;
    
    @AndroidFindBy(xpath = "//android.view.View[5]/android.view.View/android.view.View")
    private WebElement calendersection;
    
    @AndroidFindBy(xpath = "//android.view.View/android.view.View[6]")
    private List<WebElement> startAction;
    
    @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.Button")
	private WebElement drawerMenu;
    
        
	public String getYear() {
    	LocalDate currentDate=LocalDate.now();
    	String localYear =currentDate.toString().substring(0, 4);
    	return localYear;
    }
        
    public String getDate() {
    	LocalDate currentDate=LocalDate.now();
    	String localDate =currentDate.toString().substring(5,7);
    	System.out.println(localDate+"substring date");
    	if(localDate.startsWith("0")) {
    		return localDate.substring(1);
    	}
    		return localDate;
    }

    public String getMonthHeading() {
    	String monthHeadingtext =monthHeading.getAttribute("content-desc");
		return monthHeadingtext;  	
    }

    public String getMonth() {
    	String month = getMonthHeading().substring(0,getMonthHeading().length()-5);
    	return month;
    }
    
    public void startJourney() throws InterruptedException {
    	startAction.get(1).click();
    	Thread.sleep(5000);
    } 
}
