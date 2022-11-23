package pageUIs.nopCommer.admin;

public class AdminCustomerPageUI {
	public static final String ADD_NEW_BUTTON = "css=a.btn-primary";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String ADMIN_COMMENT_TEXT_AREA = "css=textarea#AdminComment";
	public static final String CUSTOMER_ROLE_DROPDOWN = "xpath=//label[text()='Customer roles']/ancestor::div[@class='col-md-3']/following-sibling::div//div[@class='k-multiselect-wrap k-floatwrap']/input";
	public static final String CUSTOMER_ROLE_OPTION_IN_DROPDOWN = "xpath=//ul[@id='SelectedCustomerRoleIds_listbox']/li";
	public static final String NEW_LETTER_DROPDOWN = "xpath=//label[text()='Newsletter']/ancestor::div[@class='col-md-3']/following-sibling::div//div[@class='k-multiselect-wrap k-floatwrap']/input";
	public static final String NEW_LETTER_DROPDOWN_OPTION = "css=select#SelectedNewsletterSubscriptionStoreIds";
	public static final String NEW_LETTER_OPTION_IN_DROPDOWN = "css=ul#SelectedNewsletterSubscriptionStoreIds_listbox>li";
	public static final String SAVE_BUTTON = "xpath=//button[@name='save']";
	public static final String DYNAMIC_GENDER_BY_ID = "xpath=//input[@id='%s']";
	public static final String VENDOR_DROPDOWN = "css=select#VendorId";
	public static final String SUCCESS_ADDED_CUSTOMER_MESSAGE = "css=div.alert-success";
	public static final String CLOSE_ICON_ON_POPUP_RESULT_MESSAGE = "css=div.alert-success>button.close";
	
	
}
