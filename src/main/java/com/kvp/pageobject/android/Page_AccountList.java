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

public class Page_AccountList extends Util_AndroidActions {
	
	AndroidDriver driver;
	public Page_AccountList(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView")
	private WebElement searchAccount;

	@AndroidFindBy(xpath = "//android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")
	private List<WebElement> accounts;
	
	@AndroidFindBy(xpath = "//android.widget.Button")
	private List<WebElement> buttons; //navigate back and add New account button
	
	public void searchAccounts(HashMap<String, String> input, int index) throws InterruptedException, IOException {	
		int accountNum=index+1;							//name starts from 1 but index starts from zero.
		searchAccount.click();
		searchAccount.clear();
		searchAccount.sendKeys(input.get("accountName"+accountNum));
		int size = accounts.size();
		if(size==0) {
			org.testng.Assert.fail("Entered product "+input.get("accountName"+accountNum)+" not in search list test is failed.");
		}else if(accounts.get(0).getAttribute("content-desc").contains(input.get("accountName"+accountNum))) {
			accounts.get(0).click();
			Thread.sleep(2000);//wait to next page image load
		}
		updateLog().debug("Searched user provided Account and selected the same");
	}
	
	public void selectAccount(int index) throws IOException, InterruptedException {	
		searchAccounts(getIndexData().get(getIndexData().size()-1), index);
	}

	public void addAccount() throws IOException, InterruptedException {
		buttons.get(1).click();
		Thread.sleep(4000);
		updateLog().debug("Add New Account clicked on Account Details screen");
	}
}
