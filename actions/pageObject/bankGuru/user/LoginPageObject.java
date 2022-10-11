package pageObject.bankGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.bankGuru.user.LoginPageUI;

public class LoginPageObject extends BasePage{
 WebDriver driver;
 
 public LoginPageObject(WebDriver driver) {
	 this.driver = driver;
 }

public void inputToUserIDPasswordTextbox(String dynamicText, String inputValue) {
	waitForElementVisible(driver, LoginPageUI.DYNAMIC_USERID_PASSWORD_BY_TEXT, dynamicText);
	sendkeyToElement(driver, LoginPageUI.DYNAMIC_USERID_PASSWORD_BY_TEXT, inputValue, dynamicText);
}

public ManagerPageObject clickToLoginButton() {
	waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
	clickToElement(driver, LoginPageUI.LOGIN_BUTTON);	
	return PageGeneratorManagerBankGuru.getManagerPage(driver);
}
 
 
}
