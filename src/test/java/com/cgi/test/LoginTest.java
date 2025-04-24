package com.cgi.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cgi.base.AutomationWrapper;
import com.cgi.pages.DashboardPage;
import com.cgi.pages.LoginPage;

public class LoginTest extends AutomationWrapper {

	@Test
	public void validLoginTest() {
		LoginPage login = new LoginPage(driver);
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickOnLogin();

		DashboardPage dashboard = new DashboardPage(driver);
		String actualText = dashboard.getQuickLaunchText();
		Assert.assertEquals(actualText, "Quick Launch");
	}

	// Create a dataprovider invalidLoginData()
	// john,john123,Invalid credentials
	// saul,saul123,Invalid credentials

	@Test
	public void invalidLoginTest(String username, String password, String expectedError) {
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();

		String actualText = login.getInvalidErrorMessage();
		Assert.assertEquals(actualText, expectedError);
	}
}
