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

	public void setPassengerDetailsInFlightsTab(int adults, int children) {
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
			 * Selecting the Children based on children count
			 */
			sleep(1);
			if (k == 1) {
				for (int i = 0; i <= children - 1; i++) {
					elements.get(k).click();
				}

				// Selecting the Ages of Children
				sleep(1);
				Select sel = new Select(driver.findElement(By.xpath(
						"//div[@class='cols-nested children-data gcw-toggles-fields available-for-flights']//select[@id=\"flight-age-select-1-hp-flight\"]")));
				sel.selectByValue("10");

				Select sel2 = new Select(driver.findElement(By.xpath(
						"//div[@class='cols-nested children-data gcw-toggles-fields available-for-flights']//select[@id=\"flight-age-select-2-hp-flight\"]")));
				sel2.selectByValue("10");
			}

		}

		clickFlightstab();// To ensure other elements are visible
	}

	public void setPassengerDetailsInFlightsTab(int adults, int children, int infants) {

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
			 * Selecting the Children based on children count
			 */
			sleep(1);
			if (k == 1) {
				for (int i = 0; i <= children - 1; i++) {
					elements.get(k).click();
				}
				// Selecting the Ages of Children
				for (int j = 0; j < children; j++) {
					sleep(1);
					Select sel = new Select(driver.findElement(By.xpath(
							"//div[@class='cols-nested children-data gcw-toggles-fields available-for-flights']//select[@id=\"flight-age-select-"
									+ (j + 1) + "-hp-flight\"]")));
					sel.selectByValue("10");
				}
			}
			/*
			 * Selecting the Children based on children count
			 */
			if (k == 2) {
				for (int i = 0; i <= infants - 1; i++) {
					elements.get(k).click();
				}
				// Selecting the Ages of Children
				for (int j = 0; j < infants; j++) {
					sleep(1);
					Select sel = new Select(driver.findElement(By.xpath(
							"//select[@class='gcw-storeable gcw-toggles-field-by-value gcw-child-age-select gcw-infant-age-"
									+ (j + 1) + "-sa']")));
					sel.selectByValue("1");
				}
			}

		}
	}

	public void setPreferredAirLine(String preferredAirline) {
		String advancedOptionsID = "flight-advanced-options-hp-flight";
		driver.findElement(By.id(advancedOptionsID)).click();
		sleep(1);
		String preferredAirLineID = "flight-advanced-preferred-airline-hp-flight";
		Select selectAirline = new Select(driver.findElement(By.id(preferredAirLineID)));
		selectAirline.selectByVisibleText(preferredAirline);
		driver.findElement(By.id(advancedOptionsID)).click();
	}

	public void setPreferredClass(String preferredClass) {
		String advancedOptionsID = "flight-advanced-options-hp-flight";
		driver.findElement(By.id(advancedOptionsID)).click();
		sleep(1);
		String preferredClassID = "flight-advanced-preferred-class-hp-flight";
		Select selectAirline = new Select(driver.findElement(By.id(preferredClassID)));
		selectAirline.selectByVisibleText(preferredClass);
		sleep(1);
		driver.findElement(By.id(advancedOptionsID)).click();
	}

	public void clickHotelsTab() {
		waitUntilElementisVisible(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel"));
	}

	public void setDestinationCityForHotels(String city) {
		driver.findElement(By.id("hotel-destination-hp-hotel")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
	}

	public void setCheckInDateForHotel(String checkIn) {
		WebElement checkInElement = driver.findElement(By.id("hotel-checkin-hp-hotel"));
		checkInElement.sendKeys(checkIn);
	}

	public void setCheckOutDateForHotel(String checkOut) {
		WebElement checkOutElement = driver.findElement(By.id("hotel-checkout-hp-hotel"));
		checkOutElement.sendKeys(checkOut);
	}

	public void clickOnHotelSearch() {
		waitUntilElementisClickable(
				By.xpath("//section[@id='section-hotel-tab-hp']//span[contains(text(),'Search')]//parent::button"))
						.click();
	}

	public void AddFlightsWithHotel(String city) {
		driver.findElement(By.id("hotel-add-flight-checkbox-hp-hotel")).click();
		driver.findElement(By.id("hotel-flight-origin-hp-hotel")).sendKeys(city);
		clickHotelsTab();// To avoid this obstructing other webElements
	}

	public boolean errorMessageIfMorethanSixPassengersAreSelected() {
		List<WebElement> errorElement = driver.findElements(By.xpath(
				"//a[text()='We are only able to book between 1 and 6 travellers. Please adjust the number of travellers for your search.']"));
		if (errorElement.size() > 0) {
			return errorElement.get(0).isDisplayed();
		} else {
			return false;
		}
	}

	public void selectHotelsAlongWithFlights(String checkin, String checkOut) {
		sleep(1);
		driver.findElement(By.id("flight-add-hotel-checkbox-hp-flight")).click();
		driver.findElement(By.id("flight-hotel-checkin-hp-flight")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		driver.findElement(By.id("flight-hotel-checkin-hp-flight")).sendKeys(checkin);
		driver.findElement(By.id("flight-hotel-checkout-hp-flight")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		driver.findElement(By.id("flight-hotel-checkout-hp-flight")).sendKeys(checkOut);
		clickFlightstab();
	}

	public void setPassengersInHotelsTab(int adults, int children) {

		waitUntilElementisVisible(By.xpath("//form[@id='gcw-hotel-form-hp-hotel']//button[@data-gcw-component='gcw-traveler-amount-select']")).click();
		sleep(1);
		List<WebElement> elements = driver
				.findElements(By.xpath("//*[@id='traveler-selector-hp-hotel']//div/button"));
		for (int k = 0; k <= elements.size(); k++) {
			/*
			 * Selecting the Adults based on adult count
			 */
			if (k == 1) {
				for (int i = 0; i < adults - 2; i++) {// Already 2 Adults will be there by default.
					elements.get(k).click();
				}
			}
			
			/*
			 * Selecting the Children based on children count
			 */
			
			if(children>0) {
				sleep(1);
				if (k == 3) {
					for (int i = 0; i <= children - 1; i++) {
						elements.get(k).click();
					}
					// Selecting the Ages of Children
					for (int j = 0; j < children; j++) {
						sleep(1);
						Select sel = new Select(driver.findElement(By.xpath(
								"//form[@id='gcw-hotel-form-hp-hotel']//span[text()='Child "+(j+1)+" age']//following-sibling::select")));
						sel.selectByValue("10");
					}
				}	
			}	
		}
	}
	
	public void setPassengersInHotelsTab(int adults, int children,int rooms) {

		waitUntilElementisVisible(By.xpath("//form[@id='gcw-hotel-form-hp-hotel']//button[@data-gcw-component='gcw-traveler-amount-select']")).click();
		sleep(1);
		List<WebElement> elements = driver
				.findElements(By.xpath("//*[@id='traveler-selector-hp-hotel']//div/button"));
		for (int k = 0; k <= elements.size(); k++) {
			/*
			 * Selecting the Adults based on adult count
			 */
			if (k == 1) {
				for (int i = 0; i < adults - 2; i++) {// Already 2 Adults will be there by default.
					elements.get(k).click();
				}
			}
			
			/*
			 * Selecting the Children based on children count
			 */
			
			if(children>0) {
				sleep(1);
				if (k == 3) {
					for (int i = 0; i <= children - 1; i++) {
						elements.get(k).click();
					}
					// Selecting the Ages of Children
					for (int j = 0; j < children; j++) {
						sleep(1);
						Select sel = new Select(driver.findElement(By.xpath(
								"//form[@id='gcw-hotel-form-hp-hotel']//span[text()='Child "+(j+1)+" age']//following-sibling::select")));
						sel.selectByValue("10");
					}
				}	
			}	
		}
		
		if(rooms>1) {
			for(int m=0;m<rooms-1;m++) {
				driver.findElement(By.xpath("//form[@id='gcw-hotel-form-hp-hotel']//a[text()='Add another room']")).click();		
			}
		}
	}
	
	
	
	/*
	 * Flights and Hotels Search
	 */
	
	public void clickFlightsAndHotelsTab() {
		waitUntilElementisVisible(By.xpath("//button[@id='tab-package-tab-hp']")).click();
	}
	
	
	public boolean isFlightsAndHotelsVisible() {
		try {
			waitUntilElementisVisible(By.xpath("//input[@id='package-origin-hp-package']"));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public void setOriginAndDestinationCitiesInPackageTab(String origin,String destination) {
		waitUntilElementisVisible(By.xpath("//input[@id='package-origin-hp-package']")).click();
		waitUntilElementisVisible(By.xpath("//input[@id='package-origin-hp-package']")).sendKeys(origin);
		waitUntilElementisVisible(By.xpath("//input[@id='package-destination-hp-package']")).click();
		waitUntilElementisVisible(By.xpath("//input[@id='package-destination-hp-package']")).sendKeys(destination);
		sleep(1);
	}
	
	public void setDepartureAndReturnDateInPackageTab(String departureDate,String returnDate) {
		waitUntilElementisVisible(By.id("package-departing-hp-package")).click();
		waitUntilElementisVisible(By.id("package-departing-hp-package")).sendKeys(departureDate);
		waitUntilElementisVisible(By.id("package-returning-hp-package")).click();
		waitUntilElementisVisible(By.id("package-returning-hp-package")).sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
		waitUntilElementisVisible(By.id("package-returning-hp-package")).sendKeys(returnDate);
		sleep(1);
	}
	
	public void clickSubmitOnPackageTab() {
		waitUntilElementisClickable(By.id("search-button-hp-package")).click();
	}
	
	public void selectDirectFlightsCheckBoxInPackageTab() {
		waitUntilElementisVisible(By.id("packageDirectFlight-hp-package")).click();
	}

}
