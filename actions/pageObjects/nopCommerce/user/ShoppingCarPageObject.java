package pageObjects.nopCommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.ShoppingCartPageUI;
import pageUIs.nopCommerce.user.WishlistPageUI;

public class ShoppingCarPageObject extends BasePage{
	WebDriver driver;
	public ShoppingCarPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isProductAddedToCartPage(String productName) {
		boolean isProductDisplayed = false;
		waitForAllElementVisible(driver, ShoppingCartPageUI.PRODUCT_NAME_ON_WISHLIST_PAGE);
		List<WebElement> productNameOnWishlist = getListWebElement(driver, ShoppingCartPageUI.PRODUCT_NAME_ON_WISHLIST_PAGE);
		for(WebElement aProductName : productNameOnWishlist) {
			if(aProductName.getText().equals(productName)) {
				
			 isProductDisplayed = true;
		}		
	} 
		return isProductDisplayed;
	
}
	}

