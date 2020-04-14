package stepdefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.ObjectsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class common_StepDefinition {
		
	protected WebDriver driver;
	DataVariableClass varData;
	
	public common_StepDefinition(DataVariableClass varData) {
		this.varData=varData;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		varData.driver = new ChromeDriver();// Driver variable is initialized and stored in DataVariable class
		this.driver=varData.driver;
	}
	
	private ObjectsPage selenium() {
		return varData.selenium();
	}
	
	@Before
	public void setUp() {
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
