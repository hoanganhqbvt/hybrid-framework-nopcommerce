package pageUIs.orangeHRM.admin;

public class AdminSalaryPageUI {
	public static final String ADD_SALARY_BUTTON = "xpath=//h6[text()='Assigned Salary Components']/parent::div/button[text()=' Add ']";
	public static final String DYNAMIC_TEXTBOX_ON_SALARY_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div/input";
	public static final String DYNAMIC_ARROW_DROPDOWN_LIST_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div//i";
	public static final String DYNAMIC_SALARY_OPTION_IN_DROPDOWN_LIST_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
	public static final String SUCCESS_ADDED_SALARY_MESSAGE = "xpath=//p[text()='Successfully Saved']";
}
