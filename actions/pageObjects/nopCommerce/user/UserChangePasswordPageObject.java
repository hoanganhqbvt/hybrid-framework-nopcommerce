package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage{
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToDynamicTextboxOnChangePasswordPageByID(String textboxID, String inputValue) {
		waitForElementVisible(driver, UserChangePasswordPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver,  UserChangePasswordPageUI.DYNAMIC_TEXTBOX_BY_ID, inputValue, textboxID);
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);		
	}

	public String getChangePasswordSuccessMessage() {
		waitForElementVisible(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		return getElementText(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}

	public void closeChangePasswordSuccessMessage() {
		waitForElementVisible(driver, UserChangePasswordPageUI.CLOSE_CHANGE_PASSWORD_SUCCESS_MESSAGE);
		clickToElement(driver, UserChangePasswordPageUI.CLOSE_CHANGE_PASSWORD_SUCCESS_MESSAGE);
		sleepInSecond(2);
	}
	
}
