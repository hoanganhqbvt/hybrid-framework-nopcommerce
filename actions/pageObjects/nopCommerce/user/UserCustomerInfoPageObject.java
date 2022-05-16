package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;


import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {		
	private WebDriver driver;
	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isCustomerInfoPageDisplay() {
		waitForElementVisible(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplay(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
	}
	
}
