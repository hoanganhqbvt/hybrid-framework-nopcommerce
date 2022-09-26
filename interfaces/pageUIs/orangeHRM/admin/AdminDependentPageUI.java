package pageUIs.orangeHRM.admin;

public class AdminDependentPageUI {
	public static final String ADD_ASSIGNED_DEPENDENT_BUTTON = "xpath=//h6[text()='Assigned Dependents']/parent::div/button[text()=' Add ']";
	public static final String DEPENDENT_NAME_TEXTBOX = "xpath=//label[text()='Name']/parent::div/following-sibling::div/input";
	public static final String RELATIONSHIP_ARROW_DROPDOWN_LIST = "xpath=//label[text()='Relationship']/parent::div/following-sibling::div//i";
	public static final String RELATIONSHIP_OPTIONS_IN_DROPDOWN_LIST = "xpath=//div[contains(@class,'oxd-select-option')]/span";
	public static final String DEPENDENT_DOB_TEXTBOX = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
	public static final String SUCCESS_ADDED_DEPENDENT_MESSAGE = "xpath=//p[text()='Successfully Saved']";
}
