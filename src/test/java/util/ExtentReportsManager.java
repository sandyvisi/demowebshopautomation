package util;

import java.io.File;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;

public class ExtentReportsManager extends BaseClass implements ITestListener {

	public ExtentSparkReporter ui;
	public ExtentReports commonInfo;
	public ExtentTest testCaseEntries;
	public Logger log;
	public String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

	@Override
	public void onStart(ITestContext context) {
		// Create Reports folder if not exists

		String reportsDirectory = System.getProperty("user.dir") + "/Reports";
		File reportsDir = new File(reportsDirectory);
		if (!reportsDir.exists()) {
			reportsDir.mkdirs();
		}

		ui = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/extReports_" + timeStamp + ".html");
		ui.config().setDocumentTitle("Extent Reports");
		ui.config().setReportName("Automation Test Report");
		ui.config().setTheme(Theme.DARK);

		commonInfo = new ExtentReports();
		commonInfo.attachReporter(ui);

		commonInfo.setSystemInfo("Computer Name", "Sandy");
		commonInfo.setSystemInfo("Environment", "QA");
		commonInfo.setSystemInfo("Tester Name", "santhoshkumar");
		commonInfo.setSystemInfo("OS", "Windows 11");
		commonInfo.setSystemInfo("Browser Name", "Chrome");
	}

	@Override
	public void onTestStart(ITestResult result) {
		testCaseEntries = commonInfo.createTest(result.getName());
		log = LoggerUtils.getLogger(result.getTestClass().getRealClass());
		log.info("Test Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		testCaseEntries.log(Status.PASS, "Test Passed: " + result.getName());
		log.info("Test Passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		if (testCaseEntries == null) {
			testCaseEntries = commonInfo.createTest(result.getName());
		}
		testCaseEntries.log(Status.FAIL, "Test Failed: " + result.getName());
		testCaseEntries.log(Status.FAIL, "Cause: " + result.getThrowable());
		if (log == null) {
			log = LoggerUtils.getLogger(result.getTestClass().getRealClass());
		}
		log.error("Test Failed: " + result.getName(), result.getThrowable());

		String screenshotPath = ScreenshotUtility.getScreenshot(driver, result.getName());
		testCaseEntries.addScreenCaptureFromPath(screenshotPath, result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		testCaseEntries.log(Status.SKIP, "Test Skipped: " + result.getName());
		log.warn("Test Skipped: " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		commonInfo.flush();
	}
}
