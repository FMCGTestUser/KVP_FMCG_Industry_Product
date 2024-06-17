package com.kvp.pageobject.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.kvp.project.reusableutils.Util_AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_DashboardScreen extends Util_AndroidActions{

	AndroidDriver driver;
	public Page_DashboardScreen(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
    
    @AndroidFindBy(xpath= "//android.widget.Button[@content-desc=\"Start My Day\"]")
    private WebElement startMyDay;
    
    @AndroidFindBy(xpath= "//android.widget.Button[@content-desc=\"End My Day\"]")
    private WebElement endMyDay;
    
    public void dayUpdates() throws InterruptedException {
    	startMyDay.click();
    	Thread.sleep(5000);
    	endMyDay.click();
    }
}
