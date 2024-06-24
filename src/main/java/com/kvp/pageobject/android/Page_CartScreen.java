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
	@AndroidFindBy(xpath = "//android.widget.ImageView/android.view.View[]")
	private List<WebElement> editCartItem;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView/android.view.View[2]")
	private List<WebElement> deleteCartItem;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Yes\"]")
	private WebElement popUpYes;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"No\"]")
	private WebElement popUpNo;
		
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Apply Product Schemes\"]")
	private List<WebElement> viewProductSchemes;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add More Products\"]")
	private WebElement addMoreProduct;
	 
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"View Eligible Schemes\"]")
    private WebElement viewOrderSchemes;
	
    @AndroidFindBy(xpath = "//android.view.View/android.widget.Button")//navigate back and Place order
	private List<WebElement> buttons;
    
    public void modifyCart() throws InterruptedException {
    for(int i=0;i<deleteCartItem.size();i++) {
    	deleteCartItem.get(i).click();
    	if(i==0) {
    		popUpYes.click();
    	}else {
    		popUpNo.click();
    	}
    }    	
	}
    
    public void editCart() {
   
	}
    
    public void addMoreProduct() {
    	addMoreProduct.click();
	}
    
    public void removeScheme() {
    	
	}
    
    public void applyScheme() {// full implementation not done.
    
	}
    
	public void navigateBack() {
		buttons.get(0).click();
	}
	
	public void placeOrder() {
		buttons.get(1).click();
	}
}
