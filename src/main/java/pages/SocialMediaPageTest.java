package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class SocialMediaPageTest extends BaseClass {

	private By facebook = By.xpath("//div[@class='column follow-us']//li/a[contains(text(),'Facebook')]");
	private By twitter = By.xpath("//div[@class='column follow-us']//li/a[contains(text(),'Twitter')]");
	private By rss = By.xpath("//div[@class='column follow-us']//li/a[contains(text(),'RSS')]");
	private By youTube = By.xpath("//div[@class='column follow-us']//li/a[contains(text(),'YouTube')]");
	private By googlePlus = By.xpath("//div[@class='column follow-us']//li/a[contains(text(),'Google+')]");

	public void socialMediaAccess(String pageUrl) {

		click(facebook);
		click(twitter);
		click(youTube);
		click(googlePlus);
		click(rss);
		getSpecificWindowFromOpenedWindows(pageUrl);
	}

}
