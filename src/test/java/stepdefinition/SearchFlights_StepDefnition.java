package stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.HomePage;
import PageObjects.Page;
import PageObjects.ResultsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Utilities.CommonUtilities.sleep;

public class SearchFlights_StepDefnition {

	String baseUrl = "https://www.expedia.co.in/";
	WebDriver driver;
	Page page;
	String title;

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
		title = driver.getTitle();
	}

	@When("click on flights tab")
	public void click_on_flights_tab() {
		page.getInstance(HomePage.class).clickFlightstab();
	}

	@Then("user should be able to get the options for searching flights")
	public void user_should_be_able_to_get_the_options_for_searching_flights() {
		Assert.assertTrue(true);
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
	
	@When("User provides Origin {string} and Destination {string} cities for round trip")
	public void user_provides_Origin_and_Destination_cities_for_round_trip(String origin, String destination) {
		page.getInstance(HomePage.class).setOriginCity(origin);
	    page.getInstance(HomePage.class).setDestinationCity(destination);
	}
	
	@When("User provides departure date {string} and return date {string} for round trip")
	public void user_provides_departure_date_and_return_date_for_round_trip(String departureDate, String returnDate) {
		 page.getInstance(HomePage.class).setDepartureDateforRoundTrip(departureDate);
		 page.getInstance(HomePage.class).setReturnDate(returnDate);
	}
	
	@When("User click submit")
	public void user_click_submit() {
		page.getInstance(HomePage.class).clickSearchFlights();
	}
	
	@Then("User should be able to navigate to search results page")
	public void user_should_be_able_to_navigate_to_search_results_page() {
		Assert.assertTrue(page.getInstance(ResultsPage.class).getTitleOfPage());
	}
	
	@After
	public void tearDown() {
		driver.close();
//		try {
//			Runtime.getRuntime().exec("D:\\Project15\\chromedriver_kill.bat");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
