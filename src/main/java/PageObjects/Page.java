package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	WebDriver driver;
	WebDriverWait driverWait;
	Actions action;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		this.driverWait = new WebDriverWait(this.driver, 10);
		this.action = new Actions(driver);
	}
	
	public <T extends BasePage> T getInstance(Class<T> className){
		try {
			return className.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
