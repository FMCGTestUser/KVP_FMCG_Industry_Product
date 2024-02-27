package com.kvp.pageobject.android;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.kvp.project.reusableutils.Util_AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_CouponsScreen extends Util_AndroidActions {
	AndroidDriver driver;
	public Page_CouponsScreen(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View/android.view.View[1]/android.widget.Button")
	private WebElement navigateBack;
	
    @AndroidFindBy(xpath = "/android.view.View/android.view.View[2]/android.view.View")
    private List<WebElement> couponCode;
    
	public void selectCoupon() throws IOException {
		couponCode.get(2).click();
		updateLog().debug("Coupon selected and applied");
	}
}
