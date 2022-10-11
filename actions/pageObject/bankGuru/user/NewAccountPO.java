package pageObject.bankGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.bankGuru.user.NewAccountPageUI;

public class NewAccountPO extends BasePage{
	WebDriver driver;

	public NewAccountPO(WebDriver driver) {		
		this.driver = driver;
	}

	public void inputToNewAccountTextboxByName(String textboxName, String inputValue) {
		waitForElementVisible(driver, NewAccountPageUI.DYNAMIC_TEXTBOX_ON_NEW_ACCOUNT_PAGE_BY_NAME, textboxName);
		sendkeyToElement(driver, NewAccountPageUI.DYNAMIC_TEXTBOX_ON_NEW_ACCOUNT_PAGE_BY_NAME, inputValue, textboxName);
		
	}

	public void selectAccountTypeIndropdownList(String accountType) {
		waitForElementVisible(driver, NewAccountPageUI.ACCOUNT_TYPE, accountType);
		selectItemInDefaultDropdown(driver, NewAccountPageUI.ACCOUNT_TYPE, accountType);
		
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, NewAccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewAccountPageUI.SUBMIT_BUTTON);
	}

	public boolean isSuccessCreatedNewAccountMessageDisplayed() {
		waitForElementVisible(driver, NewAccountPageUI.SUCCESS_CREATED_NEW_ACCOUNT_MESSAGE);
		return isElementDisplay(driver, NewAccountPageUI.SUCCESS_CREATED_NEW_ACCOUNT_MESSAGE);
	}

	public String getDetailInfoOfCreatedAccountByFieldName(String fieldName) {
		waitForElementVisible(driver, NewAccountPageUI.DETAIL_ACCOUNT_INFO_BY_FIELD_NAME, fieldName);
		return getElementText(driver, NewAccountPageUI.DETAIL_ACCOUNT_INFO_BY_FIELD_NAME, fieldName);
		
	}
	
	
}
