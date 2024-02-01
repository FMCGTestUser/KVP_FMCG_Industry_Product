package com.kvp.pageobject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.kvp.project.reusableutils.Util_AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_SelectScheme extends Util_AndroidActions {

	AndroidDriver driver;
	public Page_SelectScheme(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.CheckBox")
    private List<WebElement> selectSchemes;
	   
	public void selectScheme() {
		System.out.println(selectSchemes.get(1).isDisplayed()+"selectSchemes");
		selectSchemes.get(1).click();
	}
}
