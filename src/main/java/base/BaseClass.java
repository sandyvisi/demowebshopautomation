package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	protected static WebDriver driver;
	protected static Properties properties;
	protected static FileInputStream fis;
	protected static String propertyFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\java\\config\\config.properties";
	protected static WebDriverWait expWait;

	public void init() throws IOException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		properties = new Properties();
		fis = new FileInputStream(propertyFilePath);
		properties.load(fis);
		driver.get(properties.getProperty("url"));
		expWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		fis.close();

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

	public void checkVisibility(By locator) {

		expWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public String getText(By locator) {

		return driver.findElement(locator).getText();
	}

}
