package com.kvp.pageobject.android;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.kvp.project.reusableutils.Util_AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_AccountDetails extends Util_AndroidActions{

	AndroidDriver driver;	
	
	public Page_AccountDetails(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[1]")
	    private WebElement detailsTab;
	    
	    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[2]")
	    private WebElement journeysTab;
	    
	    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[3]")
	    private WebElement checkInTab;
	    
	    @AndroidFindBy(xpath = "//android.view.View/android.view.View[3]//android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")
	    private List<WebElement> checkInRecords;
	    
	    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[4]")
	    private WebElement ordersTab;
	    
	    @AndroidFindBy(xpath = "//android.view.View/android.view.View[3]//android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")
	    private List<WebElement> orderRecords;
	    
	    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[5]")
	    private WebElement filesTab;
	    
	    @AndroidFindBy(xpath = "//android.widget.ImageView")
	    private List<WebElement> fileRecords;
	    
	    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]") //correct in new build
	    private WebElement googleMap;
	    
	    @AndroidFindBy(xpath = "//android.widget.Button")//navigate back and edit account
	    private List<WebElement> buttons;
	    
	    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Edit Account Details\"]")
	    private WebElement editAccount; 
	    
		public void editAccount() throws InterruptedException, IOException {	
			editAccount.click();
			Thread.sleep(2000);
			updateLog().debug("Edit Account Details clicked");
		}
		
		public void viewTabs() throws InterruptedException, IOException {
			journeysTab.click();
			checkInTab.click();
			checkInNavigation();
			ordersTab.click();
			orderNavigation();
			filesTab.click();
			fileNavigation();
			updateLog().debug("Verified all the tabs");
		}	
		
		public void checkInNavigation() throws InterruptedException, IOException {
			for(int i=0;i<checkInRecords.size();i++) {
				Page_CheckInDetail checkin = new Page_CheckInDetail(driver);
				if(checkInRecords.get(i).getAttribute("content-desc").contains("In Progress")) {
					checkInRecords.get(i).click();
					Thread.sleep(5000);
					checkin.checkOut();
					checkin.navigateBack();
				}else {
					checkInRecords.get(i).click();
					Thread.sleep(5000);
					checkin.navigateBack();
				}
			}
		}
		
		public void orderNavigation() throws InterruptedException {
			for(int i=0;i<orderRecords.size();i++) {
				orderRecords.get(i).click();
				Thread.sleep(5000);
				navigateBack();
			}
			
		}
		
		public void fileNavigation() throws InterruptedException {
			for(int i=0;i<fileRecords.size();i++) {
				fileRecords.get(i).click();
				Thread.sleep(2000);
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
			}
		}
		
		public void navigateBack() {
			buttons.get(0).click();
		}
}
