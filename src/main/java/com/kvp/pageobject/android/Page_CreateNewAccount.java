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

public class Page_CreateNewAccount extends Util_AndroidActions {
	
	AndroidDriver driver;
	public Page_CreateNewAccount(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
	private WebElement mapConfirmation;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement accountName;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement firstName;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[3]")
	private WebElement lastName;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[4]")
	private WebElement phoneNo;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")//based on the scroll index varies so 3 scroll done and index verified and updated
	private WebElement email;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[3]")
	private WebElement alternatePhone;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[4]")
	private WebElement gstNo;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[5]")
	private WebElement panNo;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement webURL;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[3]")
	private WebElement street;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Country\"]/android.view.View")
	private WebElement country;	
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"India\"]")
	private WebElement selectCountry;	
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"State\"]/android.view.View")
	private WebElement state;	
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Karnataka\"]")
	private WebElement selectState;	
		
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"City\"]/android.view.View")
	private WebElement city;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mangaluru\"]")
	private WebElement selectCity;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Zipcode\"]/android.view.View")
	private WebElement zipCode;	
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"560099\"]")
	private WebElement selectZipCode;	
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Supplier\"]/android.view.View")
	private WebElement supplier;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Test QA\"]")
	private WebElement selectSupplier;
	
	@AndroidFindBy(xpath = "//android.widget.Button")
	private List<WebElement> navigateBack; //navigate back and create account button
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Create Account\"]")
	private WebElement createAccount;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Update Account\"]")
	private WebElement updateAccount;
	
    public void mapConfirmation() throws InterruptedException, IOException {
    	if(mapConfirmation.isDisplayed()) {
			mapConfirmation.click();
			Thread.sleep(2000);
			updateLog().debug("Google map pop up selected");
		}
    }
    
	public void createAccounts() throws IOException {	
		accountName.click();
		accountName.sendKeys("FMCG Test Account");
		firstName.click();
		firstName.sendKeys("FMCG");
		lastName.click();
		lastName.sendKeys("QA");
		phoneNo.click();
		phoneNo.sendKeys("9988997799");
		scrollActionsRandom("down",5.0);
		email.click();
		email.sendKeys("fmcgtest@gmail.com");
		alternatePhone.click();
		alternatePhone.sendKeys("8899776655");
		gstNo.click();
		gstNo.sendKeys("07AAAAA1234A1Z1");
		panNo.click();
		panNo.sendKeys("CPHTT6565M");
		scrollActionsRandom("down",5.0);
		webURL.click();
		webURL.sendKeys("www.test.com");
		street.click();
		street.sendKeys("Lalbagh");
		country.click();
		selectCountry.click();	
		state.click();
		selectState.click();
		scrollActionsRandom("down",3.0);	
		city.click();
		selectCity.click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		zipCode.click();
		selectZipCode.click();
		supplier.click();
		selectSupplier.click();	
		createAccount.click();
		updateLog().debug("New account created successfully");
	}
	
	public void updateAccounts() throws IOException {	
		String accName= accountName.getText();
		accountName.sendKeys(accName+" Edited");
		scrollActionsRandom("down",5.0);
		alternatePhone.click();
		alternatePhone.sendKeys("8899776655");
		scrollActionsRandom("down",5.0);
		country.click();
		selectCountry.click();	
		state.click();
		selectState.click();
		scrollActionsRandom("down",3.0);	
		city.click();
		selectCity.click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		zipCode.click();
		selectZipCode.click();
		createAccount.click();
		updateLog().debug("Account details edited and updated successfully");
	}
	
	public void navigateBack() {
		navigateBack.get(0).click();
	} 
}
