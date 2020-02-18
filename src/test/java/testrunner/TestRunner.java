package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\features\\",
				glue = {"stepdefinition"},
				plugin = {"pretty", "html:test-output"},
				dryRun = false,
				monochrome = true,
				strict = true,
				tags = {})

public class TestRunner extends AbstractTestNGCucumberTests{

}
