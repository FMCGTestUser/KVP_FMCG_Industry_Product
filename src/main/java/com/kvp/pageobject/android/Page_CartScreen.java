package com.kvp.pageobject.android;

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
	@AndroidFindBy(xpath = "//android.widget.ImageView/android.view.View[1]")
	private List<WebElement> deleteCartItem;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Yes\"]")
	private WebElement popUpYes;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"No\"]")
	private WebElement popUpNo;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView/android.view.View[2]")
	private List<WebElement> reduceQty;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView/android.view.View[3]")
	private List<WebElement> increaseQty;
		
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Apply Product Schemes\"]")
	private List<WebElement> productSchemes;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add More Products\"]")
	private WebElement addMore;
	 
    @AndroidFindBy(xpath = "//android.view.View/android.view.View[2]/android.view.View[4]")
    private WebElement deleteScheme;
    	   
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ImageView")
    private WebElement applyScheme;
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.Button")//navigate back and Place order
	private List<WebElement> buttons;
    
    public void modifyCart() throws InterruptedException {
    for(int i=0;i<deleteCartItem.size();i++) {
    	increaseQty.get(i).click();
    	Thread.sleep(1000);
    	increaseQty.get(i).click();
    	Thread.sleep(1000);
    	reduceQty.get(i).click();
    	productSchemes.get(i).click();
    	driver.switchTo().defaultContent();
    	deleteCartItem.get(0).click();
    	if(i==0) {
    		popUpYes.click();
    	}else {
    		popUpNo.click();
    	}
    }    	
	}
    
    public void addMoreProduct() {
    	addMore.click();
	}
    
    public void removeScheme() {
    	deleteScheme.click();
	}
    
    public void applyScheme() {// full implementation not done.
    	applyScheme.click();
	}
    
	public void navigateBack() {
		buttons.get(0).click();
	}
	
	public void placeOrder() {
		buttons.get(1).click();
	}
}
