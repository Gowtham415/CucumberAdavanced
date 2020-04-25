package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.ObjectsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFlightsAndHotels_StepDefinition {

	WebDriver driver;
	private DataVariableClass COMMON_DATA;

	public SearchFlightsAndHotels_StepDefinition(DataVariableClass data) {
		this.COMMON_DATA = data;
		this.driver = data.driver;
	}

	private ObjectsPage selenium() {
		return COMMON_DATA.selenium();
	}

	@When("Click on Flights and Hotels tab.")
	public void click_on_Flights_and_Hotels_tab() {
		selenium().HOMEPAGE.clickFlightsAndHotelsTab();
	}

	@Then("User should be able to get the options for searching flights and hotels.")
	public void user_should_be_able_to_get_the_options_for_searching_flights_and_hotels() {
		Assert.assertTrue(selenium().HOMEPAGE.isFlightsAndHotelsVisible());
	}

	@Given("User enters origin and destination city in package tab")
	public void user_enters_origin_and_destination_city_in_package_tab(DataTable dataTable) {
		selenium().HOMEPAGE.setOriginAndDestinationCitiesInPackageTab(dataTable.asList().get(0),
				dataTable.asList().get(1));
	}

	@Given("User enters departing and returning date in package tab")
	public void user_enters_departing_and_returning_date_in_package_tab(DataTable dataTable) {
		selenium().HOMEPAGE.setDepartureAndReturnDateInPackageTab(dataTable.asList().get(0), dataTable.asList().get(1));
	}

	@When("User clicks on search button in package search tab")
	public void user_clciks_on_search_button_in_package_search_tab() {
		selenium().HOMEPAGE.clickSubmitOnPackageTab();
	}

	@Given("User selects direct flights option")
	public void user_selects_direct_flights_option() {
		selenium().HOMEPAGE.selectDirectFlightsCheckBoxInPackageTab();
	}

	@When("User clicks on hotel for part of the trip checkbox")
	public void user_clicks_on_hotel_for_part_of_the_trip_checkbox() {
		selenium().HOMEPAGE.selectPartialHotelBookingCheckBox();
	}

	@When("User provides Checkin {string} and checkout {string} dates")
	public void user_provides_Checkin_and_checkout_dates(String checkInDate, String checkOutDate) {
		selenium().HOMEPAGE.setChecInAndCheckOutDatesForPartialHotelBooking(checkInDate, checkOutDate);

	}

	@Then("User should get error saying checkin and checkout dates must fall within departure and return dates")
	public void user_should_get_error_saying_checkin_and_checkout_dates_must_fall_within_departure_and_return_dates() {
		String actualMessage = selenium().HOMEPAGE.errorMessageForPartialHotelBookinginPackageTab();
		String expectedMessage = "Your partial check-in and check-out dates must fall within your arrival and departure dates. Please review your dates.";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

}
