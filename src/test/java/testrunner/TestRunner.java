package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\features\\",
				glue = {"stepdefinition"},
				plugin = {"pretty", "html:target\\Cucumber-report","json:target\\jsonReports\\cucumber.json"},
				dryRun = false,
				monochrome = true,
				strict = true,
				tags = {"@FULLRUN or @SMOKE"})

public class TestRunner extends AbstractTestNGCucumberTests{
	
}

