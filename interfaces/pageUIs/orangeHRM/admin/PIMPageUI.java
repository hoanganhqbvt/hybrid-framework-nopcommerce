package pageUIs.orangeHRM.admin;

public class PIMPageUI {
	public static final String ADD_BUTTON_ON_EMPLOYEE_LIST_PAGE = "xpath=//button[text()=' Add ']";
	public static final String FIRST_NAME_TEXTBOX = "xpath=//input[contains(@class,'orangehrm-firstname')]";
	public static final String MIDDLE_NAME_TEXTBOX = "xpath=//input[contains(@class,'orangehrm-middlename')]";
	public static final String LAST_NAME_TEXTBOX = "xpath=//input[contains(@class,'orangehrm-lastname')]";
	public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
	public static final String CREATE_LOGIN_DETAIL_SWITCH_BUTTON = "xpath=//span[contains(@class,'oxd-switch-input')]";
	public static final String USERNAME_TEXTBOX = "xpath=//label[text()='Username']/parent::div/following-sibling::div/input";
	public static final String PASSWORD_TEXTBOX = "xpath=//label[text()='Password']/parent::div/following-sibling::div/input";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "xpath=//label[text()='Confirm Password']/parent::div/following-sibling::div/input";
	public static final String ENABLED_RADIO_BUTTON = "xpath=//label[text()='Enabled']";
	public static final String DISABLED_RADIO_BUTTON = "xpath=//label[text()='Disabled']";
	public static final String SAVE_BUTTON = "xpath=//button[text()=' Save ']";
	public static final String CANCEL_BUTTON = "xpath=//button[text()=' Cancel ']";
	public static final String SUCCESS_MESSAGE = "xpath=//div[contains(@class,'oxd-toast-content--success')]/p[text()='Successfully Saved']";
	public static final String DYNAMIC_TEXTBOX_ON_SEARCH_PAGE_BY_NAME = "xpath=//label[text()='%s']/parent::div/following-sibling::div//input";
	public static final String SEARCH_BUTTON = "xpath=//button[text()=' Search ']";
	public static final String DYNAMIC_ARROW_DROPDOWN_ON_SEARCH_PAGE_BY_NAME = "xpath=//label[text()='%s']/parent::div/following-sibling::div//i";
	public static final String DYNAMIC_OPTIONS_IN_DROPDOWN_LIST_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
	public static final String DYNAMIC_COLUMN_INDEX_BY_NAME = "xpath=//div[contains(@class,'oxd-table-header-cell') and text()='%s']/preceding-sibling::div";
	public static final String DYNAMIC_TEXBOX_BY_COLUMN_AND_ROW_INDEX = "xpath=//div[@class='oxd-table-body']/div[%s]//div[%s]";
	public static final String AUTO_COMPLETE_TEXT_INPUT = "xpath=//div[contains(@class,'oxd-autocomplete-dropdown')]//span";
}
