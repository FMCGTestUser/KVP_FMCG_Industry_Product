package com.kvp.testcases.Android;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_LoginScreen;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC1_EndToEnd extends AndroidBaseTest{
		
	@Test(dataProvider="getData", groups = {"Smoke"})
	public void loginScreenTest(HashMap<String, String> input) {
		Page_LoginScreen signin = new Page_LoginScreen(driver);
		signin.login(input.get("userName"),input.get("password"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> jsonData =getJsonData("Project_Configurations/FMCG_data.json");
		Object[][] data= {{jsonData.get(0)}};
		return data;
}
}
