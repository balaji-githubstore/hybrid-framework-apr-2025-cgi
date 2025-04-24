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

	@Test
	public void invalidLoginTest() {
		LoginPage login = new LoginPage(driver);
		login.enterUsername("Admin12222");
		login.enterPassword("admin123");
		login.clickOnLogin();

		String actualText = login.getInvalidErrorMessage();
		Assert.assertEquals(actualText, "Invalid credentials");
	}
}
