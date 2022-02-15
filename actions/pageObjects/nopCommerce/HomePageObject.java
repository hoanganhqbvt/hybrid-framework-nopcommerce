package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {		
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		// CÁCH 2
		// return new RegisterPageObject(driver);
		// CÁCH 3
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		// cách 2: return new LoginPageObject(driver);
		// Cách 3
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);		
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
		
	}
	
		public void clickToMyAccountLink() {
			waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
			clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		}
}
