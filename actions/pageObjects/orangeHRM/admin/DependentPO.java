package pageObjects.orangeHRM.admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.admin.AdminDependentPageUI;
import pageUIs.orangeHRM.admin.BasePageOrangeHRMUI;

public class DependentPO extends BasePage{
	WebDriver driver;

	public DependentPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToDependentNameTextbox(String dependentName) {
		waitForElementVisible(driver, AdminDependentPageUI.DEPENDENT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminDependentPageUI.DEPENDENT_NAME_TEXTBOX, dependentName);
	}

	public void selectRelationshipOptionInDropdownList(String dependentRelationship) {
		waitForElementClickable(driver, AdminDependentPageUI.RELATIONSHIP_ARROW_DROPDOWN_LIST);
		selectItemInCustomDropdown(driver, AdminDependentPageUI.RELATIONSHIP_ARROW_DROPDOWN_LIST, AdminDependentPageUI.RELATIONSHIP_OPTIONS_IN_DROPDOWN_LIST, dependentRelationship);
	}

	public void inputToDependentDOBTextbox(String dependentDOB) {
		waitForElementVisible(driver, AdminDependentPageUI.DEPENDENT_DOB_TEXTBOX);
		sendkeyToElement(driver, AdminDependentPageUI.DEPENDENT_DOB_TEXTBOX, dependentDOB);
		
	}

	public void clickToSaveDependentButton() {
		waitForElementClickable(driver, BasePageOrangeHRMUI.SAVE_BUTTON_AT_EMPLOYEE_PAGE);
		JavascriptExecutor js = (JavascriptExecutor) driver;		 
		js.executeScript("window.scrollBy(0,-250)");
		clickToElement(driver, BasePageOrangeHRMUI.SAVE_BUTTON_AT_EMPLOYEE_PAGE);
	}

	public boolean isSuccessAddedDependentMessageDisplayed() {
		waitForElementVisible(driver, AdminDependentPageUI.SUCCESS_ADDED_DEPENDENT_MESSAGE);
		return isElementDisplay(driver,  AdminDependentPageUI.SUCCESS_ADDED_DEPENDENT_MESSAGE);
	}

	public void clickToAddDependentButton() {
		waitForElementClickable(driver, AdminDependentPageUI.ADD_ASSIGNED_DEPENDENT_BUTTON);
		clickToElement(driver, AdminDependentPageUI.ADD_ASSIGNED_DEPENDENT_BUTTON);
	}
	
	
}
