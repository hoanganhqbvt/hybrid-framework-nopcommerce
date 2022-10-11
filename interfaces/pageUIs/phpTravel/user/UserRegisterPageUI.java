package pageUIs.phpTravel.user;

public class UserRegisterPageUI {
	public static final String DYNAMIC_TEXTBOX_BY_LABEL = "xpath=//label[text()='%s']/parent::div//input";
	public static final String CAPTCHA_CHECKBOX = "css=div.recaptcha-checkbox-border";
	public static final String SIGNUP_BUTTON = "css=button#button";
	public static final String REQUIRED_EEROR_MESSAGE = "xpath=//p[text()='Please enter all credentials to signup']";
	public static final String COOKIE_GOT_IT_BUTTON = "css=button#cookie_stop";
	public static final String CAPTCHA_IFRAME = "xpath=//iframe[@title='reCAPTCHA']";
}
