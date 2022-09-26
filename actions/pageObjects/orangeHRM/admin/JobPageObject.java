package pageObjects.orangeHRM.admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.admin.AdminJobPageUI;
import pageUIs.orangeHRM.admin.BasePageOrangeHRMUI;

public class JobPageObject extends BasePage{
	WebDriver driver;

	public JobPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToJoinedDateTextbox(String joinedDate) {
		sleepInSecond(3);
		waitForElementVisible(driver, AdminJobPageUI.JOINED_DATE_TEXTBOX);		
		sendkeyToElement(driver, AdminJobPageUI.JOINED_DATE_TEXTBOX, joinedDate);				
	}

	public void selectOptionInDropdownListByLabel(String jobDropdownLabel, String jobTitle) {
		waitForElementClickable(driver, AdminJobPageUI.DYNAMIC_ARROW_DROPDOWN_LIST_BY_LABEL, jobDropdownLabel);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;		 
		jsExecutor.executeScript("window.scrollBy(0,-250)");
		selectItemInCustomDropdown(driver, AdminJobPageUI.DYNAMIC_ARROW_DROPDOWN_LIST_BY_LABEL, AdminJobPageUI.DYNAMIC_JOB_OPTION_IN_DROPDOWN_LIST_BY_LABEL, jobTitle, jobDropdownLabel);
		
	}

	public void clickToSaveJobButton() {
		waitForElementClickable(driver, BasePageOrangeHRMUI.SAVE_BUTTON_AT_EMPLOYEE_PAGE);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;		 
		jsExecutor.executeScript("window.scrollBy(0,-250)");
		clickToElement(driver, BasePageOrangeHRMUI.SAVE_BUTTON_AT_EMPLOYEE_PAGE);
	}

	public boolean isSuccessAddedJobMessageDisplayed() {
		waitForElementVisible(driver, AdminJobPageUI.SUCCESS_ADDED_JOB_MESSAGE);
		return isElementDisplay(driver, AdminJobPageUI.SUCCESS_ADDED_JOB_MESSAGE);
	}
	
}
