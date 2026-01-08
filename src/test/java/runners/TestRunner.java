package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "D:\\eclipse-workspace\\demowebshotautomation\\src\\test\\resources\\features\\LoginTestFeature.feature", glue = "stepDefinitions", plugin = {
		"pretty", "html:target/cucumber-reports/reports.html" }, dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {

}
