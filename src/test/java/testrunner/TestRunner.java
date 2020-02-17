package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\features\\",
				glue = {"stepdefinition"},
				plugin = {"pretty", "html:test-output"},
				dryRun = false,
				monochrome = true,
				strict = true,
				tags = {})

public class TestRunner {

}
