package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class RegisterPageTest extends BaseClass {

	String pageText;
	private By registeLinkLocator = By.xpath("//div[@class='header-links']//ul/li/a[text()='Register']");

	private String formInputs = "//div[@class='page-body']//div/div/input[@id='%s']";

	private By genderMaleLocator = locator(formInputs, "gender-male");
	private By genderFemaleLocator = locator(formInputs, "gender-female");
	private By firstNameLocator = locator(formInputs, "FirstName");
	private By lastNameLocator = locator(formInputs, "LastName");
	private By emailLocator = locator(formInputs, "Email");
	private By passwordLocator = locator(formInputs, "Password");
	private By confirmPasswordLocator = locator(formInputs, "ConfirmPassword");
	private By registerButtonLocator = By
			.xpath("//div[@class='page-body']//div[@class='buttons']/input[@id='register-button']");

	private By successMessageLocator = By
			.xpath("//div[@class='page registration-result-page']//div/div[@class='result']");

	private By failureMessageLocator = By.xpath("//div[@class='message-error']//div/ul/li");

	String displayedMessage = null;

	private void clickRegisterLink(By locator) {

		click(locator);
	}

	private void clickMale(By locator) {

		click(locator);
	}

	private void clickFemale(By locator) {

		click(locator);
	}

	private void enterFirstName(By locator, String firstName) {

		sendValues(locator, firstName);

	}

	private void enterLastName(By locator, String lastName) {

		sendValues(locator, lastName);

	}

	private void enterEmail(By locator, String email) {

		sendValues(locator, email);

	}

	private void enterPassword(By locator, String password) {

		sendValues(locator, password);

	}

	private void enterConfirmPassword(By locator, String confirmPassword) {

		sendValues(locator, confirmPassword);

	}

	private void clickRegisterButton(By locator) {

		click(locator);

	}

	private void waitToFailureMessage(By locator) {

		checkVisibility(locator);

	}

	private void waitToSuccessMessage(By locator) {

		checkVisibility(locator);

	}

	private String getMessage(By locator) {

		return getText(locator);

	}

	public String getMessageDisplayed() {

		pageText = driver.getPageSource();

		if (pageText.contains("Your registration completed")) {
			waitToSuccessMessage(successMessageLocator);
			displayedMessage = getMessage(successMessageLocator);
		} else {
			waitToFailureMessage(failureMessageLocator);
			displayedMessage = getMessage(failureMessageLocator);
		}
		return displayedMessage;

	}

	public void registerFormActions(String firstName, String lastName, String email, String password,
			String confirmPassword) {

		clickRegisterLink(registeLinkLocator);
		clickMale(genderMaleLocator);
		enterFirstName(firstNameLocator, firstName);
		enterLastName(lastNameLocator, lastName);
		enterEmail(emailLocator, email);
		enterPassword(passwordLocator, password);
		enterConfirmPassword(confirmPasswordLocator, confirmPassword);
		clickRegisterButton(registerButtonLocator);

	}

}
