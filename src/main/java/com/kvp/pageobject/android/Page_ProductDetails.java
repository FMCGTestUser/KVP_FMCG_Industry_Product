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
	
	@AndroidFindBy(xpath = "//android.view.View/android.widget.ImageView")
    private WebElement productImages;
    
    @AndroidFindBy(xpath = "//android.widget.Button")
	private List<WebElement> selections;
    
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Grams\"]")
    private WebElement selectUOM;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Add To Cart\"]")
    private WebElement addToCart;
	
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
    private WebElement popUp;
    
    /*@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Green\"]")
    private WebElement selectColor;
    
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"XL\"]")
    private WebElement selectSize;
    
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.Button[2]")
    private WebElement increaseQty;
    
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.Button[1]")
    private WebElement reduceQty;
    
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Silk\"]")
    private WebElement selectMaterial;
    
    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View")
    private WebElement commonSelection;
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.Button")// 4 button navigate back 1st and add to cart button 4th
	private List<WebElement> buttons;*/
    
    public String findSelection(int index) {
    	String description = selections.get(index).getAttribute("content-desc");
    	return description;
    }
    
	public void selectDetails() throws InterruptedException, IOException {
		productImages.click();
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		scrollActionsRandom("down",3.0);
		for(int i=1;i<selections.size()-1;i++) {   //zero is navigate back so not doing any action and skipping the same so i=1		
			if(findSelection(i)==""||findSelection(i)=="Read More") {
				selections.get(i).click();
			}else if(findSelection(i).equalsIgnoreCase("Select Product UOM")) {
				selections.get(i).click();
				selectUOM.click();
			}else if(i>6) {
				scrollActionsRandom("down",5.0);			
			}
			Thread.sleep(1000);
		}
		addToCart.click();
		popUp.click();
		updateLog().debug("Required product selected and added to the cart");
	}
/*			}else if(findSelection(i).equalsIgnoreCase("Select Color")) {
				selections.get(i).click();
				selectColor.click();		
			}else if(findSelection(i).equalsIgnoreCase("Select Material")) {
				selections.get(i).click();
				selectMaterial.click();					
			}else if(findSelection(i).equalsIgnoreCase("Select Size")) {
				selections.get(i).click();
				selectSize.click();		
			}else {
				selections.get(i).click();*/
			
	
	public void navigateBack() {
		selections.get(0).click();
	}  
}
