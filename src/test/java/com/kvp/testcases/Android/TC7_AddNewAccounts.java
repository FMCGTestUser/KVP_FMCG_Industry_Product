package com.kvp.testcases.Android;

import java.io.IOException;
import org.testng.annotations.Test;
import com.kvp.pageobject.android.Page_DrawerMenu;
import com.kvp.pageobject.android.Page_AccountList;
import com.kvp.pageobject.android.Page_AccountCreateNew;
import com.kvp.project.testutils.AndroidBaseTest;

public class TC7_AddNewAccounts extends AndroidBaseTest{
	
	
	@Test(groups = {"All_Tests"})
	public void addNewAccount() throws IOException, InterruptedException  {
		getLoginData();	
		Page_DrawerMenu drawer = new Page_DrawerMenu(driver);
		drawer.viewAccount();
		Page_AccountList list =new Page_AccountList(driver);
		list.addAccount();
		Page_AccountCreateNew newAcc =new Page_AccountCreateNew(driver);
		newAcc.mapConfirmation();
		newAcc.createAccounts();
		newAcc.navigateBack();
		doLogout();
	}
}

