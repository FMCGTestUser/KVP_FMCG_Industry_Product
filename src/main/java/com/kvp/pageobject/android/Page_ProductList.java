package com.kvp.pageobject.android;


import java.io.IOException;
import java.util.HashMap;
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
    
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.widget.ImageView")
    private List<WebElement> products;
	
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ImageView[2]")
    private List<WebElement> cart;
    

	public void searchProducts(HashMap<String, String> input, int index) throws InterruptedException {	
			int prodNum=index+1;							//name starts from 1 but index starts from zero.
			searchProduct.get(0).click();
			searchProduct.get(0).clear();
			searchProduct.get(0).sendKeys(input.get("productName"+prodNum));
			if(products.get(index).getAttribute("content-desc").contains(input.get("productName"+prodNum))) {
				products.get(index).click();
				Thread.sleep(2000);//wait to next page image load
			}else {
			org.testng.Assert.fail("Entered product not in search list test is failed.");
			}
	}
	
	public void selectProduct(int index) throws IOException, InterruptedException {	
		searchProducts(getIndexData().get(getIndexData().size()-1), index);
	}
	
	public void viewCart() {
		cart.get(1).click();
	}
}
