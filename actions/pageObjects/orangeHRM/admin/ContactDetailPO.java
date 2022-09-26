package pageObjects.orangeHRM.admin;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.orangeHRM.admin.AdminContactDetailUI;

public class ContactDetailPO extends BasePage {
	WebDriver driver;
	
	public ContactDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTextboxByLabel(String label, String value) {
		waitForElementVisible(driver, AdminContactDetailUI.CONTACT_DETAIL_TEXTBOX_BY_LABEL, label);
		sendkeyToElement(driver, AdminContactDetailUI.CONTACT_DETAIL_TEXTBOX_BY_LABEL, value, label);		
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, AdminContactDetailUI.SAVE_CONTACT_DETAIL_BUTTON);
		clickToElement(driver,  AdminContactDetailUI.SAVE_CONTACT_DETAIL_BUTTON);
	}

	public boolean isSaveContactDetailMessageDisplayed() {
		waitForElementVisible(driver, AdminContactDetailUI.SUCCESS_UPDATED_CONTACT_DETAIL_MESSAGE);
		return isElementDisplay(driver, AdminContactDetailUI.SUCCESS_UPDATED_CONTACT_DETAIL_MESSAGE);
	}

	public void selectCountryFromDropdownList(String countryName) {
		waitForElementClickable(driver, AdminContactDetailUI.COUNTRY_DROPDOWN_LIST_ARROW);
		selectItemInCustomDropdown(driver, AdminContactDetailUI.COUNTRY_DROPDOWN_LIST_ARROW, AdminContactDetailUI.COUNTRY_OPTIONS_IN_DROPDOWN_LIST, countryName);
		
	}
	
	
}
