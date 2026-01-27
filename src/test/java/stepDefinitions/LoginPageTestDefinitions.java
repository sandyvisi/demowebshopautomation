package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPageTest;
import utils.LoggerUtil;

public class LoginPageTestDefinitions {

	private static final Logger logger = LoggerUtil.getLogger(LoginPageTestDefinitions.class);

	LoginPageTest loginPaege;

	@Given("Get the url and open in browser")
	public void get_the_url_and_open_in_browser() throws IOException {

		logger.info("Opening application URL");

	}

	@When("User enters valid the {string} {string}")
	public void enterEmailAndPassword(String email, String password) {

		loginPaege = new LoginPageTest();
		loginPaege.loginFunctions(email, password);
		Boolean b = loginPaege.checkAssertion("kumar@sandy.com");
		Assert.assertEquals(b, true);

	}

	@Then("User able to login successfully")
	public void userLoggedInSuccessfully() {
		logger.info("Login successful - dashboard displayed");

		System.out.println("user logged in successfully");

	}

	@When("User enters the invalid {string} {string}")
	public void entersInvalidEmailAndPassword(String invalidEmail, String password) {
		loginPaege.loginFunctions(invalidEmail, password);
		Boolean b = loginPaege.checkAssertion1("Login");
		Assert.assertEquals(b, true);

	}

	@Then("User should not be able login")
	public void loginFailed() {
		System.out.println("user logged-in is failed");

	}

}
