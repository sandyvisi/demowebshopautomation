package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SocialMediaTest;

public class socialMediaLinks {

	SocialMediaTest social;

	@When("user clicks the socialMedia link at the bottom of the page")
	public void user_clicks_the_facebook_link_at_the_bottom_of_the_page() {

		social = new SocialMediaTest();
		social.socialMediaAccess("https://www.facebook.com/nopCommerce");

	}

	@Then("the user should be moved to new tab of all social medias")
	public void the_user_should_be_moved_to_new_tab_of_facebook() {

	}
}
