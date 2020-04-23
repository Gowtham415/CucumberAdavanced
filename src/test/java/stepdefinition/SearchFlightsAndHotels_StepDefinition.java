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
		this.COMMON_DATA=data;
		this.driver=data.driver;
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
	    selenium().HOMEPAGE.setOriginAndDestinationCitiesInPackageTab(dataTable.asList().get(0), dataTable.asList().get(1));
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


}
