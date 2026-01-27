package stepDefinitions;

import java.io.IOException;
import java.net.URISyntaxException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckBrokenLinksPageTest;

public class CheckBorkenLinksStepsDefinitions {

	CheckBrokenLinksPageTest checkBrokenLinkPage;

	@Given("Get the url and open in browser")
	public void get_the_url_and_open_in_browser() throws IOException {

		System.out.println("url is loaded------------");

	}

	@When("check broken links are present in the page")
	public void checkBrokenLinks() {
		checkBrokenLinkPage = new CheckBrokenLinksPageTest();

	}

	@Then("check broken links are showing the response code as expected")
	public void checkTheBrokenLinkResponseCode() throws URISyntaxException, IOException {
		checkBrokenLinkPage.getAllLinks();

	}

}
