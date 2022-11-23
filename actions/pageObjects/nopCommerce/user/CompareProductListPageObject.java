package pageObjects.nopCommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.CompareProductListPageUI;

public class CompareProductListPageObject extends BasePage{
	WebDriver driver;

	public CompareProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductNameDisplayedCorrectlyOnCompareProductPage(String productName) {
		boolean isProductNameCorrect = false;
		waitForElementVisible(driver, CompareProductListPageUI.PRODUCT_NAME_LIST_ON_COMPARE_PAGE);
		List<WebElement> productNameList = getListWebElement(driver, CompareProductListPageUI.PRODUCT_NAME_LIST_ON_COMPARE_PAGE);
		
		for(WebElement name : productNameList) {
			if(name.getText().equals(productNameList)) {
				isProductNameCorrect = true;
			}
		}
	return isProductNameCorrect;
}

	public void clickToClearListButton() {
		waitForElementClickable(driver, CompareProductListPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, CompareProductListPageUI.CLEAR_LIST_BUTTON);
	}

	public String getNoDataMessageOnCompareListPage() {
		waitForElementVisible(driver, CompareProductListPageUI.NO_DATA_MESSAGE_ON_COMPARE_LIST);
		return getElementText(driver, CompareProductListPageUI.NO_DATA_MESSAGE_ON_COMPARE_LIST);
	}

	public boolean isProductPriceDisplayedCorrectlyOnCompareProductPage(String productPrice) {
		boolean isProductPriceCorrect = false;
		waitForElementVisible(driver, CompareProductListPageUI.PRODUCT_PRICE_LIST_ON_COMPARE_PAGE);
		List<WebElement> productPriceList = getListWebElement(driver, CompareProductListPageUI.PRODUCT_PRICE_LIST_ON_COMPARE_PAGE);
		
		for(WebElement price : productPriceList) {
			if(price.getText().equals(productPrice)) {
				isProductPriceCorrect = true;
			}
		}
	return isProductPriceCorrect;
}
	
}
