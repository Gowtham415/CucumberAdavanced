package stepdefinition;

import org.testng.Assert;

import PageObjects.HomePage;
import PageObjects.ResultsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchHotels_StepDefinition {
	private DataVariableClass varData;
	
	public SearchHotels_StepDefinition(DataVariableClass varData) {
		this.varData=varData;
	}
	
	@Given("Click on Hotels tab")
	public void click_on_Hotels_tab() {
		varData.page.getInstance(HomePage.class).clickHotelsTab();
	}

	@When("User provides city to be searched for hotels")
	public void user_provides_city_to_be_searched_for_hotels(DataTable dataTable) {
		varData.page.getInstance(HomePage.class).setDestinationCityForHotels(dataTable.asList().get(0));
	}

	@When("User provides checkin date {string} in to hotel")
	public void user_provides_checkin_date_in_to_hotel(String checkIn) {
		varData.page.getInstance(HomePage.class).setCheckInDateForHotel(checkIn);
	}

	@When("User provides checkout date {string} from the hotel")
	public void user_provides_checkout_date_from_the_hotel(String checkOut) {
		varData.page.getInstance(HomePage.class).setCheckOutDateForHotel(checkOut);
	}

	@When("User click on search hotel button")
	public void user_click_on_search_hotel_button() {
		varData.page.getInstance(HomePage.class).clickOnHotelSearch();
	}

	@Then("User should be able to navigate to search results page for hotels")
	public void user_should_be_able_to_navigate_to_search_results_page_for_hotels() {
		Assert.assertTrue(varData.page.getInstance(ResultsPage.class).titleContains("Hotel Search Results"));
	}
	
	@When("User provide flights data for hotel search")
	public void user_provide_flights_data_for_hotel_search(io.cucumber.datatable.DataTable dataTable) {
		varData.page.getInstance(HomePage.class).AddFlightsWithHotel(dataTable.asList().get(0));
	}


}
