package com.cgi.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cgi.base.AutomationWrapper;

public class LoginUITest extends AutomationWrapper {

	@Test
	public void titleTest() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test
	public void headerTest() {
		String actualText = driver.findElement(By.xpath("//h5")).getText();
		Assert.assertEquals(actualText, "Login");
	}
}
