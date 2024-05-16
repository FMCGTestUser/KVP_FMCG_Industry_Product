package com.kvp.pageobject.android;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.kvp.project.reusableutils.Util_AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_LoginScreen extends Util_AndroidActions {

	AndroidDriver driver;
	public Page_LoginScreen(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath ="//android.widget.EditText[1]")
	private WebElement userName;
	
	@AndroidFindBy(xpath ="//android.widget.EditText[2]")
	private WebElement userPassword;
	
	@AndroidFindBy(xpath ="//android.widget.Button")
	private WebElement viewPassword;
	
	@AndroidFindBy(xpath ="//android.widget.Button[@content-desc=\"Sign In\"]")
	private WebElement signInButton;
	
	public void login(String name,String password) throws InterruptedException, IOException {	
		userName.click();
		Thread.sleep(2000);
		userName.sendKeys(name);
		Thread.sleep(1000);
		userPassword.click();
		userPassword.sendKeys(password);
		Thread.sleep(1000);
		signInButton.click();
		updateLog().debug("User logged in Successfully");
	}
}
