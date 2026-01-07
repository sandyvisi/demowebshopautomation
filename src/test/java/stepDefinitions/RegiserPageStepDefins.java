package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import base.BaseClass;
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
	public void url_to_be_loaded_properly() throws IOException {
		base = new BaseClass();
		base.init();
		registerPageSteps = new RegisterPageTest();

	}

	@When("user enters all the register page details {string} {string} {string} {string} {string}")
	public void user_enters_all_the_register_page_details(String firstName, String lastName, String email,
			String password, String confirmPassword) {

		registerPageSteps.registerFormActions(firstName, lastName, email, password, confirmPassword);

	}

	@Then("the user details should be registered and login details should be created")
	public void the_user_details_should_be_registered_and_login_details_should_be_created() {

		String message = registerPageSteps.getSuccessMessage();
		Assert.assertEquals(message, expectedSuccMessage);

	}

}
