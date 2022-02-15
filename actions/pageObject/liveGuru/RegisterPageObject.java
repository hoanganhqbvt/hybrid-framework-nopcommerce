package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
public MyDashboardPageObject clickToRegisterButton() {
	waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
	clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	return PageGeneratorManager.getMyDashboardPage(driver);
}

public void inputToFirstnameTextbox(String firstName) {
	waitForAllElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
	sendkeyToElement(driver,  RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
}
public void inputToLastnameTextbox(String lastName) {
	waitForAllElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
	sendkeyToElement(driver,  RegisterPageUI.LASTNAME_TEXTBOX, lastName);
}
public void inputToEmailTextbox(String emailAddress) {
	waitForAllElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
	sendkeyToElement(driver,  RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
}
public void inputToPasswordTextbox(String password) {
	waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
	sendkeyToElement(driver,  RegisterPageUI.PASSWORD_TEXTBOX, password);
}
public void inputToConfirmPasswordTextbox(String confirmPassword) {
	waitForAllElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
	sendkeyToElement(driver,  RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirmPassword);
}

}
