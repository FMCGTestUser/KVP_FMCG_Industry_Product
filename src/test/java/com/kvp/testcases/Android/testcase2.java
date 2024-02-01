package com.kvp.testcases.Android;

import java.io.IOException;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_CartScreen;
import com.kvp.pageobject.android.Page_CouponsScreen;
import com.kvp.pageobject.android.Page_CouponsSuccess;
import com.kvp.pageobject.android.Page_JourneyCalendar;
import com.kvp.pageobject.android.Page_JourneyDetail;
import com.kvp.pageobject.android.Page_LoginScreen;
import com.kvp.pageobject.android.Page_NoOrder;
import com.kvp.pageobject.android.Page_SuccessOrder;
import com.kvp.pageobject.android.Page_ProductDetails;
import com.kvp.pageobject.android.Page_ProductList;
import com.kvp.pageobject.android.Page_SelectScheme;
import com.kvp.project.testutils.AndroidBaseTest;


public class testcase2 extends AndroidBaseTest{

	@Test
	public void loginScreenTest() throws InterruptedException, IOException{
		Thread.sleep(5000);
		Page_LoginScreen signin = new Page_LoginScreen(driver);
		signin.login();
		Thread.sleep(5000);
		Page_JourneyCalendar calender = new Page_JourneyCalendar(driver);
		calender.startJourney();
		Thread.sleep(5000);
		Page_JourneyDetail detail = new Page_JourneyDetail(driver);
		detail.clickOrder();
		Thread.sleep(5000);
		Page_ProductList list =new Page_ProductList(driver);
		list.selectProduct();
		Thread.sleep(5000);
		Page_ProductDetails details = new Page_ProductDetails(driver);
		details.productDetails();
		Thread.sleep(5000);
		Page_CartScreen cart = new Page_CartScreen(driver);
		cart.addCart();
		Thread.sleep(5000);
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
		scheme.selectScheme();
		
	}
}
