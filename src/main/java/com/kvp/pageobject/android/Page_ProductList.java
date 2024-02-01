package com.kvp.pageobject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.kvp.project.reusableutils.Util_AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_ProductList extends Util_AndroidActions {

	AndroidDriver driver;
	public Page_ProductList(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View[1]/android.widget.Button")
	private WebElement navigateBack;
	
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ImageView[1]")//two elements text box and 1st product
    private List<WebElement> searchProduct;
    
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.widget.ImageView[1]")
	private WebElement product;
	
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ImageView[2]")
    private WebElement cart;
    
	public void selectProduct() {
		searchProduct.get(0).click();
		searchProduct.get(0).sendKeys("TestProcuct");
		product.click();
	}
}
