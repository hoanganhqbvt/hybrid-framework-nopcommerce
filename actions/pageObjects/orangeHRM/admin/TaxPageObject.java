package pageObjects.orangeHRM.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.admin.AdminSalaryPageUI;
import pageUIs.orangeHRM.admin.AdminTaxPageUI;
import pageUIs.orangeHRM.admin.BasePageOrangeHRMUI;

public class TaxPageObject extends BasePage{
	WebDriver driver;
	public TaxPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void selectFerderalTaxStatusInDropdownList(String ferderalTaxStatus) {
		waitForElementClickable(driver, AdminTaxPageUI.NARROW_IN_DROPDOWN_IN_FERDERAL_INCOME_TAX);
		selectItemInCustomDropdown(driver, AdminTaxPageUI.NARROW_IN_DROPDOWN_IN_FERDERAL_INCOME_TAX, AdminTaxPageUI.OPTIONS_IN_STATUS_DROPDOWN_IN_FERDERAL_INCOME_TAX, ferderalTaxStatus);
		
	}
	public void inputToFerderalTaxExemptionTextbox(String ferderalTaxExemption) {
		waitForElementVisible(driver, AdminTaxPageUI.EXEMPTION_TEXTBOX_FERDERAL_INCOME_TAX);
		sendkeyToElement(driver, AdminTaxPageUI.EXEMPTION_TEXTBOX_FERDERAL_INCOME_TAX, ferderalTaxExemption);
		
	}
	public void selectStateTaxOptionInDropdownListByLabel(String stateDropdownLabel, String selectOption) {
		waitForElementClickable(driver, AdminTaxPageUI.DYNAMIC_NARROW_IN_DROPDOWN_IN_STATE_INCOME_TAX, stateDropdownLabel);
		selectItemInCustomDropdown(driver, AdminTaxPageUI.DYNAMIC_NARROW_IN_DROPDOWN_IN_STATE_INCOME_TAX,AdminTaxPageUI.DYNAMIC_OPTIONS_IN_DROPDOWN_IN_STATE_INCOME_TAX, selectOption, stateDropdownLabel);
	}
	public void inputToStateTaxExemptionTextbox(String stateTaxExemption) {
		waitForElementVisible(driver, AdminTaxPageUI.EXEMPTION_TEXTBOX_STATE_INCOME_TAX);	
		sendkeyToElement(driver, AdminTaxPageUI.EXEMPTION_TEXTBOX_STATE_INCOME_TAX, stateTaxExemption);
	}
	public void clickToSaveTaxButton() {
		waitForElementClickable(driver, BasePageOrangeHRMUI.SAVE_BUTTON_AT_EMPLOYEE_PAGE);
		clickToElement(driver,  BasePageOrangeHRMUI.SAVE_BUTTON_AT_EMPLOYEE_PAGE);
	}
	public boolean isSuccessAddedTaxMessageDisplayed() {
		waitForElementVisible(driver, AdminTaxPageUI.SUCCESS_ADDED_TAX_MESSAGE);
		return isElementDisplay(driver, AdminTaxPageUI.SUCCESS_ADDED_TAX_MESSAGE);
	}
}
