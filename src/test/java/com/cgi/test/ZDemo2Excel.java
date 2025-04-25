package com.cgi.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZDemo2Excel {

	public static void main(String[] args) throws IOException {

//		//Location
		FileInputStream file = new FileInputStream("test-data/orange-test-data.xlsx");

		// open
		XSSFWorkbook book = new XSSFWorkbook(file);

		// sheet
		XSSFSheet sheet = book.getSheet("invalidLoginTest");
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] data = new String[rowCount-1][cellCount];
		
		DataFormatter format=new DataFormatter();
		
		for (int r = 1; r < rowCount; r++) 
		{
			for (int c = 0; c < cellCount; c++) 
			{
				data[r-1][c]=format.formatCellValue(sheet.getRow(r).getCell(c));
			}
		}

		book.close();
		file.close();
	}

}
