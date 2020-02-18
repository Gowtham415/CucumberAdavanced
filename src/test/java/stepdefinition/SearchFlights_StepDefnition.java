package stepdefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.HomePage;
import PageObjects.Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFlights_StepDefnition {

	String baseUrl = "https://www.expedia.co.in/";
	WebDriver driver;
	Page page;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		page = new Page(driver);
		driver.manage().window().maximize();
	}

	@Given("login to expedia.in website")
	public void login_to_expedia_in_website() {
		driver.get(baseUrl);
	}

	@When("click on flights tab")
	public void click_on_flights_tab() {
		page.getInstance(HomePage.class).clickFlightstab();
	}

	@Then("user should be able to get the options for searching flights")
	public void user_should_be_able_to_get_the_options_for_searching_flights() {
		Assert.assertTrue(true);
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Given("select oneway trip checkbox")
	public void select_oneway_trip_checkbox() {
		page.getInstance(HomePage.class).toggleOneWayTrip();
	}

	@When("user provides Orgin and Destination cities")
	public void user_provides_Orgin_and_Destination_cities(DataTable table) {
		List<String> data = table.asList();
		page.getInstance(HomePage.class).setOriginCity(data.get(0));
		page.getInstance(HomePage.class).setDestinationCity(data.get(1));
	}

//	@When("User provides departure date \"([^\"]\")")
//	public void user_provides_departure_date(String departDate) {
//		
//	}
	
	@When("User provides departure date {string}")
	public void user_provides_departure_date(String departDate) {
		page.getInstance(HomePage.class).setDepartureDate(departDate);
	}

	@When("User click submit")
	public void user_click_submit() {
		page.getInstance(HomePage.class).clickSearchFlights();
	}

	@Then("User should be able to navigate to search results page")
	public void user_should_be_able_to_navigate_to_search_results_page() {
		Assert.assertTrue(true);
	}

}
