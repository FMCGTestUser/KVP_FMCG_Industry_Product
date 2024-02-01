package com.kvp.project.reusableutils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Util_AppiumConfig {
	
	public AppiumDriverLocalService service;
			
	public AppiumDriverLocalService startAppiumServer(String ipAddress,int port,String appiumJsFile) throws IOException{	
			service =new AppiumServiceBuilder().withAppiumJS(new File(appiumJsFile)).withIPAddress(ipAddress).usingPort(port).build();
			service.start();
			return service;
	}
	
	 public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		 	File myfile=new File(filePath);
		 	String	jsonContent = FileUtils.readFileToString(myfile);
	        ObjectMapper mapper = new ObjectMapper();
	        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
			return data;
	    }
	 
	 public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException{
		 	File sourceFile=driver.getScreenshotAs(OutputType.FILE);
		 	File destinationFile =new File(System.getProperty("user.dir")+"//Test_Reports//Screen Shots//"+testCaseName+".png");
		 	FileUtils.copyFile(sourceFile,destinationFile);
			return destinationFile.toString();
		 	
	    }
}