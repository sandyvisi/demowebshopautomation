package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static String getScreenshot(WebDriver driver, String screenshotName) {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotDirectory = System.getProperty("user.dir") + "/Screenshots";
		String filePath = screenshotDirectory + "/" + screenshotName + "_" + timestamp + ".png";

		System.out.println(filePath);
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File(filePath);
			FileUtils.copyFile(sourceFile, destinationFile);
			System.out.println("Screenshot saved at: " + filePath);
		} catch (IOException i) {
			i.printStackTrace();
		} finally {

			System.out.println("screenshot is copied");

		}

		return filePath;

	}

}
