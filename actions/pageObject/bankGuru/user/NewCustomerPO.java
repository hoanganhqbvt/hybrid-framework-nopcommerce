package pageObject.bankGuru.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commons.BasePage;
import pageUI.bankGuru.user.NewCustomerPageUI;

public class NewCustomerPO extends BasePage{
	WebDriver driver;

	public NewCustomerPO(WebDriver driver) {		
		this.driver = driver;
	}

	public void inputToDynamicTextboxByName(String textboxName, String inputValue) {
		waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxName);
		sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, inputValue, textboxName);		
	}

	public void enterToDynamicTextboxByNameAndTabOut(String textboxName) {
		waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxName);
		WebElement textbox = getWebElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxName);
		textbox.click();
		textbox.sendKeys(Keys.TAB);				
	}
	public String getErrorMesageDisplayedNextToDynamicTextbox(String textboxName) {
		waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_ERROR_MESSAGE_DISPLAYED_NEXT_TO_BLANK_TEXTBOX, textboxName);
		return getElementText(driver, NewCustomerPageUI.DYNAMIC_ERROR_MESSAGE_DISPLAYED_NEXT_TO_BLANK_TEXTBOX, textboxName);
	}

	public void enterToAddressTextboxAndTabOut() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTBOX);
		WebElement textbox = getWebElement(driver, NewCustomerPageUI.ADDRESS_TEXTBOX);
		textbox.click();
		textbox.sendKeys(Keys.TAB);	
		
	}

	public void inputToAddressTextbox(String inputValue) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTBOX, inputValue);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
	}

	public boolean isCreatedNewCustomerSuccessMessageDisplayed() {
		return isElementDisplay(driver, NewCustomerPageUI.SUCCESS_CREATED_NEW_CUSTOMER_MESSAGE);
		
	}

	public String getCustomerInfoByFieldName(String fieldName) {
		waitForElementVisible(driver, NewCustomerPageUI.FIELD_VALUE_BY_FIELD_NAME, fieldName);
		return getElementText(driver, NewCustomerPageUI.FIELD_VALUE_BY_FIELD_NAME, fieldName);
		
	}

	public void inputToDOBTextboxByJS(String dOB) {
		waitForElementVisible(driver, NewCustomerPageUI.DOB_TEXTBOX);
		removeAttributeInDOM(driver, NewCustomerPageUI.DOB_TEXTBOX, "type");		
		sendkeyToElement(driver, NewCustomerPageUI.DOB_TEXTBOX, dOB);
	}

	public String getDetailInfoOfCreatedCustomerByFieldName(String fieldName) {
		waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_VALUE_OF_CREATED_CUSTOMER_BY_FIELD_NAME, fieldName);
		return getElementText(driver, NewCustomerPageUI.DYNAMIC_VALUE_OF_CREATED_CUSTOMER_BY_FIELD_NAME, fieldName);
		
	}

	
		
	
}
