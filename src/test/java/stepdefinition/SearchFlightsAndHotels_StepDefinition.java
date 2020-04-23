package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.ObjectsPage;
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


}
