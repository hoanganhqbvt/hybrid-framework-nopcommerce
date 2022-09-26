package pageObjects.orangeHRM.admin;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.orangeHRM.admin.QualificationPageUI;

public class QualificationPageObject extends BasePage{
	WebDriver driver;
	public QualificationPageObject(WebDriver driver) {
		this.driver = driver;
	}		
	
	public void clickToAddButtonByLabel(String addLabel) {
		waitForElementClickable(driver, QualificationPageUI.DYNAMIC_ADD_BUTTON_BY_LABEL, addLabel);
		clickToElement(driver, QualificationPageUI.DYNAMIC_ADD_BUTTON_BY_LABEL, addLabel);
	}
	public void inputToQualificationTextboxByLabel(String textboxLabel, String inputValue) {
		waitForElementVisible(driver, QualificationPageUI.DYNAMIC_TEXTBOX_BY_LABEL, textboxLabel);
		sendkeyToElement(driver, QualificationPageUI.DYNAMIC_TEXTBOX_BY_LABEL, inputValue, textboxLabel);
	}
	public void clickToSaveButton() {
		waitForElementClickable(driver, QualificationPageUI.SAVE_BUTTON_AT_EMPLOYEE_PAGE);
		clickToElement(driver, QualificationPageUI.SAVE_BUTTON_AT_EMPLOYEE_PAGE);
	}
	public boolean isSuccessAddedWorkExperienceMessageDisplayed() {
		waitForElementVisible(driver, QualificationPageUI.SUCCESS_ADDED_QUALIFICATIONS_MESSAGE);
		return isElementDisplay(driver, QualificationPageUI.SUCCESS_ADDED_QUALIFICATIONS_MESSAGE);
	}

	public boolean isValueOfCreatedQualificationByLabelAndIndexCorrect(String sectionLabel, String columnName, String rowNumber, String inputValue) {
		waitForElementVisible(driver, QualificationPageUI.COLUMN_INDEX_BY_NAME_AND_LABEL_OF_SECTION, sectionLabel, columnName);
		int columnIndex = getElementSize(driver, QualificationPageUI.COLUMN_INDEX_BY_NAME_AND_LABEL_OF_SECTION, sectionLabel, columnName) + 1;
		String actualVale = getElementText(driver, QualificationPageUI.TEXTBOX_BY_COLUMN_ROW_INDEX_AND_LABEL_SECTION, sectionLabel, rowNumber, String.valueOf(columnIndex));		
		boolean correct;
		 if(actualVale.equals(inputValue)) {
			 correct = true;
		 }else {correct = false;
		 
		 } return correct;
		 
	}
	
	
}
