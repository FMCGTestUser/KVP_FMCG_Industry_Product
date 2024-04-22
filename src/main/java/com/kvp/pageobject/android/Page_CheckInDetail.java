package com.kvp.pageobject.android;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.kvp.project.reusableutils.Util_AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_CheckInDetail extends Util_AndroidActions{

	AndroidDriver driver;
	public Page_CheckInDetail(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
    private WebElement mapConfirmation;
    
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View[1]/android.view.View[1]")
    private WebElement detailsTab;
    
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View[1]/android.view.View[2]")
    private WebElement ordersTab;
    
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View[1]/android.view.View[3]")
    private WebElement filesTab;
    
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]")
    private WebElement googleMap;
    
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[8]")
    private WebElement playIcon;
    
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[9]")
    private WebElement pauseIcon;
    
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[10]")
    private WebElement restartIcon;
    
    @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.Button")//returns 3 element navigate back, cancel and check-in
	private List<WebElement> buttons;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Create Order\"]")
    private WebElement createOrder;
  
    
	public void checkIn() throws InterruptedException, IOException {
		if(mapConfirmation.isDisplayed()) {
			mapConfirmation.click();
		}
		Thread.sleep(2000);
		googleMap.click();
		Thread.sleep(2000);
		doubleClick(googleMap);
		playIcon.click();
		Thread.sleep(2000);
		pauseIcon.click();
		Thread.sleep(2000);
		restartIcon.click();
		buttons.get(2).click();
		updateLog().debug("Check-In done and navigated to Product list");
	}
	
	public void checkOut() throws InterruptedException, IOException {
		if(mapConfirmation.isDisplayed()) {
			mapConfirmation.click();
		}
		Thread.sleep(2000);
		googleMap.click();
		Thread.sleep(2000);
		doubleClick(googleMap);
		playIcon.click();
		Thread.sleep(2000);
		pauseIcon.click();
		Thread.sleep(2000);
		restartIcon.click();
		buttons.get(1).click();
		updateLog().debug("Check-Out done and navigated to No Orders");
	}	
	
	public void createOrder() throws InterruptedException, IOException {
		ordersTab.click();
		Thread.sleep(2000);
		createOrder.click();
		updateLog().debug("Order creation initiated");
	}	
	
	public void cancelJourney() throws IOException {
		buttons.get(1).click();
		updateLog().debug("Journey cancelled successfullly ");
	}	
	
	public void navigateBack() {
		buttons.get(0).click();
	}	
}
