package pageUI.bankGuru.user;

public class NewAccountPageUI {
	public static final String DYNAMIC_TEXTBOX_ON_NEW_ACCOUNT_PAGE_BY_NAME = "xpath=//td[contains(text(),'%s')]/following-sibling::td/input";
	public static final String SUBMIT_BUTTON = "xpath=//input[@value='submit']";
	public static final String ACCOUNT_TYPE = "xpath=//td[text()=' Account type']/following-sibling::td/select";
	public static final String SUCCESS_CREATED_NEW_ACCOUNT_MESSAGE = "xpath=//p[text()='Account Generated Successfully!!!']";
	public static final String DETAIL_ACCOUNT_INFO_BY_FIELD_NAME = "xpath=//td[text()='%s']/following-sibling::td";
	
}
