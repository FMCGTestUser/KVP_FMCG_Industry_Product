package com.kvp.testcases.Android;

import java.io.IOException;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_CartScreen;
import com.kvp.pageobject.android.Page_CheckInDetail;
import com.kvp.pageobject.android.Page_CouponsScreen;
import com.kvp.pageobject.android.Page_CouponsSuccess;
import com.kvp.pageobject.android.Page_DrawerMenu;
import com.kvp.pageobject.android.Page_JourneyCalendar;
import com.kvp.pageobject.android.Page_NoOrder;
import com.kvp.pageobject.android.Page_ProductDetails;
import com.kvp.pageobject.android.Page_ProductList;
import com.kvp.pageobject.android.Page_SelectScheme;
import com.kvp.pageobject.android.Page_OrderSummary;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC1_EndToEnd extends AndroidBaseTest{
		
	@Test(groups = {"Regression","All_Tests"})
	public void endToEnd() throws IOException, InterruptedException  {
		getLoginData();	
		Page_JourneyCalendar widget = new Page_JourneyCalendar(driver);
		widget.startJourney();
		Page_CheckInDetail detail = new Page_CheckInDetail(driver);
		detail.createOrder();
		Thread.sleep(2000);
		//detail.checkIn();
		Page_ProductList list =new Page_ProductList(driver);
		Page_ProductDetails details =new Page_ProductDetails(driver);
		Page_CartScreen cart = new Page_CartScreen(driver);
		for(int i=0;i<getIndexData().get(getIndexData().size()-2).size();i++) { //index starts from zero Size from O1 take care while looping
			list.selectProduct(i);
			details.selectDetails();
			Thread.sleep(2000);
		}
		list.viewCart();
		Thread.sleep(1000);
		cart.modifyCart();
		Thread.sleep(1000);
		cart.placeOrder();
		Thread.sleep(1000);
		Page_OrderSummary order =new Page_OrderSummary(driver);
		order.completeOrder();
//		Page_NoOrder noorder = new Page_NoOrder(driver);
//		noorder.orderReason();
//		Thread.sleep(5000);
//		Page_CouponsScreen coupon = new Page_CouponsScreen(driver);
//		coupon.selectCoupon();
//		Thread.sleep(5000);
//		Page_CouponsSuccess couponapply = new Page_CouponsSuccess(driver);
//		couponapply.applyCoupon();
//		Thread.sleep(5000);
//		Page_SelectScheme scheme =new Page_SelectScheme(driver);
//		scheme.selectScheme();
		Page_DrawerMenu drawer = new Page_DrawerMenu(driver);
		drawer.logout();
	}
}
