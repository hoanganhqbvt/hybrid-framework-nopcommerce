package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

	public class LoginPageObject extends BasePage{
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputEmailAddress(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	
	public void inputPassword(String password) {
	waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
	sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
}
	public MyDashboardPageObject clickToLoginButton() {
	waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
	clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	return PageGeneratorManager.getMyDashboardPage(driver);
	}
}
