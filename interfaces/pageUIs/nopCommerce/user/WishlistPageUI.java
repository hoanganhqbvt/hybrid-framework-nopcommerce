package pageUIs.nopCommerce.user;

public class WishlistPageUI {
	public static final String PRODUCT_NAME_ON_WISHLIST_PAGE = "xpath=//table[@class='cart']/tbody/tr//td[@class='product']/a";
	public static final String WISHLIST_SHARE_LINK = "css=a.share-link";
	public static final String PAGE_TITLE_OF_WISHLIST_SHARE_LINK = "css=div.page-title h1";
	public static final String ADD_TO_CART_CHECKBOX_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::td/preceding-sibling::td//input[@name='addtocart']";
	public static final String REMOVE_ICON_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::td/following-sibling::td//button[@class='remove-btn']";
	public static final String ADD_TO_COMPARE_BUTTON_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div//button[text()='Add to compare list']";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[text()='Add to cart']";
	public static final String HOME_PAGE_ICON = "css=div.header-logo a";
	public static final String ADD_TO_WISHLIST_BUTTON_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div//button[text()='Add to wishlist']";
	public static final String WISHLIST_EMPTY_MESSAGE = "css=div.no-data";
	public static final String SUCCESS_ADD_TO_WISHLIST_COMPARE_MESSAGE = "css=div#bar-notification p";
	
}
