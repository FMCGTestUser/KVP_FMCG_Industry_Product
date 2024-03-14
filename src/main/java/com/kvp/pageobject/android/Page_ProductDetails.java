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

public class Page_ProductDetails extends Util_AndroidActions {

	AndroidDriver driver;
	public Page_ProductDetails(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View/android.widget.ImageView")
    private List<WebElement> productImages;
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ScrollView/android.widget.Button[1]")
	private WebElement variants;
	
    @AndroidFindBy(xpath ="//android.view.View[@content-desc=\"B\"]")
    private WebElement selectVariant;
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ScrollView/android.widget.Button[2]")
    private WebElement size;
    
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"C\"]")
    private WebElement selectSize;
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ScrollView/android.widget.Button[4]")
    private WebElement increaseQty;
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ScrollView/android.widget.Button[3]")
    private WebElement reduceQty;
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ScrollView/android.widget.Button[5]")
    private WebElement productUOM;
    
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"A\"]")
    private WebElement selectUOM;
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.Button")// 4 button navigate back 1st and add to cart button 4th
	private List<WebElement> buttons;
    
	public void selectDetails() throws InterruptedException, IOException {
		productImages.get(0).click();
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		productImages.get(1).click();
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		variants.click();
		selectVariant.click();
		size.click();
		selectSize.click();
		increaseQty.click();
		increaseQty.click();
		reduceQty.click();
		scrollActionsRandom("down",3.0);
		Thread.sleep(1000);
		productUOM.click();
		selectUOM.click();
		buttons.get(3).click();
		updateLog().debug("Required product selected and added to the cart");
	}
	
	public void navigateBack() {
		buttons.get(0).click();
	}  
}
