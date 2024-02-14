package com.kvp.testcases.Android;

import java.io.IOException;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_JourneyCalendar;
import com.kvp.pageobject.android.Page_JourneyDetail;
import com.kvp.pageobject.android.Page_ProductList;
import com.kvp.pageobject.android.Page_SelectScheme;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC4_SchemeSelection extends AndroidBaseTest{
	
	@Test
	public void selectScheme() throws IOException, InterruptedException  {
		getLoginData();	
		Page_JourneyCalendar widget = new Page_JourneyCalendar(driver);
		widget.startJourney();
		Page_JourneyDetail detail = new Page_JourneyDetail(driver);
		detail.clickOrder();
		Thread.sleep(1000); 
		Page_ProductList list =new Page_ProductList(driver);
		list.viewCart();
		Thread.sleep(1000); 
		Page_SelectScheme scheme =new Page_SelectScheme(driver);
		scheme.selectScheme();
		Thread.sleep(1000);
	}
}