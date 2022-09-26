package pageUIs.orangeHRM.admin;

public class QualificationPageUI {
	public static final String DYNAMIC_ADD_BUTTON_BY_LABEL = "xpath=//h6[text()='%s']/parent::div//button[text()=' Add ']";
	public static final String DYNAMIC_TEXTBOX_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div//input";
	public static final String SAVE_BUTTON_AT_EMPLOYEE_PAGE = "xpath=//button[text()=' Save ']";
	public static final String SUCCESS_ADDED_QUALIFICATIONS_MESSAGE = "xpath=//p[text()='Successfully Saved']";
	public static final String COLUMN_INDEX_BY_NAME_AND_LABEL_OF_SECTION = "xpath=//h6[text()='%s']/parent::div/parent::div/following-sibling::div//div[contains(@class,'oxd-table-header-cell') and text()='%s']/preceding-sibling::div";
	public static final String TEXTBOX_BY_COLUMN_ROW_INDEX_AND_LABEL_SECTION = "xpath=//h6[text()='%s']/parent::div/parent::div/following-sibling::div//div[@class='oxd-table-body']/div[%s]//div[@role='cell'][%s]/div";

}
