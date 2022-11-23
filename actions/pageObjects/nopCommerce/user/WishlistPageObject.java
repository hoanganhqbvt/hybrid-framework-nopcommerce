package pageObjects.nopCommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.WishlistPageUI;

public class WishlistPageObject extends BasePage{
	WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductDisplayedCorrectlyOnWishListPage(String productName) {
		boolean isProductDisplayed = false;
		waitForAllElementVisible(driver, WishlistPageUI.PRODUCT_NAME_ON_WISHLIST_PAGE);
		List<WebElement> productNameOnWishlist = getListWebElement(driver, WishlistPageUI.PRODUCT_NAME_ON_WISHLIST_PAGE);
		for(WebElement aProductName : productNameOnWishlist) {
			if(aProductName.getText().equals(productName)) {
				
			 isProductDisplayed = true;
		}		
	} 
return isProductDisplayed;
	
}

	public void clickToWishlistSharingLink() {
		waitForElementVisible(driver, WishlistPageUI.WISHLIST_SHARE_LINK);
		clickToElement(driver, WishlistPageUI.WISHLIST_SHARE_LINK);
	}

	public boolean isWishlistSharePageTitleContainsUsername(String userName) {
		boolean isContainsUsername = false;
		waitForElementVisible(driver, WishlistPageUI.PAGE_TITLE_OF_WISHLIST_SHARE_LINK);
		if(getElementText(driver, WishlistPageUI.PAGE_TITLE_OF_WISHLIST_SHARE_LINK).contains(userName)) {
			isContainsUsername = true;
		}				
	
		return isContainsUsername;
}

	public void selectAddToCartCheckboxByProductName(String productName) {
		waitForElementVisible(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX_BY_PRODUCT_NAME, productName);
		if(!isElementSelected(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX_BY_PRODUCT_NAME, productName)) {
			clickToElement(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX_BY_PRODUCT_NAME, productName);
		}
		
	}

	public ShoppingCarPageObject clickToAddToCartButton() {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getShoppingCartPage(driver);
	}

	public void clickToHomePageIcon() {
		waitForElementVisible(driver, WishlistPageUI.HOME_PAGE_ICON);
		clickToElement(driver, WishlistPageUI.HOME_PAGE_ICON);
	}

	public boolean isProductRemovedFromWishlist(String productName) {
		boolean isProductRemoved = false;
		if(isElementUndisplayed(driver, WishlistPageUI.PRODUCT_NAME_ON_WISHLIST_PAGE)) {
			waitForElementVisible(driver, WishlistPageUI.WISHLIST_EMPTY_MESSAGE);
			if(getElementText(driver, WishlistPageUI.WISHLIST_EMPTY_MESSAGE).equals("\n"
					+ "The wishlist is empty!")) {
			isProductRemoved = true;}
		} else {
		List<WebElement> productNameOnWishlist = getListWebElement(driver, WishlistPageUI.PRODUCT_NAME_ON_WISHLIST_PAGE);
		for(WebElement aProductName : productNameOnWishlist) {
			if(!aProductName.getText().equals(productName)){
				
				isProductRemoved = true;
		}		
	} 			
		}return isProductRemoved;
}

	public void clickToAddToWishlistButtonByProductName(String productName) {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_WISHLIST_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, WishlistPageUI.ADD_TO_WISHLIST_BUTTON_BY_PRODUCT_NAME, productName);
	}

	public void removeProductFromWishlist(String productName) {
		waitForElementClickable(driver, WishlistPageUI.REMOVE_ICON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, WishlistPageUI.REMOVE_ICON_BY_PRODUCT_NAME, productName);		
	}

	public String getResultMessageAfterClickOnOverviewButtons() {
		waitForElementVisible(driver, WishlistPageUI.SUCCESS_ADD_TO_WISHLIST_COMPARE_MESSAGE);
		return getElementText(driver, WishlistPageUI.SUCCESS_ADD_TO_WISHLIST_COMPARE_MESSAGE);		
	}

	public void clickToAddToCompareButtonByProductName(String productName) {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_COMPARE_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, WishlistPageUI.ADD_TO_COMPARE_BUTTON_BY_PRODUCT_NAME, productName);		
	}
	
	
	
}