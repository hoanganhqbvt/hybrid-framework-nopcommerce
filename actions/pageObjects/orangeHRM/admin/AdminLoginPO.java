package pageObjects.orangeHRM.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage{
	WebDriver driver;
	
	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToUsernameTextbox(String adminUsername) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_USERNAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.ADMIN_USERNAME_TEXTBOX, adminUsername);
	}
	public void inputToPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX, adminPassword);
	}
	public PIMEmployeeListPO clickOnLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		return PageGeneratorManagerOrangeHRM.getPIMEmployeeListPage(driver);
	}
	
}
