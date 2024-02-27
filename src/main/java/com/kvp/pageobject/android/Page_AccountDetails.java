package com.kvp.pageobject.android;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.kvp.project.reusableutils.Util_AndroidActions;
import io.appium.java_client.android.AndroidDriver;
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
	
	    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
	    private WebElement mapConfirmation;
    
	    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[1]")
	    private WebElement detailsTab;
	    
	    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[2]")
	    private WebElement journeysTab;
	    
	    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[3]")
	    private WebElement checkInTab;
	    
	    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[4]")
	    private WebElement ordersTab;
	    
	    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[5]")
	    private WebElement filesTab;
	    
	    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]") //correct in new build
	    private WebElement googleMap;
	    
	    @AndroidFindBy(xpath = "//android.widget.Button")//navigate back and edit account
	    private List<WebElement> buttons;
	    
	    public void mapConfirmation() throws InterruptedException, IOException {
	    	if(mapConfirmation.isDisplayed()) {
				mapConfirmation.click();
				Thread.sleep(2000);
				updateLog().debug("Google map pop up selected");
			}
	    }
	    
		public void editAccount() throws InterruptedException, IOException {
			mapConfirmation();
			googleMap.click();
			Thread.sleep(2000);
			doubleClick(googleMap);
			buttons.get(1).click();
			Thread.sleep(2000);
			updateLog().debug("Edit Account Details clicked");
		}
		
		public void viewTabs() throws InterruptedException, IOException {
			journeysTab.click();
			checkInTab.click();
			ordersTab.click();
			filesTab.click();
			updateLog().debug("Verified all the tabs");
		}	
		
		public void navigateBack() {
			buttons.get(0).click();
		}
}
