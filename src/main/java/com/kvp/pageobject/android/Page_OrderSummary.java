package com.kvp.pageobject.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.kvp.project.reusableutils.Util_AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_OrderSummary extends Util_AndroidActions {

	AndroidDriver driver;
	public Page_OrderSummary(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Done\"]")
	private WebElement doneButton;
	  
	public void completeOrder() {
		doneButton.click();
	}
}
