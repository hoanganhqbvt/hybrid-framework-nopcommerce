package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.admin.AdminDashboardPageUI;
import pageUIs.nopCommer.admin.AdminLoginPageUI;

public class AdminDashboardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isDashboardHeaderDisplay() {
		waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplay(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}
}
