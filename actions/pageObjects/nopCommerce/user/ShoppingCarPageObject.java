package pageObjects.nopCommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
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
	public ProductDetailPageObject clickToEditLink() {
		waitForElementVisible(driver, ShoppingCartPageUI.EDIT_LINK_ON_SHOPPING_CART_PAGE);
		clickToElement(driver, ShoppingCartPageUI.EDIT_LINK_ON_SHOPPING_CART_PAGE);
		return PageGeneratorManager.getProductDetailPage(driver);
	}
	public void clickToRemoveIconOnAProductOnShoppingCartPage(String productName) {
		waitForElementVisible(driver, ShoppingCartPageUI.REMOVE_ICON_BY_PRODUCT_NAME_ON_SHOPPING_CART, productName);
		clickToElement(driver, ShoppingCartPageUI.REMOVE_ICON_BY_PRODUCT_NAME_ON_SHOPPING_CART, productName);
	}
	public String getNoDataMessageOnShoppingCartPage() {
		waitForElementVisible(driver, ShoppingCartPageUI.NO_DATA_MESSAGE_ON_SHOPPING_CART);
		return getElementText(driver, ShoppingCartPageUI.NO_DATA_MESSAGE_ON_SHOPPING_CART);
	}
	
	public String getProductAttributeOnShoppingCartByName(String updateProduct, String attribute) {
		waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_VALUE_ON_SHOPPING_CART, updateProduct, attribute);
		return getElementText(driver, ShoppingCartPageUI.PRODUCT_VALUE_ON_SHOPPING_CART, updateProduct, attribute);
	}
	public void inputValueToQtyTextboxForAProductOnShoppingPage(String updateProduct, String updateQty) {
		waitForElementVisible(driver, ShoppingCartPageUI.DYNAMIC_QTY_TEXTBOX_ON_SHOPPING_CART_PAGE, updateProduct);
		sendkeyToElement(driver,ShoppingCartPageUI.DYNAMIC_QTY_TEXTBOX_ON_SHOPPING_CART_PAGE, updateQty, updateProduct);
	}

	public void clickToButtonsOnShoppingCartByName(String buttonName) {
		waitForElementVisible(driver, ShoppingCartPageUI.DYNAMIC_BUTTON_BY_NAME_ON_SHOPPING_CART_PAGE, buttonName);
		clickToElement(driver, ShoppingCartPageUI.DYNAMIC_BUTTON_BY_NAME_ON_SHOPPING_CART_PAGE, buttonName);
	}
	public boolean isTotalPriceUpdatedCorrectlyCorrespondingToQtyNumber(String updateQty, String updateProductPrice, String updateProductToTalPrice) {
		boolean isCorrectTotalPrice = false;
		
		int totalPrice = Integer.valueOf(updateProductToTalPrice.replace("$", "").replace(",", "").replace(".00", ""));
		int productPrice = Integer.valueOf(updateProductPrice.replace("$", "").replace(".00", ""));
		int qtyNumber = Integer.valueOf(updateQty);
		System.out.println(qtyNumber*productPrice);
		System.out.println(totalPrice);
		if(qtyNumber*productPrice == totalPrice) {
			isCorrectTotalPrice = true;
		} else { isCorrectTotalPrice = false;
		
	}return isCorrectTotalPrice;
}
	public void selectGiftWrappingOptionInDropdownList(String giftWrappingOption) {
		waitForAllElementVisible(driver, ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN);
		selectItemInDefaultDropdown(driver, ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN, giftWrappingOption);
	}
	public void checkAgreementTermsOfServiceCheckbox() {
		waitForElementVisible(driver, ShoppingCartPageUI.AGREEMENT_TERMS_OF_SERVICE_CHECKBOX);
		clickToElement(driver, ShoppingCartPageUI.AGREEMENT_TERMS_OF_SERVICE_CHECKBOX);
		
	}
	public CheckoutPageObject clickToCheckoutButton() {
		waitForElementVisible(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
		return PageGeneratorManager.getCheckoutPage(driver);
	}	

}