package com.cgi.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cgi.base.AutomationWrapper;

public class LoginTest extends AutomationWrapper {
		
	@Test
	public void validLoginTest()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//Assert the QuickLaunch Text on the dashboard
		String actualText=driver.findElement(By.xpath("//p[contains(normalize-space(),'Quick L')]")).getText();
		Assert.assertEquals(actualText, "Quick Launch");
	}
	
	@Test
	public void invalidLoginTest()
	{
		driver.findElement(By.name("username")).sendKeys("John");
		driver.findElement(By.name("password")).sendKeys("john123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//Assert the error - Invalid credentials
		String actualText=driver.findElement(By.xpath("//p[contains(normalize-space(),'Invalid')]")).getText();
		Assert.assertEquals(actualText, "Invalid credentials");
	}

}
