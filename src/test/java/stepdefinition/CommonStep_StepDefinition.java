package stepdefinition;

import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CommonStep_StepDefinition{

	private DataVariableClass varData;
	
	public CommonStep_StepDefinition(DataVariableClass varData) {
		this.varData = varData;
	}

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		varData.driver = new ChromeDriver();
		varData.page = new Page(varData.driver);
		varData.driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		varData.driver.quit();
	}
}
