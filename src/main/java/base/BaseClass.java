package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	protected static WebDriver driver;
	protected Properties properties;
	protected static WebDriverWait expWait;
	protected static FileInputStream fis;
	private static final String PROPERTY_FILE_PATH = System.getProperty("user.dir")
			+ "/src/main/java/config/config.properties";
	protected static JavascriptExecutor js;

	public void init(String browser) throws IOException {

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

		try {
			fis = new FileInputStream(PROPERTY_FILE_PATH);
			properties = new Properties();
			properties.load(fis);
			driver.get(properties.getProperty("url"));
			expWait = new WebDriverWait(driver, Duration.ofSeconds(30));
			js = (JavascriptExecutor) driver;

		} catch (IOException i) {
			i.printStackTrace();
		} finally {
			fis.close();
		}

	}

	public void click(By locator) {

		driver.findElement(locator).click();

	}

	public void sendValues(By locator, String text) {

		driver.findElement(locator).sendKeys(text);

	}

	public By locator(String xpath, String specifier) {
		return By.xpath(String.format(xpath, specifier));

	}

	public List<WebElement> getElements(By locator) {

		return driver.findElements(locator);

	}

	public void checkVisibility(By locator) {

		expWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public String getText(By locator) {

		return driver.findElement(locator).getText();
	}

	public void scrollIntoView(By locator) {

		WebElement element = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void getCurrentUrl() {

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static WebElement visible(WebDriver driver, By locator) {

		expWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return expWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public void getSpecificWindowFromOpenedWindows(String pageUrl) {

		Set<String> setWindows = driver.getWindowHandles();
		List<String> listWindows = new ArrayList<>(setWindows);

		for (String w : listWindows) {

			driver.switchTo().window(w);
			if (driver.getCurrentUrl().equals(pageUrl)) {
				break;

			}

		}

	}

	public Boolean textToBePresentInElement(By locator, String text) {

		WebElement element = driver.findElement(locator);
		return expWait.until(ExpectedConditions.textToBePresentInElement(element, text));

	}

	public void teardown() {

		driver.quit();
	}

}
