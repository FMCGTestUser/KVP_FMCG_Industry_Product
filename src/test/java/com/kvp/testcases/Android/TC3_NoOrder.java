package com.kvp.testcases.Android;


import java.io.IOException;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_JourneyCalendar;
import com.kvp.pageobject.android.Page_JourneyDetail;
import com.kvp.pageobject.android.Page_NoOrder;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC3_NoOrder extends AndroidBaseTest{
	
	@Test
	public void noOrder() throws IOException, InterruptedException  {
		getLoginData();	
		Page_JourneyCalendar widget = new Page_JourneyCalendar(driver);
		widget.startJourney();
		Page_JourneyDetail detail = new Page_JourneyDetail(driver);
		detail.checkOut();
		Thread.sleep(1000); 
		Page_NoOrder noOrder = new Page_NoOrder(driver);
		noOrder.orderReason();
		Thread.sleep(2000);
	}
}
