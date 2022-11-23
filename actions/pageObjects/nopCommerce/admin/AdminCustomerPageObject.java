package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.admin.AdminCustomerPageUI;

public class AdminCustomerPageObject extends BasePage{
	WebDriver driver;
	public AdminCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToAddNewButton() {
		waitForElementClickable(driver, AdminCustomerPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.ADD_NEW_BUTTON);
	}
	public void inputToTextboxByID(String textboxID, String inputValue) {
		waitForElementVisible(driver, AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_ID, inputValue, textboxID);
	}
	public void selectGenderByID(String genderID) {
		waitForElementVisible(driver, AdminCustomerPageUI.DYNAMIC_GENDER_BY_ID, genderID);
		if(!isElementSelected(driver, AdminCustomerPageUI.DYNAMIC_GENDER_BY_ID, genderID)) {
			clickToElement(driver, AdminCustomerPageUI.DYNAMIC_GENDER_BY_ID, genderID);
		}
	}
	public void checkToCheckboxByID(String checkboxID) {
		waitForElementVisible(driver, AdminCustomerPageUI.DYNAMIC_CHECKBOX_BY_ID, checkboxID);
		if(!isElementSelected(driver, AdminCustomerPageUI.DYNAMIC_CHECKBOX_BY_ID, checkboxID)) {
			clickToElement(driver, AdminCustomerPageUI.DYNAMIC_CHECKBOX_BY_ID, checkboxID);
		}	
		
	}
	public void selectCustomerRoleInDropdown(String customerRole) {
		waitForElementVisible(driver, AdminCustomerPageUI.CUSTOMER_ROLE_DROPDOWN);
		selectItemInCustomDropdownNotUseJS(driver, AdminCustomerPageUI.CUSTOMER_ROLE_DROPDOWN, AdminCustomerPageUI.CUSTOMER_ROLE_OPTION_IN_DROPDOWN, customerRole);
		sleepInSecond(2);
	}
	public void selectVendorInDropdown(String vendor) {
		waitForElementVisible(driver, AdminCustomerPageUI.VENDOR_DROPDOWN);
		selectItemInDefaultDropdown(driver,  AdminCustomerPageUI.VENDOR_DROPDOWN, vendor);
	}
	public void selectNewLetterInDropdown(String newLetter) {
		waitForElementVisible(driver, AdminCustomerPageUI.NEW_LETTER_DROPDOWN);
		selectItemInCustomDropdownNotUseJS(driver, AdminCustomerPageUI.NEW_LETTER_DROPDOWN, AdminCustomerPageUI.NEW_LETTER_OPTION_IN_DROPDOWN, newLetter);
	}
	public void clickToSaveButton() {
		waitForElementClickable(driver, AdminCustomerPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.SAVE_BUTTON);
	}
	public void inputToAdminCommentArea(String adminComment) {
		waitForElementVisible(driver, AdminCustomerPageUI.ADMIN_COMMENT_TEXT_AREA);
		sendkeyToElement(driver, AdminCustomerPageUI.ADMIN_COMMENT_TEXT_AREA, adminComment);		
	}
	public String getAddedCustomerMessageResult() {
		waitForElementVisible(driver, AdminCustomerPageUI.SUCCESS_ADDED_CUSTOMER_MESSAGE);
		System.out.println(getElementText(driver, AdminCustomerPageUI.SUCCESS_ADDED_CUSTOMER_MESSAGE).replace("×", "").trim());
		return getElementText(driver, AdminCustomerPageUI.SUCCESS_ADDED_CUSTOMER_MESSAGE).replace("×", "").trim();
	}
	public void closePopupResultMessage() {
		waitForElementVisible(driver, AdminCustomerPageUI.CLOSE_ICON_ON_POPUP_RESULT_MESSAGE);
		clickToElement(driver,  AdminCustomerPageUI.CLOSE_ICON_ON_POPUP_RESULT_MESSAGE);
	}
}
