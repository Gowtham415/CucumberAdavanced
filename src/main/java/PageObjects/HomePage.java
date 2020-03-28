package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static Utilities.CommonUtilities.sleep;

import java.util.List;

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
		waitUntilElementisVisible(By.id(destinationCityID)).click();// To give additional time for driver to send //
																	// keys
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
		waitUntilElementisVisible(By.id(returnDateID)).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		waitUntilElementisVisible(By.id(returnDateID)).sendKeys(date);
		clickFlightstab();// To ensure other elements are visible
	}

	public void clickSearchFlights() {
		WebElement e = waitUntilElementisVisible(By.xpath(searchFlightBtnXpath));
		action.moveToElement(e).click().build().perform();
	}

	public void setAdultsAndChildren(int adults, int children) {
		waitUntilElementisVisible(By.xpath("//div[@id='traveler-selector-hp-flight']//li/button")).click();
		sleep(1);
		List<WebElement> elements = driver
				.findElements(By.xpath("//*[@id='traveler-selector-hp-flight']//div[1]/div[4]/button"));

		
		for (int k = 0; k <= elements.size(); k++) {
			/*
			 * Selecting the Adults based on adult count
			 */
			if (k == 0) {
				for (int i = 0; i <= adults - 2; i++) {
					elements.get(k).click();
				}
			}
			/*
			 * Selecting the Children based on adult count
			 */
			sleep(1);
			if (k == 1) {
				for (int i = 0; i <= children - 1; i++) {
					elements.get(k).click();
				}
				
				// Selecting the Ages of Children
				sleep(1);
				Select sel = new Select(driver.findElement(By.xpath("//div[@class='cols-nested children-data gcw-toggles-fields available-for-flights']//select[@id=\"flight-age-select-1-hp-flight\"]")));
				sel.selectByValue("10");
				
				Select sel2 = new Select(driver.findElement(By.xpath("//div[@class='cols-nested children-data gcw-toggles-fields available-for-flights']//select[@id=\"flight-age-select-2-hp-flight\"]")));
				sel2.selectByValue("10");
			}
			
		}
		
		clickFlightstab();// To ensure other elements are visible
	}

}
