package testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.SocialMediaPageTest;
import utils.ExcelReader;

public class SocialMediaPageTestCases {
	BaseClass base;
	SocialMediaPageTest socialMediaTest;

	@BeforeClass
	public void setup() throws IOException {

		base = new BaseClass();
		base.init();

	}

	@Test(dataProvider = "Exceldata", dataProviderClass = ExcelReader.class)
	public void socialMediaFunctions(String pageUrl) {

		socialMediaTest = new SocialMediaPageTest();
		socialMediaTest.socialMediaAccess(pageUrl);

	}

	@AfterClass
	public void closeBrowser() throws IOException {

		base.teardown();

	}

}
