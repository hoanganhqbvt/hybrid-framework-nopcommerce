package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;

	public class HomePageObject extends BasePage{
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToAccountIcon( ){
		waitForElementClickable(driver, HomePageUI.ACCOUNT_ICON);	
		clickToElement(driver, HomePageUI.ACCOUNT_ICON);
		
	}
	public RegisterPageObject clickToRegisterLink( ){
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);	
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	
	public LoginPageObject clickToLoginLink( ){
	waitForElementClickable(driver, HomePageUI.LOGIN_LINK);	
	clickToElement(driver, HomePageUI.LOGIN_LINK);
	return PageGeneratorManager.getLoginPage(driver);
	}
	
}
