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

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected static WebDriver driver; // now instance variable
	protected Properties properties;
	protected WebDriverWait expWait;
	protected FileInputStream fis;
	protected static final String PROPERTY_FILE_PATH = System.getProperty("user.dir")
			+ "/src/main/java/config/config.properties";
	protected JavascriptExecutor js;

	// 1️⃣ Initialize driver and 
	public void init(String browser) throws IOException {

		if ("chrome".equalsIgnoreCase(browser)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if ("edge".equalsIgnoreCase(browser)) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if ("firefox".equalsIgnoreCase(browser)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();

		js = (JavascriptExecutor) driver;

		try {
			fis = new FileInputStream(PROPERTY_FILE_PATH);
			properties = new Properties();
			properties.load(fis);
			driver.get(properties.getProperty("url"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				fis.close();
		}
	}

	// 2️⃣ Getter for listener to access driver
	public WebDriver getDriver() {
		return driver;
	}

	// 3️⃣ Selenium wrapper methods
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

		expWait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
		System.out.println(driver.getCurrentUrl());
	}

	public WebElement visible(By locator) {
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

	// 4️⃣ Close driver
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
