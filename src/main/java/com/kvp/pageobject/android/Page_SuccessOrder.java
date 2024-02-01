package com.kvp.pageobject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.kvp.project.reusableutils.Util_AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_SuccessOrder extends Util_AndroidActions {

	AndroidDriver driver;
	public Page_SuccessOrder(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button") //navigate back and done button 
	private List<WebElement> buttons;
	  
    
	public void placeOrder() {
		buttons.get(1).click();
	}
}
