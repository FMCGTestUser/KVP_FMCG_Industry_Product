package com.kvp.testcases.Android;

import java.io.IOException;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_DrawerMenu;
import com.kvp.pageobject.android.Page_AccountDetails;
import com.kvp.pageobject.android.Page_AccountList;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC6_AccountsFlow extends AndroidBaseTest{
	
	
	@Test(groups = {"Regression","All_Tests"})
	public void accountsFlow() throws IOException, InterruptedException  {
//		getLoginData();	
		Page_DrawerMenu drawer = new Page_DrawerMenu(driver);
		drawer.viewAccount();
		Page_AccountList list =new Page_AccountList(driver);
		Page_AccountDetails details =new Page_AccountDetails(driver);
		for(int i=0;i<getIndexData().get(getIndexData().size()-1).size();i++) { //index starts from zero Size from O1 take case while looping
			list.selectAccount(i);
			if(i==0) {
			details.mapConfirmation();	//one time action
			}
			details.viewTabs();
			Thread.sleep(2000);
			details.navigateBack();
		}
	}
}

