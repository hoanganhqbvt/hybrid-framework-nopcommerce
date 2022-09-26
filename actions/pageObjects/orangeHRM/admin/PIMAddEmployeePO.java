package pageObjects.orangeHRM.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.admin.PIMPageUI;

public class PIMAddEmployeePO extends BasePage{
	WebDriver driver;
	public PIMAddEmployeePO(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, PIMPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, PIMPageUI.FIRST_NAME_TEXTBOX, firstname);
		
	}
	public void inputToMiddlenameTextbox(String middlename) {
		waitForElementVisible(driver, PIMPageUI.MIDDLE_NAME_TEXTBOX);
		sendkeyToElement(driver, PIMPageUI.MIDDLE_NAME_TEXTBOX, middlename);
		
	}
	public void inputToLastnameTextbox(String lastname) {
		waitForElementVisible(driver, PIMPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, PIMPageUI.LAST_NAME_TEXTBOX, lastname);
		sleepInSecond(2);
		
	}
	public void clickToCreateLoginDetailButton() {
		waitForElementClickable(driver, PIMPageUI.CREATE_LOGIN_DETAIL_SWITCH_BUTTON);
		clickToElement(driver, PIMPageUI.CREATE_LOGIN_DETAIL_SWITCH_BUTTON);
		
	}
	public void inputToUsernameTextbox(String username) {
		waitForElementVisible(driver, PIMPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, PIMPageUI.USERNAME_TEXTBOX, username);
		
	}
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, PIMPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, PIMPageUI.PASSWORD_TEXTBOX, password);
		
	}
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, PIMPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, PIMPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}
	public void clickToSaveButton() {
		waitForElementClickable(driver, PIMPageUI.SAVE_BUTTON);
		clickToElement(driver, PIMPageUI.SAVE_BUTTON);
		
	}
	public boolean isAddEmployeeSuccessMessageDisplayed() {
		waitForElementVisible(driver, PIMPageUI.SUCCESS_MESSAGE);		
		return isElementDisplay(driver, PIMPageUI.SUCCESS_MESSAGE);
	}
	
	public void inputToEmployeeIDTextbox(String employeeID) {
		waitForElementVisible(driver, PIMPageUI.EMPLOYEE_ID_TEXTBOX);
		sendkeyToElement(driver, PIMPageUI.EMPLOYEE_ID_TEXTBOX, employeeID);
	}

}
