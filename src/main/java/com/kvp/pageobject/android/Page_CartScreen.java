package com.kvp.pageobject.android;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.kvp.project.reusableutils.Util_AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_CartScreen extends Util_AndroidActions {

	AndroidDriver driver;
	public Page_CartScreen(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath = "//android.view.View/android.widget.Button")//navigate back and Place order
	private List<WebElement> buttons;
		
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.widget.ImageView[1]/android.view.View[2]")
	private WebElement increaseQty;
	 
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.widget.ImageView[1]/android.view.View[1]")
    private WebElement reduceQty;
    	   
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ImageView")
    private WebElement applyCoupon;
    
	public void changeCart() throws InterruptedException, IOException {
		increaseQty.click();
		Thread.sleep(3000);
		reduceQty.click();
		buttons.get(1).click();
		updateLog().debug("Modification of the products in cart is completed");
	}
	
	public void navigateBack() {
		buttons.get(0).click();
	}
}
