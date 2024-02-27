package com.kvp.testcases.Android;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_CartScreen;
import com.kvp.pageobject.android.Page_CheckInDetail;
import com.kvp.pageobject.android.Page_CouponsScreen;
import com.kvp.pageobject.android.Page_CouponsSuccess;
import com.kvp.pageobject.android.Page_JourneyCalendar;
import com.kvp.pageobject.android.Page_LoginScreen;
import com.kvp.pageobject.android.Page_NoOrder;
import com.kvp.pageobject.android.Page_ProductDetails;
import com.kvp.pageobject.android.Page_ProductList;
import com.kvp.pageobject.android.Page_SelectScheme;
import com.kvp.pageobject.android.Page_SuccessOrder;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC1_EndToEnd extends AndroidBaseTest{
		
	@Test(groups = {"Regression","All_Tests"})
	public void endToEnd() throws IOException, InterruptedException  {
//		getLoginData();	
		Page_JourneyCalendar widget = new Page_JourneyCalendar(driver);
		widget.startJourney();
		Page_CheckInDetail detail = new Page_CheckInDetail(driver);
		detail.checkIn();
		Page_ProductList list =new Page_ProductList(driver);
		Page_ProductDetails details =new Page_ProductDetails(driver);
		Page_CartScreen cart = new Page_CartScreen(driver);
		for(int i=0;i<getIndexData().get(getIndexData().size()-2).size();i++) { //index starts from zero Size from O1 take case while looping
			list.selectProduct(i);
			details.selectDetails();
			Thread.sleep(2000);
			cart.navigateBack();
			Thread.sleep(2000);
			details.navigateBack();
		}
	/*	Thread.sleep(1000); // ---yet to implement in app click not working.
		list.viewCart();
		Thread.sleep(1000);
		cart.changeCart();
		Thread.sleep(2000);
		Page_SuccessOrder order =new Page_SuccessOrder(driver);
		order.placeOrder();
		Thread.sleep(5000);
		Page_NoOrder noorder = new Page_NoOrder(driver);
		noorder.orderReason();
		Thread.sleep(5000);
		Page_CouponsScreen coupon = new Page_CouponsScreen(driver);
		coupon.selectCoupon();
		Thread.sleep(5000);
		Page_CouponsSuccess couponapply = new Page_CouponsSuccess(driver);
		couponapply.applyCoupon();
		Thread.sleep(5000);
		Page_SelectScheme scheme =new Page_SelectScheme(driver);
		scheme.selectScheme();*/
	}
}
