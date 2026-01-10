package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "D:\\eclipse-workspace\\demowebshotautomation\\src\\test\\resources\\features\\SocialMedia.feature", glue = "stepDefinitions", plugin = {
		"pretty", "html:target/cucumber-reports/reports.html", "json:target/cucumber-reports.json" }, dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {

}
