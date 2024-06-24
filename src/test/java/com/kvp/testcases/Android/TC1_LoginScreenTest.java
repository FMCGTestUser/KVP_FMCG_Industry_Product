package com.kvp.testcases.Android;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kvp.pageobject.android.Page_DrawerMenu;
import com.kvp.pageobject.android.Page_LoginScreen;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC1_LoginScreenTest extends AndroidBaseTest{
	

	@Test(dataProvider="getData", groups = {"Smoke"})
	public void loginScreenTest(HashMap<String, String> input) throws InterruptedException, IOException  {
		Page_LoginScreen signin = new Page_LoginScreen(driver);
		signin.login(input.get("userName"),input.get("password"),input.get("domain"));
		Thread.sleep(5000);
		Page_DrawerMenu drawer = new Page_DrawerMenu(driver);
		drawer.skipMapPopup();
		drawer.logout();
		preSetup("com.example.field_sales_app.MainActivity");  //adb shell dumpsys window windows---command(logout functionality not done yet)
		Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		   Object[][] dataArray = new Object[getIndexData().size()-2][1] ; //HashMap has 1 column with key-value pair
	        for (int i = 0; i<getIndexData().size()-2; i++) {			 //Last value in JSON is product name and account name at 4 and 5 so size-2
	            dataArray[i][0] = getIndexData().get(i);
	        }
			return dataArray;
	}
}
