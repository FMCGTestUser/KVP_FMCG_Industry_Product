package com.kvp.pageobject.android;

import java.io.IOException;
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

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.android.permissioncontroller:id/grant_dialog\"]")
	private WebElement mapCheck;
	    
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
	private WebElement mapConfirmation;
	    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Open navigation menu\"]")
	private WebElement drawerMenu; 
	
    @AndroidFindBy(xpath ="//android.widget.ImageView[2]")//home added it will be 2 and rest will increment accordingly
    private WebElement home;
    
    @AndroidFindBy(xpath ="//android.widget.ImageView[3]")
    private WebElement accounts;
	
    @AndroidFindBy(xpath ="//android.widget.ImageView[4]")
    private WebElement journeys;
    
    @AndroidFindBy(xpath ="//android.widget.ImageView[5]")
    private WebElement attendance;
    
    @AndroidFindBy(xpath ="//android.widget.ImageView[6]")
    private WebElement logout;
    
    @AndroidFindBy(xpath ="//android.widget.Button[@content-desc=\"Yes\"]")
    private WebElement confirmation;
    
    public void viewHome() throws IOException, InterruptedException {
    	drawerMenu.click();
    	home.click();
    	Thread.sleep(2000);
    	updateLog().debug("Home menu selected");
    }
    
    public void viewJourney() throws IOException {
    	drawerMenu.click();
    	journeys.click();
    	updateLog().debug("Journey menu selected");
    }
    
    public void viewAttendance() throws IOException, InterruptedException {
    	drawerMenu.click();
    	attendance.click();
    	Thread.sleep(2000);
    	updateLog().debug("Attendance menu selected");
    }
    
    public void viewAccount() throws IOException, InterruptedException {
    	drawerMenu.click();
    	accounts.click();
    	Thread.sleep(2000);
    	updateLog().debug("Accounts menu selected");
    }
    
    public void logout() throws IOException, InterruptedException{
    	drawerMenu.click();
    	logout.click();
    	Thread.sleep(2000);
    	confirmation.click();
    	updateLog().debug("User logged out successfuly");
    }
    
    public void skipMapPopup() throws IOException, InterruptedException{
    	if(mapCheck.isDisplayed()) {
    		mapConfirmation.click();
    	}
    	Thread.sleep(2000);
    	updateLog().debug("User Skipped the location pop-up in Dashboard screen");
    }
}
