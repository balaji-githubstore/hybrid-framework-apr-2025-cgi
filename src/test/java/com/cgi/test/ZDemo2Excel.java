package com.cgi.test;

import java.io.FileInputStream;
import java.io.IOException;

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
		
		for (int r = 1; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				// row and cell
				String cellValue = sheet.getRow(r).getCell(c).getStringCellValue();
				System.out.println(cellValue);
			}
		}

		book.close();
		file.close();
	}

}
