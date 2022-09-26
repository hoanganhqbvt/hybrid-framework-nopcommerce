package pageObjects.orangeHRM.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.admin.EmployeeDetailPageUI;

public class PersonalDetailPO extends BasePage{
	WebDriver driver;
	
	public PersonalDetailPO(WebDriver driver){
		this.driver = driver;		
	}

	public void inputToNicknameTextbox(String nickname) {
		waitForElementVisible(driver, EmployeeDetailPageUI.NICK_NAME_TEXTBOX);
		//clickToElement(driver, EmployeeDetailPageUI.NICK_NAME_TEXTBOX);
		sendkeyToElement(driver, EmployeeDetailPageUI.NICK_NAME_TEXTBOX, nickname);
		
	}

	public void inputToDriverLicenseTextbox(String driverLicenseNumber) {
		waitForElementVisible(driver, EmployeeDetailPageUI.DRIVER_LICENSE_TEXTBOX);
		sendkeyToElement(driver, EmployeeDetailPageUI.DRIVER_LICENSE_TEXTBOX, driverLicenseNumber);
		
	}

	public void inputToSSNNumberTextbox(String ssnNumber) {
		waitForElementVisible(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX);
		sendkeyToElement(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX, ssnNumber);
		
	}

	public void inputToSINNumberTextbox(String sinNumber) {
		waitForElementVisible(driver, EmployeeDetailPageUI.SIN_NUMBER_TEXTBOX);
		sendkeyToElement(driver, EmployeeDetailPageUI.SIN_NUMBER_TEXTBOX, sinNumber);
		
	}

	public void inputToMilitaryServiceTextbox(String militaryService) {
		waitForElementVisible(driver, EmployeeDetailPageUI.MILITARY_SERVICE_TEXTBOX);
		sendkeyToElement(driver, EmployeeDetailPageUI.MILITARY_SERVICE_TEXTBOX, militaryService);
		
	}

	public void selectGenderRadioButton(String gender) {
		waitForElementClickable(driver, EmployeeDetailPageUI.GENDER_RADIO_BUTTON, gender);
		clickToElement(driver, EmployeeDetailPageUI.GENDER_RADIO_BUTTON, gender);
		
	}

	public void selectSmokerCheckbox() {
		waitForElementClickable(driver, EmployeeDetailPageUI.SMOKER_CHECKBOX);
		clickToElement(driver, EmployeeDetailPageUI.SMOKER_CHECKBOX);
		
	}

	public void inputToExpireDirverLicenseTextbox(String expireDriverLicenseDate) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LICENSE_EXPIRE_DATE_CALENDER);
		sendkeyToElement(driver, EmployeeDetailPageUI.LICENSE_EXPIRE_DATE_CALENDER, expireDriverLicenseDate);
		
	}

	public void inputToDateOfBirthTextbox(String dateOfBirth) {
		waitForElementVisible(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_CALENDER);
		sendkeyToElement(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_CALENDER, dateOfBirth);
		
	}

	public void clickToSaveRequiredFieldsButton() {
		waitForElementClickable(driver, EmployeeDetailPageUI.REQUIRED_FIELDS_SAVE_BUTTON);
		clickToElement(driver,EmployeeDetailPageUI.REQUIRED_FIELDS_SAVE_BUTTON);		
	}
	
	public void clickToSaveCustomFieldsButton() {
		waitForElementClickable(driver, EmployeeDetailPageUI.CUSTOMER_FIELDS_SAVE_BUTTON);
		clickToElement(driver,EmployeeDetailPageUI.CUSTOMER_FIELDS_SAVE_BUTTON);		
	}
	
	public boolean isSuccessUpdatePersonalDetailMessageDisplayed() {
		waitForElementVisible(driver, EmployeeDetailPageUI.SUCCESS_UPDATED_MESSAGE);
		return isElementDisplay(driver, EmployeeDetailPageUI.SUCCESS_UPDATED_MESSAGE);
	}
	
	public boolean isSuccessSavePersonalDetailMessageDisplayed() {
		waitForElementVisible(driver, EmployeeDetailPageUI.SUCCESS_SAVED_MESSAGE);
		return isElementDisplay(driver, EmployeeDetailPageUI.SUCCESS_SAVED_MESSAGE);
	}

	public void selectNationalityFromDropdownList(String nationality) {
		selectItemInCustomDropdown(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_LIST, EmployeeDetailPageUI.NATIONAL_OPTIONS, nationality);
	}

	public void selectMaritalStatusFromDropdownList(String maritalStatus) {		
		selectItemInCustomDropdown(driver, EmployeeDetailPageUI.MARTIAL_DROPDOWN_LIST, EmployeeDetailPageUI.MARITAL_OPTIONS, maritalStatus);
		
	}

	public void selectBloodTypeFromDropdownList(String bloodType) {
		selectItemInCustomDropdown(driver, EmployeeDetailPageUI.BLOOD_TYPE_DROPDOWN_LIST, EmployeeDetailPageUI.BLOOD_TYPE_OPTIONS, bloodType);
		
	}
	
	public ContactDetailPO clickToContactDetailLink() {
		waitForElementClickable(driver, EmployeeDetailPageUI.CONTACT_DETAIL_LINK);
		clickToElement(driver, EmployeeDetailPageUI.CONTACT_DETAIL_LINK);
		sleepInSecond(5);
		return PageGeneratorManagerOrangeHRM.getContactDetailPage(driver);
		
	}

	public String getEmployeeIDValue() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_VALUE);
		return getElementText(driver, EmployeeDetailPageUI.EMPLOYEE_ID_VALUE);
		
	}

}
