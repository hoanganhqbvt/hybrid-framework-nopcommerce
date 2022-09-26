package pageObjects.orangeHRM.admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.admin.AdminSalaryPageUI;
import pageUIs.orangeHRM.admin.BasePageOrangeHRMUI;


public class SalaryPageObject extends BasePage {
	WebDriver driver;
	
	public SalaryPageObject(WebDriver driver){
		this.driver = driver;
	}

	public void clickToAddSalaryButton() {
		waitForElementClickable(driver, AdminSalaryPageUI.ADD_SALARY_BUTTON);
		clickToElement(driver, AdminSalaryPageUI.ADD_SALARY_BUTTON);
	}

	public void inputToSalaryTextboxByLabel(String textboxLabel, String dynamicValue) {
		waitForElementVisible(driver, AdminSalaryPageUI.DYNAMIC_TEXTBOX_ON_SALARY_BY_LABEL, textboxLabel);
		sendkeyToElement(driver, AdminSalaryPageUI.DYNAMIC_TEXTBOX_ON_SALARY_BY_LABEL, dynamicValue, textboxLabel);
	}

	public void selectOptionInDropdownListInSalaryByLabel(String textboxLabel, String dynamicValue) {		
		waitForElementClickable(driver, AdminSalaryPageUI.DYNAMIC_ARROW_DROPDOWN_LIST_BY_LABEL, textboxLabel);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;		 
		jsExecutor.executeScript("window.scrollBy(0,-200)");
		selectItemInCustomDropdown(driver, AdminSalaryPageUI.DYNAMIC_ARROW_DROPDOWN_LIST_BY_LABEL, AdminSalaryPageUI.DYNAMIC_SALARY_OPTION_IN_DROPDOWN_LIST_BY_LABEL, dynamicValue, textboxLabel);
	}

	public void clickToSaveCurrencyButton() {
		waitForElementClickable(driver, BasePageOrangeHRMUI.SAVE_BUTTON_AT_EMPLOYEE_PAGE);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;		 
		jsExecutor.executeScript("window.scrollBy(0,-200)");
		clickToElement(driver,  BasePageOrangeHRMUI.SAVE_BUTTON_AT_EMPLOYEE_PAGE);
	}

	public boolean isSuccessAddedSalaryMessageDisplayed() {
		waitForElementVisible(driver, AdminSalaryPageUI.SUCCESS_ADDED_SALARY_MESSAGE);
		return isElementDisplay(driver, AdminSalaryPageUI.SUCCESS_ADDED_SALARY_MESSAGE);
	}
	
	
}
