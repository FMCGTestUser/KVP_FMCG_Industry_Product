package com.kvp.project.testutils;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.kvp.project.reusableutils.Util_AppiumConfig;
import io.appium.java_client.android.AndroidDriver;

public class TestUtil2_Listeners extends Util_AppiumConfig implements ITestListener{
	ExtentTest test;
	ExtentReports extent = TestUtil1_ExtentReports.getReporterObject();
	AndroidDriver driver;
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test= extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot code
		test.fail(result.getThrowable());
		try {
				driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver")
						.get(result.getInstance());	
			} catch (Exception e1) {
			e1.printStackTrace();
			} 
		  
		try {
			if (driver != null) {
				test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
			}else {
		           System.out.println("Driver is not initialized. Cannot capture screenshot.");
		        }} catch (IOException e) {
			e.printStackTrace();
			}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}	
}
