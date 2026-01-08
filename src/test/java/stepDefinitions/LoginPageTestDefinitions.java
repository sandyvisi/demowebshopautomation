package stepDefinitions;

import java.io.IOException;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPageTest;

public class LoginPageTestDefinitions {

	BaseClass base;
	LoginPageTest loginPaege;

	@Given("User has to landed over to the login page")
	public void goToLoginPage() throws IOException {
		base = new BaseClass();
		base.init();
		loginPaege = new LoginPageTest();

	}

	@When("User enters valid the {string} {string}")
	public void enterEmailAndPassword(String email, String password) {
		loginPaege.loginFunctions(email, password);

	}

	@Then("User able to login successfully")
	public void userLoggedInSuccessfully() {
		System.out.println("user logged in successfully");

	}

	@When("User enters the invalid {string} {string}")
	public void entersInvalidEmailAndPassword(String invalidEmail, String password) {
		loginPaege.loginFunctions(invalidEmail, password);

	}

	@Then("User should not be able login")
	public void loginFailed() {
		System.out.println("user logged-in is failed");

	}

}
