package com.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.base.BaseClass;

public class DriverUtils extends BaseClass {
	
		
		

public static String getCellData(int row, int col) throws Exception {
	
	DataFormatter df = new DataFormatter();
	
	FileInputStream fis = new FileInputStream("ReadExcelsheet.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	
	Cell c = sh.getRow(row).getCell(col);
	return df.formatCellValue(c);
	
}

public static int getRowCount() throws IOException, InvalidFormatException {
    FileInputStream fis = new FileInputStream("ReadExcelsheet.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
    Sheet sh = wb.getSheet("Sheet1");
    return sh.getLastRowNum();  // Returns last row number (starting from 0)
}
}

