package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelReader {

	public static Workbook book;
	public static Sheet sheet;
	public static int numberOfRows;
	public static int numberOfColumns;
	public static DataFormatter dataFormatter;
	public static Object[][] data;

	@DataProvider(name = "Exceldata")
	public static Object[][] getTestData(java.lang.reflect.Method method) {
		String sheetName = method.getName();
		String filePath = System.getProperty("user.dir") + "\\testData\\demowebshop.xlsx";
		FileInputStream fis = null;
		System.out.println(filePath);

		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);

			// have to pass the inputstream's object
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);

		numberOfRows = sheet.getPhysicalNumberOfRows();
		numberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println("Rows: " + numberOfRows);
		System.out.println("Columns: " + numberOfColumns);

		data = new Object[numberOfRows - 1][numberOfColumns];

		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());

		for (int i = 1; i < numberOfRows; i++) {
			for (int k = 0; k < numberOfColumns; k++) {

				Cell cellValue = sheet.getRow(i).getCell(k);
				dataFormatter = new DataFormatter();
				data[i - 1][k] = dataFormatter.formatCellValue(cellValue);
//				 = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i - 1][k]);
			}
		}

		return data;
	}
}
