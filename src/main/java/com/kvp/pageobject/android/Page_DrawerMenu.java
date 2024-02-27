package com.kvp.pageobject.android;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.kvp.project.reusableutils.Util_AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_DrawerMenu extends Util_AndroidActions {
	
	AndroidDriver driver;
	public Page_DrawerMenu(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

    @AndroidFindBy(xpath = "//android.widget.Button")
	private List<WebElement> drawerMenu; //drawer menu and add new account button
	
    @AndroidFindBy(xpath ="//android.widget.ImageView[2]")
    private WebElement accounts;
	
    @AndroidFindBy(xpath ="//android.widget.ImageView[3]")
    private WebElement journeys;
    
    @AndroidFindBy(xpath ="//android.widget.ImageView[4]")
    private WebElement logout;
    
    public void viewJourney() throws IOException {
    	drawerMenu.get(0).click();
    	journeys.click();
    	updateLog().debug("Journey menu selected");
    }
    
    public void viewAccount() throws IOException {
    	drawerMenu.get(0).click();
    	accounts.click();
    	updateLog().debug("Accounts menu selected");
    }
    
    public void logout() throws IOException {
    	drawerMenu.get(0).click();
    	logout.click();
    	updateLog().debug("User logged out successfuly");
    }
}
