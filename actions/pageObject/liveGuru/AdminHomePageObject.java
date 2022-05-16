package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminHomePageObject extends BasePage{
	private WebDriver driver;
	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void closePopup() {
		waitForAlertPresence(driver);
		cancelAlert(driver);
	}
}
