package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.ObjectsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class common_StepDefinition {

	protected WebDriver driver;
	DataVariableClass COMMON_DATA;

	public common_StepDefinition(DataVariableClass data) {
		this.COMMON_DATA = data;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		COMMON_DATA.driver = new ChromeDriver();// Driver variable is initialized and stored in DataVariable class
		this.driver = COMMON_DATA.driver;
	}

	private ObjectsPage selenium() {
		return COMMON_DATA.selenium();
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
