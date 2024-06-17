package com.kvp.pageobject.android;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.kvp.project.reusableutils.Util_AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_AttendanceScreen extends Util_AndroidActions{

	AndroidDriver driver;
	public Page_AttendanceScreen(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

    @AndroidFindBy(xpath = "//android.view.View/android.view.View[11]")
    private WebElement swipeButton;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Yes\"]")
    private WebElement logConfirmYes;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"No\"]")
    private WebElement logConfirmNo;
    
    @AndroidFindBy(xpath = "//android.view.View[10]/android.view.View/android.view.View")
    private List<WebElement> logRecords;
    
    @AndroidFindBy(xpath = "//android.widget.Button")
    private WebElement navigateBack;
     
    
    public void logAttendance() throws InterruptedException {
    	calenderScroll(swipeButton,114,2233,951,2233);
    	Thread.sleep(2000);
    	logConfirmYes.click();
    	Thread.sleep(2000);
    }
	
    public void cancelLog() throws InterruptedException {
    	calenderScroll(swipeButton,114,2233,951,2233);
    	Thread.sleep(2000);
    	logConfirmNo.click();
    	Thread.sleep(2000);
    }
	
    public void verifyLog() throws InterruptedException {
    	for(int i=0;i<2;i++) {
    		logRecords.get(i).click();
    		Thread.sleep(2000);
    		navigateBack.click();
    		Thread.sleep(2000);
    	}
    }
}
