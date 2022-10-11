package pageObjects.phpTravel.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.phpTravel.user.UserRegisterPageUI;

public class UserRegisterPageObjectPHPTravel extends BasePage{
	WebDriver driver;

	public UserRegisterPageObjectPHPTravel(WebDriver driver) {
		this.driver = driver;
	}
	
public void clickToSignupButton() {
		waitForElementClickable(driver, UserRegisterPageUI.SIGNUP_BUTTON);
		clickToElement(driver, UserRegisterPageUI.SIGNUP_BUTTON);
	}
	public boolean isRequiredErrorMessageDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.REQUIRED_EEROR_MESSAGE);
		return isElementDisplay(driver, UserRegisterPageUI.REQUIRED_EEROR_MESSAGE);
	}

	public void clickToCaptchaCheckbox() {
		switchToFrameIframe(driver, UserRegisterPageUI.CAPTCHA_IFRAME);
		waitForElementClickable(driver, UserRegisterPageUI.CAPTCHA_CHECKBOX);
		sleepInSecond(5);
		clickToElement(driver, UserRegisterPageUI.CAPTCHA_CHECKBOX);
		switchToDefaultContent(driver);
	}

	public void clickToGotItButtonOnCookieConfirmation() {
		waitForElementClickable(driver, UserRegisterPageUI.COOKIE_GOT_IT_BUTTON);
		sleepInSecond(3);
		clickToElement(driver, UserRegisterPageUI.COOKIE_GOT_IT_BUTTON);
	}
}
