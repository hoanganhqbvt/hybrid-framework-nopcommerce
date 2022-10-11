package pageUIs.nopCommerce.user;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "id=Email";
	public static final String PASSWORD_TEXTBOX = "id=Password";
	public static final String LOGIN_BUTTON = "class=login-button";
	public static final String EMAIL_ERROR_MESSAGE = "css=span[id='Email-error']";
	public static final String UNSUCCESSFULL_ERROR_MESSAGE = "xpath=//div[contains(@class,'message-error')]";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_ERROR_BY_ID = "xpath=//input[@id='%s']/parent::div/span/span";
	
	
}
