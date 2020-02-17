package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	String originCityId = "flight-origin-hp-flight";
	String destinationCityID = "flight-destination-hp-flight";
	String searchFlightBtnXpath = "//section[@id='section-flight-tab-hp']//button[@type='submit']";
	String departureDateSingleID = "flight-departing-single-hp-flight";
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
	}

	public void clickSearchFlights() {
		WebElement e = waitUntilElementisClickable(By.xpath(searchFlightBtnXpath));
		action.moveToElement(e).click().build().perform();
	}
}
