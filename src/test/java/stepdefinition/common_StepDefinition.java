package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.ObjectsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class common_StepDefinition {

	protected WebDriver driver;
	DataVariableClass COMMON_DATA;

	public common_StepDefinition(DataVariableClass data) {
		this.COMMON_DATA = data;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
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
	
	
	@When("User Clicks on findout more")
	public void user_Clicks_on_findout_more() {
	    
	}

	@Then("User should be navigated to travel advisories page")
	public void user_should_be_navigated_to_travel_advisories_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
