package com.kvp.testcases.Android;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_LoginScreen;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC2_LoginScreenTest extends AndroidBaseTest{
	

	@Test(dataProvider="getData", groups = {"Smoke"})
	public void loginScreenTest(HashMap<String, String> input) throws InterruptedException, IOException  {
		Page_LoginScreen signin = new Page_LoginScreen(driver);
		signin.login(input.get("userName"),input.get("password"));
		Thread.sleep(1000);
		preSetup("com.example.field_sales_app.MainActivity");  //adb shell dumpsys window windows---command
		Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		   Object[][] dataArray = new Object[getIndexData().size()-1][1] ; //HashMap has 1 column with key-value pair
	        for (int i = 0; i<getIndexData().size()-1; i++) {			 //Last value in JSON is product name so size-1 
	            dataArray[i][0] = getIndexData().get(i);
	        }
			return dataArray;
	}
}
