package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.AddressPageUI;

public class UserAddressPageObject extends BasePage {		
	private WebDriver driver;
	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToDynamicTextboxByID(String textboxID, String inputValue) {
		waitForElementVisible(driver, AddressPageUI.DYNAMIC_TEXTBOX_BY_ID_ON_ADDRESS_PAGE, textboxID);
		sendkeyToElement(driver,AddressPageUI.DYNAMIC_TEXTBOX_BY_ID_ON_ADDRESS_PAGE, inputValue, textboxID);
	}
	public void clickToAddNewButton() {
		waitForElementClickable(driver, AddressPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AddressPageUI.ADD_NEW_ADDRESS_BUTTON);
	}
	public void selectOptionInDropdownListByID(String dropdownListID, String selectValue) {
		waitForElementVisible(driver, AddressPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID, dropdownListID);
		selectItemInDefaultDropdown(driver, AddressPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID, selectValue, dropdownListID);
		
	}
	public void clickToSaveButton() {
		waitForElementClickable(driver, AddressPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver,  AddressPageUI.SAVE_ADDRESS_BUTTON);
	}
	public String getAddedAddressInfoByLabel(String addressInfoLabel) {
		waitForElementVisible(driver, AddressPageUI.DYNAMIC_ADDRESS_INFO_BY_LABEL, addressInfoLabel);
		return getElementText(driver, AddressPageUI.DYNAMIC_ADDRESS_INFO_BY_LABEL, addressInfoLabel);
	}
	
}
