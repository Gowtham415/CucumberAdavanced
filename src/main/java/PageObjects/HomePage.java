package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	String originCityId = "flight-origin-hp-flight";
	String destinationCityID = "flight-destination-hp-flight";
	String departureDateSingleID = "flight-departing-single-hp-flight";
	String departureDateRoundTripID = "flight-departing-hp-flight";
	String returnDateID = "flight-returning-hp-flight";
	String searchFlightBtnXpath = "//section[@id='section-flight-tab-hp']//button[@type='submit']";
	
	
	public void clickFlightstab() {
		waitUntilElementisVisible(By.id("tab-flight-tab-hp")).click();
	}

	public void toggleOneWayTrip() {
		waitUntilElementisVisible(By.xpath("//label[@id='flight-type-one-way-label-hp-flight']//parent::div")).click();
	}

	public void setOriginCity(String city) {
		waitUntilElementisVisible(By.id(originCityId)).click();// To give additional time for driver to send keys
																// after element is found
		waitUntilElementisVisible(By.id(originCityId)).sendKeys(city);
	}

	public void setDestinationCity(String city) {
		waitUntilElementisVisible(By.id(destinationCityID)).click();// To give additional time for driver to send																// keys
		waitUntilElementisVisible(By.id(destinationCityID)).sendKeys(city);
	}
	
	public void setDepartureDate(String date) {
		waitUntilElementisVisible(By.id(departureDateSingleID)).clear();
		waitUntilElementisVisible(By.id(departureDateSingleID)).sendKeys(date);
		clickFlightstab();// To ensure other elements are visible
		
	}
	
	public void setDepartureDateforRoundTrip(String date) {
		waitUntilElementisVisible(By.id(departureDateRoundTripID)).click();
		waitUntilElementisVisible(By.id(departureDateRoundTripID)).sendKeys(date);
		clickFlightstab();// To ensure other elements are visible
	}
	
	public void setReturnDate(String date) {
		waitUntilElementisVisible(By.id(returnDateID)).click();
		waitUntilElementisVisible(By.id(returnDateID)).sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
		waitUntilElementisVisible(By.id(returnDateID)).sendKeys(date);
		clickFlightstab();// To ensure other elements are visible
	}

	public void clickSearchFlights() {
		WebElement e = waitUntilElementisVisible(By.xpath(searchFlightBtnXpath));
		action.moveToElement(e).click().build().perform();
	}
	
	
}
