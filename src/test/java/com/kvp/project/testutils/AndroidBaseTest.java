package com.kvp.project.testutils;

import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.kvp.project.reusableutils.Util_AppiumConfig;
import com.kvp.project.reusableutils.Util_Log4jConfig;
import com.kvp.project.reusableutils.Util_PropertyConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class AndroidBaseTest extends Util_AppiumConfig{

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

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
		driver = new AndroidDriver(appiumServerURL, capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
    	Util_Log4jConfig log=new Util_Log4jConfig();
		log.testLogs().debug("Appium server initialization completed");
    
		}
		catch (Exception e) {
								System.out.println("Cause is"+e.getCause());
								System.out.println("Message is"+e.getMessage());
							}
		}
	
	


	
	@AfterClass(alwaysRun=true) //independent of any tags 
	public void tearDown()
	{
		if(driver != null) {driver.quit();}
		if(service!=null) {service.stop();}     
	}
	
}
