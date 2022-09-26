package pageObjects.orangeHRM.admin;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.orangeHRM.admin.AdminEmergencyPageUI;
import pageUIs.orangeHRM.admin.BasePageOrangeHRMUI;

public class EmergencyContactPO extends BasePage {
	WebDriver driver;
	
	public EmergencyContactPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddEmergencyButton() {
		waitForElementClickable(driver, AdminEmergencyPageUI.ADD_EMERGENCY_BUTTON);
		clickToElement(driver, AdminEmergencyPageUI.ADD_EMERGENCY_BUTTON);
	}

	public void inputToEmergencyNameTextbox(String label, String emergencyName) {
		waitForElementVisible(driver, AdminEmergencyPageUI.EMERGENCY_TEXTBOX_BY_LABEL, label);
		sendkeyToElement(driver, AdminEmergencyPageUI.EMERGENCY_TEXTBOX_BY_LABEL, emergencyName, label);
	}

	public void clickToSaveEmergenctDetailButton() {
		waitForElementClickable(driver, BasePageOrangeHRMUI.SAVE_BUTTON_AT_EMPLOYEE_PAGE);
		clickToElement(driver, BasePageOrangeHRMUI.SAVE_BUTTON_AT_EMPLOYEE_PAGE);
	}

	public boolean isSaveEmergencyDetailMessageDisplayed() {
		waitForElementVisible(driver, AdminEmergencyPageUI.SUCCESS_UPDATED_EMERGENCY_DETAIL_MESSAGE);
		return isElementDisplay(driver, AdminEmergencyPageUI.SUCCESS_UPDATED_EMERGENCY_DETAIL_MESSAGE);
	}
	
	
}
