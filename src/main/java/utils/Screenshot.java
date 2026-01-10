package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class Screenshot extends BaseClass {

	public static TakesScreenshot screenshot;
	public static File destination;
	public static File source;

	public static String screenshotPath = System.getProperty("user.dir") + "TestData";

	public static void getScreenshot() throws IOException {

		destination = new File(screenshotPath);
		screenshot = (TakesScreenshot) driver;
		source = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, destination);

	}

	public static void main(String[] args) throws IOException {
		getScreenshot();
	}

}
