package pageObject.bankGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.bankGuru.user.AccessDetailInfoPageUI;

public class RegisterPageObject extends BasePage{
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailIDTextbox(String emailAdd) {
		waitForElementVisible(driver, AccessDetailInfoPageUI.EMAIL_ID_TEXTBOX);
		sendkeyToElement(driver, AccessDetailInfoPageUI.EMAIL_ID_TEXTBOX, emailAdd);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, AccessDetailInfoPageUI.SUBMIT_BUTTON);
		clickToElement(driver, AccessDetailInfoPageUI.SUBMIT_BUTTON);
	}

	public String getDetailAccessInfoByText(String dynamicText) {
		waitForElementVisible(driver, AccessDetailInfoPageUI.DYNAMIC_USERID_PASSWORD_BY_TEXT, dynamicText);
		return getElementText(driver, AccessDetailInfoPageUI.DYNAMIC_USERID_PASSWORD_BY_TEXT, dynamicText);
	}
	
	public LoginPageObject openLoginPageURL(String loginPageURL) {
		openPageUrl(driver, loginPageURL);
		return PageGeneratorManagerBankGuru.getLoginPage(driver);
	}
	
}
