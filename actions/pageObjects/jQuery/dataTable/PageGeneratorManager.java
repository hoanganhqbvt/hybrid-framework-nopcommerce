package pageObjects.jQuery.dataTable;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	WebDriver driver;
	public static HomepageObject getHomePage(WebDriver driver) {
		return new HomepageObject(driver);
	}
	
	
}
