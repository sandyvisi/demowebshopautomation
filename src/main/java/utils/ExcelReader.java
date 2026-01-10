package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelReader {

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "test" + File.separator + "java" + File.separator + "chapter_10_data_providers" + File.separator
			+ "examples" + File.separator + "a5" + File.separator + "data.xlsx";

	public static Workbook book;
	public static Sheet sheet;
	public static int numberOfRows;
	public static int numberOfColumns;
	public static DataFormatter dataFormatter;
	public static Object[][] data;

	@DataProvider(name = "registerDataProvider")
	public static Object[][] getTestData() {
		String sheetName = "Sheet1";
		FileInputStream fis = null;
		System.out.println(TESTDATA_SHEET_PATH);

		try {
			fis = new FileInputStream(TESTDATA_SHEET_PATH);
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

		data = new Object[numberOfRows][numberOfColumns];

		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < numberOfRows; i++) {
			for (int k = 0; k < numberOfColumns; k++) {

				Cell cellValue = sheet.getRow(i).getCell(k);
				dataFormatter = new DataFormatter();
				data[i][k] = dataFormatter.formatCellValue(cellValue);
//				 = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}

		return data;
	}
}
