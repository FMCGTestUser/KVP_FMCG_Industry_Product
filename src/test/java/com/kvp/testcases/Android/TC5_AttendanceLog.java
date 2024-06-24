package com.kvp.testcases.Android;

import java.io.IOException;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_DrawerMenu;
import com.kvp.pageobject.android.Page_AttendanceScreen;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC5_AttendanceLog extends AndroidBaseTest{
	
	
	@Test(groups = {"All_Tests"})
	public void accountsFlow() throws IOException, InterruptedException  {
		getLoginData();	
		Page_DrawerMenu drawer = new Page_DrawerMenu(driver);
		drawer.skipMapPopup();
		drawer.viewAttendance();
		Page_AttendanceScreen log = new Page_AttendanceScreen(driver);
		log.logAttendance();
		log.cancelLog();
		log.logAttendance();
		log.verifyLog();
		doLogout();
	}
}

