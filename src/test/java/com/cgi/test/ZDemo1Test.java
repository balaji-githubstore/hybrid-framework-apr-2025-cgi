package com.cgi.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * Will be deleted from framework
 */
public class ZDemo1Test {
	
	@DataProvider
	public String[][] validData()
	{
		String[][] data=new String[3][2];
		//i--> number of testcases
		//j--> number of arguments
		
		data[0][0]="john";
		data[0][1]="john123";
		
		data[1][0]="saul";
		data[1][1]="saul123";
		
		data[2][0]="kim";
		data[2][1]="kim123";
		
		return data;
	}
	
	@Test(dataProvider = "validData")
	public void validTest(String username, String password)
	{
		System.out.println("valid test"+username+password);
	}

}
