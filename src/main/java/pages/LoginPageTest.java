package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPageTest extends BaseClass {

	private By loginPageLocator = By.xpath("//div[@class='header-links']//ul/li/a[text()='Log in']");

	private String loginFormLocators = "//div[@class='form-fields']/form//div/input[@id='%s']";

	private By emailIdLocator = locator(loginFormLocators, "Email");
	private By passwordLocator = locator(loginFormLocators, "Password");
	private By clickReminderMeLocator = locator(loginFormLocators, "RememberMe");
	private By loginbuttonLocator = By.xpath("//div[@class='form-fields']/form//div/input[@value='Log in']");
	private By validLoginLink = By.xpath("//ul/li/a[text()='kumar@sandy.com']");
	private By invalidLoginLink = By
			.xpath("//div[@class='validation-summary-errors']/span[contains(text(),'Login was')]");

	private void clickLoginPageLink(By locator) {

		click(locator);

	}

	private void enterEmail(By locator, String email) {

		sendValues(locator, email);

	}

	private void enterPassword(By locator, String password) {

		sendValues(locator, password);

	}

	private void clickReminderCheckBox(By locator) {

		click(locator);

	}

	private void clickLoginButton(By locator) {

		click(locator);

	}

	public void loginFunctions(String email, String password) {
		clickLoginPageLink(loginPageLocator);
		enterEmail(emailIdLocator, email);
		enterPassword(passwordLocator, password);
		clickReminderCheckBox(clickReminderMeLocator);
		clickLoginButton(loginbuttonLocator);

	}

	public Boolean checkAssertion(String text) {

		return waitTillTextVisible(validLoginLink, text);

	}

	public Boolean checkAssertion1(String text) {

		return waitTillTextVisible(invalidLoginLink, text);

	}

}
