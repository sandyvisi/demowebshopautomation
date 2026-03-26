package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.RegisterPageTest;
import util.ExcelReader;

public class RegisterPageTestCases {

	BaseClass base;
	RegisterPageTest registerPage;

	@BeforeClass
	public void launchBrowser() throws IOException {

		base = new BaseClass();
		base.init("chrome");
	}

	@Test(priority = 1, dataProvider = "Exceldata")
	public void registerPageActions(String firstName, String lastName, String email, String password,
			String confrimPassword) {
		registerPage = new RegisterPageTest();
		registerPage.registerFormActions(firstName, lastName, email, password, confrimPassword);
		String message = registerPage.getMessageDisplayed();
		System.out.println(message);

	}

	@DataProvider(name = "Exceldata")
	public Object[][] getData() throws EncryptedDocumentException, IOException {

		return ExcelReader.getTestData("D:\\eclipse-workspace\\demowebshotautomation\\testData\\demowebshop.xlsx",
				"registerPageActions");

	}

	@AfterClass
	public void quit() {

		base.teardown();
	}

}
