package com.cgi.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cgi.base.AutomationWrapper;
import com.cgi.pages.DashboardPage;
import com.cgi.pages.LoginPage;
import com.cgi.utils.DataUtils;

public class LoginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class,groups = {"smoke","login"})
	public void validLoginTest(String username,String password,String expectedValue) {
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();

		DashboardPage dashboard = new DashboardPage(driver);
		String actualText = dashboard.getQuickLaunchText();
		Assert.assertEquals(actualText, expectedValue);
	}

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class,groups = {"login"})
	public void invalidLoginTest(String username, String password, String expectedError) {
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();

		String actualText = login.getInvalidErrorMessage();
		Assert.assertEquals(actualText, expectedError);
	}
}
