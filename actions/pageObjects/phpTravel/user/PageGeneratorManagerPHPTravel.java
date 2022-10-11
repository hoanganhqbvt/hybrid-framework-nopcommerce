package pageObjects.phpTravel.user;

import org.openqa.selenium.WebDriver;



public class PageGeneratorManagerPHPTravel {
	public static UserLandingPageObject getUserLandingPage(WebDriver driver) {
		return new UserLandingPageObject(driver);
	}
	public static UserRegisterPageObjectPHPTravel getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObjectPHPTravel(driver);
	}
}
