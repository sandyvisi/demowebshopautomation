package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPageTest;

public class RegiserPageStepDefins {

	BaseClass base;
	RegisterPageTest registerPageSteps;
	String expectedSuccMessage = "Your registration completed";
	String expectedFailMessage = "The specified email already exists";

	@Given("url to be loaded properly")
	public void usrLoaded() throws IOException {
		base = new BaseClass();
		base.init();
		registerPageSteps = new RegisterPageTest();

	}

	@When("user enters all the register page details {string} {string} {string} {string} {string}")
	public void enterRegisterDetails(String firstName, String lastName, String email, String password,
			String confirmPassword) {

		registerPageSteps.registerFormActions(firstName, lastName, email, password, confirmPassword);

	}

	@Then("the user details should be registered and login details should be created")
	public void loginCreated() {

		String message = registerPageSteps.getSuccessMessage();
		System.out.println(message);
		Assert.assertEquals(message, expectedSuccMessage);

	}

	@Then("the user details should not registered should be shown error message")
	public void loginNotCreated() {

		String message = registerPageSteps.getFailureMessage();
		System.out.println(message);
		Assert.assertEquals(message, expectedFailMessage);

	}

}
