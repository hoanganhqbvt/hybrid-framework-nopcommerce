package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.nopCommer.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isDashboardHeaderDisplay() {
		waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplay(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}
	public void clickToMenuLinkByClass(String menuClass) {
		waitForElementVisible(driver, AdminDashboardPageUI.DYNAMIC_MENU_LINK_BY_CLASS, menuClass);
		clickToElement(driver, AdminDashboardPageUI.DYNAMIC_MENU_LINK_BY_CLASS, menuClass);		
	}
	public void clickToSubPageByName(String pageName) {
		waitForElementVisible(driver, AdminDashboardPageUI.DYNAMIC_SUB_PAGE_BY_NAME, pageName);
		clickToElement(driver, AdminDashboardPageUI.DYNAMIC_SUB_PAGE_BY_NAME, pageName);
	}
	
	
}
