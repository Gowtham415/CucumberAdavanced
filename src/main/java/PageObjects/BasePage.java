package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	// Some wrapper methods
	public WebElement waitUntilElementisVisible(By xpath) {
		return driverWait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
	}
	
	public Boolean waitUntilTitleContains(String titleText) {
		return driverWait.until(ExpectedConditions.titleContains(titleText));
	}
	
	public WebElement waitUntilElementisClickable(By xpath) {
		return driverWait.until(ExpectedConditions.elementToBeClickable(xpath));
	}

}
