package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.RegisterPageTest;
import utils.ExcelReader;

public class RegisterPageTestCases {

	BaseClass base;
	RegisterPageTest registerPage;

	@BeforeMethod
	public void launchBrowser() throws IOException {

		base = new BaseClass();
		base.init("chrome");
	}

	@Test(priority = 1, dataProvider = "Exceldata", dataProviderClass = ExcelReader.class)
	public void registerPageActions(String firstName, String lastName, String email, String password,
			String confrimPassword) {
		registerPage = new RegisterPageTest();
		registerPage.registerFormActions(firstName, lastName, email, password, confrimPassword);

		Assert.assertEquals("Your registration completed", registerPage.getSuccessMessage());
//		Assert.assertEquals("The specified email already exists", registerPage.getFailureMessage());

	}

	@AfterMethod()
	public void quit() {

		base.teardown();
	}

}
