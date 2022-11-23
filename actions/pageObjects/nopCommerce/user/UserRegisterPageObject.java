package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage{
	private WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}

	public void inputToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitForElementVisible(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}
	public String getErrorMessageDisplayedNextToRequiredFieldsTextbox(String fieldName) {
		waitForElementVisible(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE_BY_FIELD_NAME, fieldName);
		return getElementText(driver, RegisterPageUI.DYNAMIC_ERROR_MESSAGE_BY_FIELD_NAME, fieldName);				
	}
	public void inputToDynamicTextboxByID(String textboxID, String inputValue) {
		waitForElementVisible(driver, RegisterPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, RegisterPageUI.DYNAMIC_TEXTBOX_BY_ID, inputValue, textboxID);
	}
	public String getWrongEmailErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	public void selectGenderRadioButton(String radioText, String gender) {
		waitForElementVisible(driver, RegisterPageUI.DYNAMIC_RADIO_BUTTON_BY_TEXT, radioText);
		WebElement genderRadioElement = getWebElement(driver, RegisterPageUI.DYNAMIC_RADIO_BUTTON_BY_TEXT, radioText);
		if(!genderRadioElement.isSelected()){
			clickToElement(driver, RegisterPageUI.DYNAMIC_RADIO_BUTTON_BY_TEXT, radioText);
		} 		
	}
	public void selectDOBInDropdownListByName(String dropdownName, String inputDOB) {
		waitForElementVisible(driver, RegisterPageUI.DYNAMIC_DOB_BY_NAME, dropdownName);
		selectItemInDefaultDropdown(driver, RegisterPageUI.DYNAMIC_DOB_BY_NAME, inputDOB, dropdownName);
		
	}
	public CustomerInfoPO clickToMyaccountLink() {
		waitForElementVisible(driver, RegisterPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, RegisterPageUI.MY_ACCOUNT_LINK);		
		return PageGeneratorManager.getMyAccountPage(driver);
	}

	public UserComputerPageObject selectASubmenuByName(String menuName, String submenuName) {
		waitForElementVisible(driver, RegisterPageUI.DYNAMIC_MENU_HEADER_BY_NAME, menuName);
		hoverMouseToElement(driver, RegisterPageUI.DYNAMIC_MENU_HEADER_BY_NAME, menuName);
		waitForElementVisible(driver, RegisterPageUI.DYNAMIC_SUBMENU_BY_NAME, menuName, submenuName);
		clickToElement(driver, RegisterPageUI.DYNAMIC_SUBMENU_BY_NAME, menuName, submenuName);	
		return PageGeneratorManager.getUserComputerPage(driver);
	}
	
	
}
