package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.ProductDetailPageUI;

public class ProductDetailPageObject extends BasePage{
	WebDriver driver;

	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToOverviewButtonByProductNameAndButtonLabel(String productName, String buttonLabel) {
		waitForElementClickable(driver, ProductDetailPageUI.DYNAMIC_OVERVIEW_BUTTON_BY_NAME, productName, buttonLabel);
		clickToElement(driver, ProductDetailPageUI.DYNAMIC_OVERVIEW_BUTTON_BY_NAME, productName, buttonLabel);
	}

	public String getResultMessageAfterClickOnOverviewButtons() {
		waitForElementVisible(driver, ProductDetailPageUI.SUCCESS_ADD_TO_WISHLIST_MESSAGE);
		return getElementText(driver, ProductDetailPageUI.SUCCESS_ADD_TO_WISHLIST_MESSAGE);		
	}
}
