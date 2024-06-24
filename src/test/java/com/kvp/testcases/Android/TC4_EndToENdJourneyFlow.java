package com.kvp.testcases.Android;

import java.io.IOException;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_CartScreen;
import com.kvp.pageobject.android.Page_CheckInDetail;
import com.kvp.pageobject.android.Page_DrawerMenu;
import com.kvp.pageobject.android.Page_JourneyCalendar;
import com.kvp.pageobject.android.Page_ProductDetails;
import com.kvp.pageobject.android.Page_ProductList;
import com.kvp.pageobject.android.Page_OrderSummary;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC4_EndToENdJourneyFlow extends AndroidBaseTest{
		
	@Test(groups = {"Regression","All_Tests"})
	public void endToEnd() throws IOException, InterruptedException  {
		getLoginData();	
		Page_DrawerMenu drawer = new Page_DrawerMenu(driver);
		drawer.skipMapPopup();
		drawer.viewJourney();
		Page_JourneyCalendar widget = new Page_JourneyCalendar(driver);
		widget.startJourney("Not Started");
		Page_CheckInDetail detail = new Page_CheckInDetail(driver);
		detail.checkIn();
		detail.createOrder();
		Thread.sleep(2000);
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
		detail.viewDetailsTab();
		detail.checkOut();
		drawer.logout();
	}
}
