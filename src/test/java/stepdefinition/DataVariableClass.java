package stepdefinition;

import org.openqa.selenium.WebDriver;

import PageObjects.ObjectsPage;
import PageObjects.Page;

public class DataVariableClass {
	WebDriver driver;
	String title;
	Page page;
	String baseUrl = "https://www.expedia.co.in/";
		
	public ObjectsPage selenium() {
		return new ObjectsPage(this.driver);
	}
}
