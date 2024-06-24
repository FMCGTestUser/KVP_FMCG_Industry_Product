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

public class Page_CheckInDetail extends Util_AndroidActions{

	AndroidDriver driver;
	public Page_CheckInDetail(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
    
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View[1]/android.view.View[1]")
    private WebElement detailsTab;
    
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View[1]/android.view.View[2]")
    private WebElement ordersTab;
    
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View[1]/android.view.View[3]")
    private WebElement filesTab;
    
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]")
    private WebElement googleMap;
    
    @AndroidFindBy(xpath = " //android.widget.EditText")
    private WebElement notes;
    
    @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.Button")//returns 3 element navigate back, cancel and check-in
	private List<WebElement> buttons;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
	private WebElement popupConfirm;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Create Order\"]")
    private WebElement createOrder;
  
    
	public void checkIn() throws InterruptedException, IOException {
		googleMap.click();
		Thread.sleep(2000);
		doubleClick(googleMap);
		notes.click();
		notes.sendKeys("Visited client site and successfully completed check-in.");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		buttons.get(1).click();
		Thread.sleep(4000);
		popupConfirm.click();
		updateLog().debug("Check-In done successfully");
	}
	
	public void checkOut() throws InterruptedException, IOException {
		googleMap.click();
		Thread.sleep(2000);
		doubleClick(googleMap);
		buttons.get(2).click();
		Thread.sleep(4000);
		popupConfirm.click();
		updateLog().debug("Check-Out done successfully");
	}	
	
	public void createOrder() throws InterruptedException, IOException {
		ordersTab.click();
		Thread.sleep(2000);
		createOrder.click();
		updateLog().debug("Order creation initiated");
	}	
	
	public void cancelJourney() throws IOException, InterruptedException {
		notes.click();
		notes.sendKeys("No orders were accepted at the visited customer place due to unavailability of desired products/services");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		buttons.get(1).click();
		Thread.sleep(2000);
		popupConfirm.click();
		updateLog().debug("Journey cancelled successfullly ");
	}	
	
	public void viewDetailsTab() throws InterruptedException{
		detailsTab.click();
		Thread.sleep(2000);
	}
	
	public void viewFilesTab() throws InterruptedException{
		filesTab.click();
		Thread.sleep(2000);
	}
	
	public void navigateBack() {
		buttons.get(0).click();
	}	
}
