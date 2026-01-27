package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class CheckBrokenLinksPageTest extends BaseClass {

	private By allLinksHomePage = By.xpath("//a[string-length(@href)>0]");

	private List<WebElement> getAllBrokenLinks(By locator) {

		return getElements(locator);
	}

	public void getAllLinks() throws URISyntaxException, IOException {

		List<WebElement> allLinks = getAllBrokenLinks(allLinksHomePage);
		System.out.println(allLinks.size());
		for (WebElement urls : allLinks) {

			URI uri = new URI(urls.getAttribute("href"));

			URL url = uri.toURL();

			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() >= 400) {

				System.out.println(urls.getAttribute("href") + "_ _ _ " + "responseCode is "
						+ httpURLConnection.getResponseCode() + " is broken link");

			}

		}
	}

}
