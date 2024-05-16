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

public class Page_AccountCreateNew extends Util_AndroidActions {
	
	AndroidDriver driver;
	public Page_AccountCreateNew(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]")
	private WebElement mapConfirmation;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement accountName;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Primary Supplier\"]/android.view.View")
	private WebElement primarySupplier;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mobile Planet\"]")
	private WebElement selectSupplier;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Account Type *\"]/android.view.View")
	private WebElement accountType;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Wholesaler\"]")
	private WebElement selectType;	

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement gstNo;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement panNo;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[3]")
	private WebElement firstName;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[4]")
	private WebElement lastName;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[5]")
	private WebElement phoneNo;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")//based on the scroll index varies 
	private WebElement email;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[3]")
	private WebElement alternatePhone;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[4]")
	private WebElement webURL;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[3]")
	private WebElement address1;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[4]")
	private WebElement address2	;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Country *\"]/android.view.View")
	private WebElement country;	
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"India\"]")
	private WebElement selectCountry;	
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"State *\"]/android.view.View")
	private WebElement state;	
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Karnataka\"]")
	private WebElement selectState;	
		
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"City *\"]/android.view.View	")
	private WebElement city;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mangaluru\"]")
	private WebElement selectCity;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Zipcode *\"]/android.view.View")
	private WebElement zipCode;	
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"560099\"]")
	private WebElement selectZipCode;	
	
	@AndroidFindBy(xpath = "//android.widget.Button")
	private List<WebElement> navigateBack; //navigate back and create account button
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Create Account\"]")
	private WebElement createAccount;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Save\"]")
	private WebElement saveAccount;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
	private WebElement confirmation;
	
	
    public void mapConfirmation() throws InterruptedException, IOException {
    	if(mapConfirmation.isDisplayed()) {
			mapConfirmation.click();
			Thread.sleep(2000);
			updateLog().debug("Google map pop up selected");
		}
    }
    
	public void createAccounts() throws IOException, InterruptedException {	
		accountName.click();
		accountName.sendKeys("FMCG Test Account");
		primarySupplier.click();
		selectSupplier.click();	
		accountType.click();
		selectType.click();
		gstNo.click();
		gstNo.sendKeys("07AAAAA1234A1Z1");
		scrollActionsRandom("down",5.0);
		panNo.click();
		panNo.sendKeys("CPHTT6565M");
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
		webURL.click();
		webURL.sendKeys("https://dev.kuiqly.com");			
		scrollActionsRandom("down",4.0);	
		address1.click();
		address1.sendKeys("Lalbagh near KSRTC");
		address2.click();
		address2.sendKeys("street no. 50");
		country.click();
		selectCountry.click();	
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		state.click();
		selectState.click();
		city.click();
		selectCity.click();
		zipCode.click();
		selectZipCode.click();
		createAccount.click();
		Thread.sleep(3000);
		updateLog().debug("New account created successfully");
	}
	
	public void updateAccounts() throws IOException {	
		String accName= accountName.getText();
		accountName.click();
		accountName.clear();
		accountName.sendKeys(accName+" Edited");
		scrollActionsRandom("down",5.0);
		phoneNo.click();
		phoneNo.clear();
		phoneNo.sendKeys("9035429235");
		scrollActionsRandom("down",5.0);
		scrollActionsRandom("down",4.0);	
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		address2.click();
		address2.clear();
		address2.sendKeys("street no. 50,near to ideal cafe");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		saveAccount.click();
		confirmation.click();
		updateLog().debug("Account details edited and updated successfully");
	}
	
	public void navigateBack() {
		navigateBack.get(0).click();
	} 
}
