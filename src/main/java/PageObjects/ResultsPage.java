package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage extends BasePage {

	public ResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean titleContains(String title) {
		return driverWait.until(ExpectedConditions.titleContains(title));
	}

}
