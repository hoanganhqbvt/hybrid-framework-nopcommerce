package pageObjects.orangeHRM.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.admin.EmployeeDetailPageUI;
import pageUIs.orangeHRM.admin.PIMPageUI;

public class EmployeeDetailPO extends BasePage {
	WebDriver driver;
	
	public EmployeeDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAvatarIcon() {
		waitForElementVisible(driver, EmployeeDetailPageUI.AVATAR_LINK);
		clickToElement(driver, EmployeeDetailPageUI.AVATAR_LINK);
		
	}

	public void clickToUploadImageIcon() {
		waitForElementClickable(driver, EmployeeDetailPageUI.UPLOAD_IMAGE_ICON);
		clickToElement(driver, EmployeeDetailPageUI.UPLOAD_IMAGE_ICON);
		
	}

	public void uploadAvatarImage(String fileName) {
		uploadMultipleFiles(driver, fileName);
		clickToElement(driver, EmployeeDetailPageUI.SAVE_IMAGE_BUTTON);
		
	}

	public boolean isUploadAvatarSuccessMessageDisplayed() {
		waitForElementVisible(driver, EmployeeDetailPageUI.SUCCESS_UPDATED_MESSAGE);
		return isElementDisplay(driver, EmployeeDetailPageUI.SUCCESS_UPDATED_MESSAGE);
	}

	public PersonalDetailPO clickToPersonalDetailLink() {
		waitForElementClickable(driver, EmployeeDetailPageUI.PERSONAL_DETAIL_LINK);
		clickToElement(driver, EmployeeDetailPageUI.PERSONAL_DETAIL_LINK);
		sleepInSecond(2);
		return PageGeneratorManagerOrangeHRM.getPersonalDetailPage(driver);		
	}
	
	
	
}
