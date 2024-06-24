package com.kvp.testcases.Android;

import java.io.IOException;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_CheckInDetail;
import com.kvp.pageobject.android.Page_DrawerMenu;
import com.kvp.pageobject.android.Page_JourneyCalendar;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC4i_CancelJourney extends AndroidBaseTest{
		
	@Test(groups = {"Regression","All_Tests"})
	public void endToEnd() throws IOException, InterruptedException  {
		getLoginData();	
		Page_DrawerMenu drawer = new Page_DrawerMenu(driver);
		drawer.skipMapPopup();
		drawer.viewJourney();
		Page_JourneyCalendar widget = new Page_JourneyCalendar(driver);
		widget.startJourney("In Progress");
		Page_CheckInDetail detail = new Page_CheckInDetail(driver);
		detail.cancelJourney();
		drawer.logout();
	}
}
