package testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPageTest;
import utils.ExcelReader;

public class LoginPageTestCases {
	BaseClass base;
	LoginPageTest loginPageTest;

	@BeforeClass
	public void setup() throws IOException {

		base = new BaseClass();
		base.init();

	}

	@Test(dataProvider = "Exceldata", dataProviderClass = ExcelReader.class)
	public void loginFunctions(String email, String password) {

		loginPageTest = new LoginPageTest();
		loginPageTest.loginFunctions(email, password);

	}

	@AfterClass
	public void closeBrowser() throws IOException {

		base.teardown();

	}

}
