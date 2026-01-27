package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "D:\\eclipse-workspace\\demowebshotautomation\\src\\test\\resources\\features", glue = {
		"stepDefinitions",
		"hooks" }, plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {

}
