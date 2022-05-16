package pageObjects.jQuery.uploadFile;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	public static HomepageObject getHomePage(WebDriver driver) {
		return new HomepageObject(driver);
	}	
}
