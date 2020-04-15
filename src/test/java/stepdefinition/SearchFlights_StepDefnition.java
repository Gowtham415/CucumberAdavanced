package stepdefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.ObjectsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFlights_StepDefnition{
	
	WebDriver driver;
	private DataVariableClass COMMON_DATA;
	
	public SearchFlights_StepDefnition(DataVariableClass data) {
		this.COMMON_DATA=data;
		this.driver=data.driver;
	}
	
	private ObjectsPage selenium() {
		return COMMON_DATA.selenium();
	}

	@Given("login to expedia.in website")
	public void login_to_expedia_in_website() {
		driver.get(COMMON_DATA.baseUrl);
		COMMON_DATA.title = driver.getTitle();
	}

	@When("click on flights tab")
	public void click_on_flights_tab() {
		selenium().HOMEPAGE.clickFlightstab();
	}

	@Then("user should be able to get the options for searching flights")
	public void user_should_be_able_to_get_the_options_for_searching_flights() {
		Assert.assertTrue(true);
	}

	@Given("select oneway trip checkbox")
	public void select_oneway_trip_checkbox() {
		selenium().HOMEPAGE.toggleOneWayTrip();
	}

	@When("user provides Orgin and Destination cities")
	public void user_provides_Orgin_and_Destination_cities(DataTable table) {
		List<String> data = table.asList();
		selenium().HOMEPAGE.setOriginCity(data.get(0));
		selenium().HOMEPAGE.setDestinationCity(data.get(1));
	}

//	@When("User provides departure date \"([^\"]\")")
//	public void user_provides_departure_date(String departDate) {
//		
//	}
	
	@When("User provides departure date {string}")
	public void user_provides_departure_date(String departDate) {
		selenium().HOMEPAGE.setDepartureDate(departDate);
	}
	
	@When("User provides Origin {string} and Destination {string} cities for round trip")
	public void user_provides_Origin_and_Destination_cities_for_round_trip(String origin, String destination) {
		selenium().HOMEPAGE.setOriginCity(origin);
		selenium().HOMEPAGE.setDestinationCity(destination);
	}
	
	@When("User provides departure date {string} and return date {string} for round trip")
	public void user_provides_departure_date_and_return_date_for_round_trip(String departureDate, String returnDate) {
		selenium().HOMEPAGE.setDepartureDateforRoundTrip(departureDate);
		selenium().HOMEPAGE.setReturnDate(returnDate);
	}
	
	@When("User click submit")
	public void user_click_submit() {
		selenium().HOMEPAGE.clickSearchFlights();
	}
	
	@Then("User should be able to navigate to search results page")
	public void user_should_be_able_to_navigate_to_search_results_page() {
		selenium().RESULTSPAGE.titleContains("Flights | Expedia");
	}
	
	@Then("User should be able to navigate to search results page with flights and hotels")
	public void user_should_be_able_to_navigate_to_search_results_page_with_flights_and_hotels() {
		Assert.assertTrue(selenium().RESULTSPAGE.titleContains("Hotel Search Results | Expedia"));
	}
	
	@When("User selects multiple adults with children")
	public void user_selects_multiple_adults_with_children() {
		selenium().HOMEPAGE.setAdultsAndChildren(3, 2);
	}
	
	@When("User select adults {string} , children {string} and infants {string}")
	public void user_select_adults_children_and_infants(String adults, String children, String infants) {
		int intAdults = Integer.parseInt(adults);
		int intChildren = Integer.parseInt(children);
		int intInfants = Integer.parseInt(infants);
		selenium().HOMEPAGE.setAdultsChildrenInfantsInFlightsTab(intAdults, intChildren,intInfants);
	}
	
	@When("User sets the preferred Airline as {string}")
	public void user_sets_the_preferred_Airline_as(String airline) {
		selenium().HOMEPAGE.setPreferredAirLine("Air India");		
	}

	@When("User sets preferred class as {string}")
	public void user_sets_preferred_class_as(String string) {
		selenium().HOMEPAGE.setPreferredClass("Business");
	}
	
	@Then("Error message saying more than six members are not allowed should be displayed")
	public void error_message_saying_more_than_six_members_are_not_allowed_should_be_displayed() {
		Boolean isErrorPresent = selenium().HOMEPAGE.errorMessageIfMorethanSixPassengersAreSelected();
		Assert.assertTrue(isErrorPresent);
	}
	
	@When("User selects the hotels option with checkin {string} and checkout date {string}")
	public void user_selects_the_hotels_option_with_checkin_and_checkout_date(String checkInDate, String checkOutDate) {
		selenium().HOMEPAGE.selectHotelsAlongWithFlights(checkInDate, checkOutDate);
	}
	
}
