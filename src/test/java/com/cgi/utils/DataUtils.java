package com.cgi.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;
/**
 * Contains all the dataprovider for the entire project
 */

public class DataUtils {

	@DataProvider
	public String[][] invalidLoginData() {
		
		String[][] data = new String[2][3];
		data[0][0] = "john";
		data[0][1] = "john123";
		data[0][2] = "Invalid credentials";

		data[1][0] = "saul";
		data[1][1] = "saul123";
		data[1][2] = "Invalid credentials";

		return data;
	}
	
	@DataProvider
	public String[][] commonDataProvider() throws IOException
	{
		String[][] data= ExcelUtils.getSheetIntoTwoDimensionalArray
				("test-data/orange-test-data.xlsx", "invalidLoginTest");
		return data;
	}

}




