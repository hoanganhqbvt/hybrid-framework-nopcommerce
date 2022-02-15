package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage{
	private WebDriver driver;
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getRegisterSuccessMessage( ) {
		waitForElementVisible(driver, MyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	public String getContactInformation( ) {
	waitForElementVisible(driver, MyDashboardPageUI.CONTACT_INFORMATION_TEXT);
	return getElementText(driver, MyDashboardPageUI.CONTACT_INFORMATION_TEXT);
}
	public void clickToAccountIcon() {
		waitForElementClickable(driver, MyDashboardPageUI.ACCOUNT_ICON);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_ICON);
		
	}
	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	public String getLoginSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.LOGIN_SUCCESS_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.LOGIN_SUCCESS_MESSAGE);
	}
}
