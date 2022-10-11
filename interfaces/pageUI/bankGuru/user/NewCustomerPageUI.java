package pageUI.bankGuru.user;

public class NewCustomerPageUI {
	public static final String DYNAMIC_TEXTBOX_BY_NAME = "xpath=//td[text()='%s']/parent::tr//input";
	public static final String DYNAMIC_ERROR_MESSAGE_DISPLAYED_NEXT_TO_BLANK_TEXTBOX = "xpath=//td[text()='%s']/parent::tr//label";
	public static final String ADDRESS_TEXTBOX = "xpath=//td[text()='Address']/parent::tr//textarea";
	public static final String SUBMIT_BUTTON = "xpath=//input[@value='Submit']";
	public static final String SUCCESS_CREATED_NEW_CUSTOMER_MESSAGE = "xpath=//p[text()='Customer Registered Successfully!!!']";
	public static final String FIELD_VALUE_BY_FIELD_NAME = "xpath=//td[text()='%s']/following-sibling::td";
	public static final String DOB_TEXTBOX = "xpath=//input[@id='dob']";
	public static final String DYNAMIC_VALUE_OF_CREATED_CUSTOMER_BY_FIELD_NAME = "xpath=//td[text()='%s']/following-sibling::td";
}
