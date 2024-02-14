package com.kvp.pageobject.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.kvp.project.reusableutils.Util_AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_NoOrder extends Util_AndroidActions {
	
	AndroidDriver driver;
	public Page_NoOrder(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View[1]/android.widget.Button")
	private WebElement navigateBack;
	
	@AndroidFindBy(xpath = "//android.view.View/android.widget.CheckBox[1]")
	private WebElement optionCheck;
	
    @AndroidFindBy(xpath = "//android.view.View/android.widget.EditText")
    private WebElement reasonEntry;
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.Button")
    private WebElement submitButton;

	public void orderReason() {
		optionCheck.click();
		reasonEntry.click();
		reasonEntry.sendKeys("No orders were accepted at the visited customer place due to unavailability of desired products/services");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		submitButton.click();
	}
}
