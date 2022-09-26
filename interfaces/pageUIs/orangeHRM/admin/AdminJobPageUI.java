package pageUIs.orangeHRM.admin;

public class AdminJobPageUI {
	public static final String JOINED_DATE_TEXTBOX = "xpath=//label[text()='Joined Date']/parent::div/following-sibling::div//input";
	public static final String DYNAMIC_ARROW_DROPDOWN_LIST_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div//i";
	public static final String DYNAMIC_JOB_OPTION_IN_DROPDOWN_LIST_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
	public static final String SUCCESS_ADDED_JOB_MESSAGE = "xpath=//p[text()='Successfully Updated']";
	public static final String CLOSE_CALENDER_POPUP = "xpath=//div[@class='oxd-date-input-link --close']";
}
