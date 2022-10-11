package pageObject.bankGuru.user;

import org.openqa.selenium.WebDriver;


import commons.BasePage;
import pageUI.bankGuru.user.EditCustomerPageUI;

public class EditCustomerPO extends BasePage{
	WebDriver driver;
	public EditCustomerPO(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToCustomerInfoTextboxByFieldName(String fieldName, String inputValue) {
		waitForElementVisible(driver, EditCustomerPageUI.DYNAMIC_DETAIL_INFO_BY_FIELD_NAME, fieldName);
		sendkeyToElement(driver,  EditCustomerPageUI.DYNAMIC_DETAIL_INFO_BY_FIELD_NAME, inputValue, fieldName);
	}
	public String getErrorMessageNextToTextboxByFieldName(String fieldName) {
		waitForElementVisible(driver, EditCustomerPageUI.DYAMIC_ERROR_MESSAGE_NEXT_TO_TEXTBOX_BY_FIELD_NAME, fieldName);
		return getElementText(driver, EditCustomerPageUI.DYAMIC_ERROR_MESSAGE_NEXT_TO_TEXTBOX_BY_FIELD_NAME, fieldName);
		 
	}
	public void clickToSubmitButton() {
		waitForElementClickable(driver, EditCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);
	}
	public void inputToCustomerIDTextboxToGoToEditPage(String customerID) {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendkeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerID);
		
	}
	public void inputToAddressTextbox(String inputAddress) {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRES_TEXTBOX);
		sendkeyToElement(driver, EditCustomerPageUI.ADDRES_TEXTBOX, inputAddress);
		
	}

}
