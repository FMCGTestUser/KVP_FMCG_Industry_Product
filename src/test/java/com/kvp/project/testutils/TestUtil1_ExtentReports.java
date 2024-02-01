package com.kvp.project.testutils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestUtil1_ExtentReports {
	
	public static ExtentReports getReporterObject()
	{		
		String path =System.getProperty("user.dir")+"//Test_Reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("FMCG Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		ExtentReports extent =new ExtentReports();
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Prasad poojary");
		return extent;		
	}	
}
