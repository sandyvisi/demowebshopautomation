package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "D:\\eclipse-workspace\\demowebshotautomation\\src\\test\\resources\\features\\LoginTestFeature.feature", glue = {
		"stepDefinitions", "hooks" }, plugin = { "pretty", "html:target/cucumber-reports/reports.html",
				"json:target/cucumber-reports.json","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {

}
