package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinations", tags = "@TodoFeature", dryRun = false, monochrome = true, strict = true, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty",
		"html:target/cucumber-Report.html", "json:target/Report2.json", "junit:target/Report3.xml" })

public class TestRunner {

}
