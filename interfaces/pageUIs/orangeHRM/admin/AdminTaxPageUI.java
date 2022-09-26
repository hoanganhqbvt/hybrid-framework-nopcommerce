package pageUIs.orangeHRM.admin;

public class AdminTaxPageUI {
	public static final String EXEMPTION_TEXTBOX_FERDERAL_INCOME_TAX = "xpath=//h6[text()='Federal Income Tax']/parent::form/div[1]//label[text()='Exemptions']/parent::div/following-sibling::div/input";
	public static final String EXEMPTION_TEXTBOX_STATE_INCOME_TAX = "xpath=//h6[text()=' State Income Tax ']/parent::form/div[2]//label[text()='Exemptions']/parent::div/following-sibling::div/input";
	public static final String DYNAMIC_NARROW_IN_DROPDOWN_IN_STATE_INCOME_TAX = "xpath=//h6[text()=' State Income Tax ']/parent::form/div[2]//label[text()='%s']/parent::div/following-sibling::div//i";
	public static final String NARROW_IN_DROPDOWN_IN_FERDERAL_INCOME_TAX = "xpath=//h6[text()='Federal Income Tax']/parent::form/div[1]//label[text()='Status']/parent::div/following-sibling::div//i";
	public static final String OPTIONS_IN_STATUS_DROPDOWN_IN_FERDERAL_INCOME_TAX = "xpath=//h6[text()='Federal Income Tax']/parent::form/div[1]//label[text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-option']";
	public static final String DYNAMIC_OPTIONS_IN_DROPDOWN_IN_STATE_INCOME_TAX = "xpath=//h6[text()=' State Income Tax ']/parent::form/div[2]//label[text()='%s']/parent::div/following-sibling::div//div[@class='oxd-select-option']";
	public static final String SUCCESS_ADDED_TAX_MESSAGE = "xpath=//p[text()='Successfully Updated']";
	
}