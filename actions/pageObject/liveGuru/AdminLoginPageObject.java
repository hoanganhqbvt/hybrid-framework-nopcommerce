package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	private WebDriver driver;
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputUsername(String userName) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, userName);
	}
	public void inputPassword(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	public void clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
	}
	
}
