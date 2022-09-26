package pageUIs.orangeHRM.admin;

public class EmployeeDetailPageUI {
	public static final String SAVE_IMAGE_BUTTON = "xpath=//button[text()=' Save ']";
	public static final String SUCCESS_UPDATED_MESSAGE = "xpath=//p[text()='Successfully Updated']";
	public static final String SUCCESS_SAVED_MESSAGE = "xpath=//p[text()='Successfully Saved']";
	public static final String PERSONAL_DETAIL_LINK = "xpath=//a[text()='Personal Details']";
	public static final String AVATAR_LINK = "css=.employee-image";
	public static final String UPLOAD_IMAGE_ICON ="xpath=//i[@class='oxd-icon bi-plus']";
	public static final String NICK_NAME_TEXTBOX = "xpath=//label[text()='Nickname']/parent::div/following-sibling::div/input";
	public static final String DRIVER_LICENSE_TEXTBOX = "xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input";
	public static final String SSN_NUMBER_TEXTBOX = "xpath=//label[text()='SSN Number']/parent::div/following-sibling::div/input";
	public static final String SIN_NUMBER_TEXTBOX = "xpath=//label[text()='SIN Number']/parent::div/following-sibling::div/input";
	public static final String NATIONALITY_DROPDOWN_LIST = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text--after']";
	public static final String MARTIAL_DROPDOWN_LIST = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text--after']";
	public static final String LICENSE_EXPIRE_DATE_CALENDER = "xpath=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";
	public static final String DATE_OF_BIRTH_CALENDER = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
	public static final String GENDER_RADIO_BUTTON = "xpath=//label[text()='Gender']/parent::div/following-sibling::div//label[text()='%s']";
	public static final String MILITARY_SERVICE_TEXTBOX = "xpath=//label[text()='Military Service']/parent::div/following-sibling::div/input";
	public static final String SMOKER_CHECKBOX = "xpath=//label[text()='Smoker']/parent::div/following-sibling::div//span";
	public static final String BLOOD_TYPE_DROPDOWN_LIST = "xpath=//label[text()='Blood Type']/parent::div/following-sibling::div//i";
	public static final String CUSTOMER_FIELDS_SAVE_BUTTON = "xpath=//div[@class='orangehrm-custom-fields']//button";
	public static final String REQUIRED_FIELDS_SAVE_BUTTON = "xpath=//p[text()=' * Required']/parent::div/button";
	public static final String NATIONAL_OPTIONS = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
	public static final String MARITAL_OPTIONS = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
	public static final String BLOOD_TYPE_OPTIONS = "xpath=//label[text()='Blood Type']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
	public static final String CONTACT_DETAIL_LINK = "xpath=//a[text()='Contact Details']";
	public static final String EMPLOYEE_ID_VALUE = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
}
