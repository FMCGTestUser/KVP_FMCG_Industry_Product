package com.kvp.testcases.Android;

import java.io.IOException;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_DashboardScreen;
import com.kvp.pageobject.android.Page_DrawerMenu;
import com.kvp.project.testutils.AndroidBaseTest;


public class TC2_DashbordView extends AndroidBaseTest{
	
	
	@Test(groups = {"All_Tests"})
	public void dashboardTest() throws IOException, InterruptedException  {
		getLoginData();	
		Page_DrawerMenu drawer = new Page_DrawerMenu(driver);
		drawer.skipMapPopup();
		Page_DashboardScreen home=new Page_DashboardScreen(driver);
		home.dayUpdates();
		Thread.sleep(2000);
		doLogout();
	}
}

