package com.myproject.utility;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static String path = "./test-data/Login-data.xlsx";

	public static String[][] getExcelData(String sheetname) {
		
		int index ;
		String[][] data;
		XSSFWorkbook wbook = null;
		XSSFSheet sheet;
		XSSFRow row ;
		XSSFCell cell ;
		
		try {
			wbook = new XSSFWorkbook(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// validate sheet present or not 
		 index =wbook.getSheetIndex(sheetname);
		 if(index==-1) {
			 data = new String[0][0];
			 return data;
		 }
	    sheet = wbook.getSheetAt(index);
		int lastRowNum = sheet.getLastRowNum();// 0 index 
		/*
		 * int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		 * System.out.println("Inclusive of header: "+physicalNumberOfRows);
		 * System.out.println("No.of Rows: "+ lastRowNum);
		 */
		short lastCellNum = sheet.getRow(0).getLastCellNum();// 1 index 
		System.out.println("No.of cells:"+lastCellNum);
		data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <=lastRowNum; i++) {
			 row = sheet.getRow(i);// strat from 0 index 
			for (int j = 0; j < lastCellNum; j++) {
				cell = row.getCell(j);// strat from 0 index 
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
//				String value = cell.getStringCellValue();
//				System.out.println(value);
				data[i-1][j] = value;
			} 
		}
		try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
				
	}
}
