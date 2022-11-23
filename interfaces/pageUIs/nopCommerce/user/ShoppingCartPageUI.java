package pageUIs.nopCommerce.user;

public class ShoppingCartPageUI {
	public static final String PRODUCT_NAME_ON_WISHLIST_PAGE = "xpath=//table[@class='cart']/tbody/tr//td[@class='product']/a";
	public static final String EDIT_LINK_ON_SHOPPING_CART_PAGE = "css=div.edit-item a";
	public static final String REMOVE_ICON_BY_PRODUCT_NAME_ON_SHOPPING_CART = "xpath=//a[text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']/button";
	public static final String NO_DATA_MESSAGE_ON_SHOPPING_CART = "css=div.no-data";
	public static final String PRODUCT_VALUE_ON_SHOPPING_CART = "xpath=//tbody//a[text()='%s']/parent::td/following-sibling::td/label[text()='%s']/following-sibling::span";
	public static final String DYNAMIC_QTY_TEXTBOX_ON_SHOPPING_CART_PAGE = "xpath=//tbody//a[text()='%s']/parent::td/following-sibling::td[@class='quantity']/input";
	public static final String DYNAMIC_BUTTON_BY_NAME_ON_SHOPPING_CART_PAGE = "xpath=//button[text()='%s']";
	public static final String GIFT_WRAPPING_DROPDOWN = "css=select#checkout_attribute_1";
	public static final String AGREEMENT_TERMS_OF_SERVICE_CHECKBOX = "css=input#termsofservice";
	public static final String CHECKOUT_BUTTON = "css=button#checkout";
	
}
