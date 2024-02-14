package com.kvp.testcases.Android;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kvp.pageobject.android.Page_CouponsScreen;
import com.kvp.pageobject.android.Page_CouponsSuccess;
import com.kvp.pageobject.android.Page_JourneyCalendar;
import com.kvp.pageobject.android.Page_JourneyDetail;
import com.kvp.pageobject.android.Page_LoginScreen;
import com.kvp.pageobject.android.Page_NoOrder;
import com.kvp.pageobject.android.Page_ProductList;
import com.kvp.pageobject.android.Page_SelectScheme;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC5_ApplyCoupon extends AndroidBaseTest{
	
	
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
		Page_CouponsScreen coupon = new Page_CouponsScreen(driver);
		coupon.selectCoupon();
		Thread.sleep(2000);
		Page_CouponsSuccess couponApply = new Page_CouponsSuccess(driver);
		couponApply.applyCoupon();
		Thread.sleep(2000);		
	}
}

