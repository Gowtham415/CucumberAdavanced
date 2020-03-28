package stepdefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.HomePage;
import PageObjects.ResultsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFlights_StepDefnition{
	

	private DataVariableClass varData;
	
	public SearchFlights_StepDefnition(DataVariableClass varData) {
		this.varData=varData;
	}

	@Given("login to expedia.in website")
	public void login_to_expedia_in_website() {
		varData.driver.get(varData.baseUrl);
		varData.title = varData.driver.getTitle();
	}

	@When("click on flights tab")
	public void click_on_flights_tab() {
		varData.page.getInstance(HomePage.class).clickFlightstab();
	}

	@Then("user should be able to get the options for searching flights")
	public void user_should_be_able_to_get_the_options_for_searching_flights() {
		Assert.assertTrue(true);
	}

	@Given("select oneway trip checkbox")
	public void select_oneway_trip_checkbox() {
		varData.page.getInstance(HomePage.class).toggleOneWayTrip();
	}

	@When("user provides Orgin and Destination cities")
	public void user_provides_Orgin_and_Destination_cities(DataTable table) {
		List<String> data = table.asList();
		varData.page.getInstance(HomePage.class).setOriginCity(data.get(0));
		varData.page.getInstance(HomePage.class).setDestinationCity(data.get(1));
	}

//	@When("User provides departure date \"([^\"]\")")
//	public void user_provides_departure_date(String departDate) {
//		
//	}
	
	@When("User provides departure date {string}")
	public void user_provides_departure_date(String departDate) {
		varData.page.getInstance(HomePage.class).setDepartureDate(departDate);
	}
	
	@When("User provides Origin {string} and Destination {string} cities for round trip")
	public void user_provides_Origin_and_Destination_cities_for_round_trip(String origin, String destination) {
		varData.page.getInstance(HomePage.class).setOriginCity(origin);
		varData.page.getInstance(HomePage.class).setDestinationCity(destination);
	}
	
	@When("User provides departure date {string} and return date {string} for round trip")
	public void user_provides_departure_date_and_return_date_for_round_trip(String departureDate, String returnDate) {
		varData.page.getInstance(HomePage.class).setDepartureDateforRoundTrip(departureDate);
		varData.page.getInstance(HomePage.class).setReturnDate(returnDate);
	}
	
	@When("User click submit")
	public void user_click_submit() {
		varData.page.getInstance(HomePage.class).clickSearchFlights();
	}
	
	@Then("User should be able to navigate to search results page")
	public void user_should_be_able_to_navigate_to_search_results_page() {
		Assert.assertTrue(varData.page.getInstance(ResultsPage.class).titleContains("Flights | Expedia"));
	}
	
	@When("User selects multiple adults with children")
	public void user_selects_multiple_adults_with_children() {
		varData.page.getInstance(HomePage.class).setAdultsAndChildren(3, 2);
	}
	
}
