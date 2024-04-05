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
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ScrollView/android.widget.Button")
	private List<WebElement> selections;
	
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Green\"]")
    private WebElement selectColor;
    
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"XL\"]")
    private WebElement selectSize;
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ScrollView/android.widget.Button[4]")
    private WebElement increaseQty;
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ScrollView/android.widget.Button[3]")
    private WebElement reduceQty;
    
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Silk\"]")
    private WebElement selectMaterial;
    
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Piece\"]")
    private WebElement selectUOM;
    
    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View")
    private WebElement commonSelection;
    
    @AndroidFindBy(xpath = "//android.view.View/android.widget.Button")// 4 button navigate back 1st and add to cart button 4th
	private List<WebElement> buttons;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
    private WebElement popUp;
    
   
    public String findSelection(int index) {
    	String description = selections.get(index).getAttribute("content-desc");
    	return description;
    }
    
	public void selectDetails() throws InterruptedException, IOException {
		productImages.get(0).click();
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		productImages.get(1).click();
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		scrollActionsRandom("down",3.0);
		for(int i=0;i<selections.size();i++) {
			if(findSelection(i).equalsIgnoreCase("Select Color")) {
				selections.get(i).click();
				selectColor.click();		
			}else if(findSelection(i).equalsIgnoreCase("Select Material")) {
				selections.get(i).click();
				selectMaterial.click();		
			}else if(findSelection(i).equalsIgnoreCase("Select Product UOM")) {
				selections.get(i).click();
				selectUOM.click();		
			}else if(findSelection(i).equalsIgnoreCase("Select Size")) {
				selections.get(i).click();
				selectSize.click();		
			}else {
				selections.get(i).click();
			}	
			Thread.sleep(1000);
		}
		buttons.get(3).click();
		popUp.click();
		updateLog().debug("Required product selected and added to the cart");
	}
	
	public void navigateBack() {
		buttons.get(0).click();
	}  
}
