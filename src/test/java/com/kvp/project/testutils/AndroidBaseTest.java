package com.kvp.project.testutils;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.kvp.pageobject.android.Page_LoginScreen;
import com.kvp.project.reusableutils.Util_AppiumConfig;
import com.kvp.project.reusableutils.Util_Log4jConfig;
import com.kvp.project.reusableutils.Util_PropertyConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class AndroidBaseTest extends Util_AppiumConfig{

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@SuppressWarnings("deprecation")
	@BeforeClass(alwaysRun=true)//independent of any tags 
	public void configureAppium()
	{
	try {
		Util_PropertyConfig prop =new Util_PropertyConfig();
		startAppiumServer(prop.propertyFetch("ipAddress"),Integer.parseInt(prop.propertyFetch("port")),prop.propertyFetch("appiumJsFile"));			
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName",prop.propertyFetch("platformName"));
		capabilities.setCapability("platformVersion",prop.propertyFetch("platformVersion"));		 
		capabilities.setCapability("app",prop.propertyFetch("appPath"));
		capabilities.setCapability("deviceName", prop.propertyFetch("androidDeviceName"));
		capabilities.setCapability("automationName", prop.propertyFetch("automationName"));
		URL appiumServerURL = new URL(prop.propertyFetch("URL"));
		driver = new AndroidDriver (appiumServerURL, capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
    	Util_Log4jConfig log=new Util_Log4jConfig();
		log.testLogs().debug("Appium server initialization completed");
    
		}
		catch (Exception e) {
								System.out.println("Cause is"+e.getCause());
								System.out.println("Message is"+e.getMessage());
							}
		}
	
	public void preSetup(String activityName) throws IOException  {
		Util_PropertyConfig prop =new Util_PropertyConfig();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", prop.propertyFetch("automationName"));
		capabilities.setCapability("appPackage", "com.example.field_sales_app");
		capabilities.setCapability("appActivity", activityName);
		URL appiumServerURL = new URL(prop.propertyFetch("URL"));
		driver = new AndroidDriver (appiumServerURL, capabilities);
	}
	
	public void getLoginData() throws IOException, InterruptedException {
		loginSetup(getIndexData().get(0));
	}

	public void loginSetup(HashMap<String, String> input) throws InterruptedException  {
		Page_LoginScreen signin = new Page_LoginScreen(driver);
		signin.login(input.get("userName"),input.get("password"));
		Thread.sleep(2000);
	}
	
	@AfterClass(alwaysRun=true) //independent of any tags 
	public void tearDown()
	{
		if(driver != null) {driver.quit();}
		if(service!=null) {service.stop();}     
	}
}
