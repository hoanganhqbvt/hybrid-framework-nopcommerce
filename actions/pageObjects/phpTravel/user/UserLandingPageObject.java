package pageObjects.phpTravel.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.phpTravel.user.UserLandingPageUI;

public class UserLandingPageObject extends BasePage{
 WebDriver driver;
	public UserLandingPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public UserRegisterPageObjectPHPTravel clickToOptionsInAccountMenu(String optionText) {
		waitForElementClickable(driver, UserLandingPageUI.ACCOUNT_BUTTON);
		clickToElement(driver, UserLandingPageUI.ACCOUNT_BUTTON);
		waitForElementVisible(driver, UserLandingPageUI.DYNAMIC_OPTIONS_IN_ACCOUNT_MENU_BY_TEXT, optionText);
		clickToElement(driver, UserLandingPageUI.DYNAMIC_OPTIONS_IN_ACCOUNT_MENU_BY_TEXT, optionText);
		return PageGeneratorManagerPHPTravel.getUserRegisterPage(driver);
	}

}
