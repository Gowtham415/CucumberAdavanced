package PageObjects;

import org.openqa.selenium.WebDriver;

public class ObjectsPage {

	/*
	 * When ever a new Page class is created it is import to add a variable for that page in this class
	 */
	
	Page PAGE;
	public HomePage HOMEPAGE;
	public ResultsPage RESULTSPAGE;

	public ObjectsPage(WebDriver driver) {
		PAGE = new Page(driver);
		HOMEPAGE = PAGE.getInstance(HomePage.class);
		RESULTSPAGE = PAGE.getInstance(ResultsPage.class);
	}

}
