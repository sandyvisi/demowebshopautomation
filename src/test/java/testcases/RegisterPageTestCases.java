package testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.RegisterPageTest;
import utils.ExcelReader;

public class RegisterPageTestCases {

	BaseClass base;
	RegisterPageTest registerPageTest;

	@BeforeClass
	public void setup() throws IOException {

		base = new BaseClass();
		base.init();

	}

	@Test(dataProvider = "Exceldata", dataProviderClass = ExcelReader.class)
	public void RegisterPageFunctions(String firstName, String lastName, String email, String password,
			String confirmPassword) {

		registerPageTest = new RegisterPageTest();
		registerPageTest.registerFormActions(firstName, lastName, email, password, confirmPassword);

	}

	@AfterClass
	public void closeBrowser() throws IOException {

		base.teardown();

	}

}
