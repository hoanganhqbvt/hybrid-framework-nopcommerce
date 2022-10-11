package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.MyAccountPageUI;

public class CustomerInfoPO extends BasePage{
	WebDriver driver;

	public CustomerInfoPO(WebDriver driver) {		
		this.driver = driver;
	}

	public void selectGenderRadioButton(String radioText, String gender) {
			waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_RADIO_BUTTON_BY_TEXT, radioText);
			WebElement genderRadioElement = getWebElement(driver, MyAccountPageUI.DYNAMIC_RADIO_BUTTON_BY_TEXT, radioText);
			if(!genderRadioElement.isSelected()){
				clickToElement(driver, MyAccountPageUI.DYNAMIC_RADIO_BUTTON_BY_TEXT, radioText);
			} 		
		}
	
	public void selectDOBInDropdownListByName(String dropdownName, String inputDOB) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_DOB_BY_NAME, dropdownName);
		selectItemInDefaultDropdown(driver, MyAccountPageUI.DYNAMIC_DOB_BY_NAME, inputDOB, dropdownName);
		
	}

	public void inputToDynamicTextboxByID(String textboxID, String updateValue) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_BY_ID, updateValue, textboxID);		
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	public String getCustomerInfoByID(String textboxID, String attributeName) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttributeValue(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_BY_ID, attributeName, textboxID);
	}
	

	public boolean isGenderSelectedCorrectly(String radioText) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_RADIO_BUTTON_BY_TEXT, radioText);
		return isElementSelected(driver, MyAccountPageUI.DYNAMIC_RADIO_BUTTON_BY_TEXT, radioText);
	}

	public String getDOBValueByName(String dobName) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_DOB_SELECTED_VALUE_BY_NAME, dobName);
		return getElementText(driver, MyAccountPageUI.DYNAMIC_DOB_SELECTED_VALUE_BY_NAME, dobName);
	}
		
	}
	

