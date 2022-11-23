package pageUIs.nopCommerce.user;

public class ProductDetailPageUI {
	public static final String DYNAMIC_OVERVIEW_BUTTON_BY_NAME = "xpath=//h1[text()='%s']/parent::div/following-sibling::div//button[text()='%s']";
	public static final String DYNAMIC_OVERVIEW_BUTTON_BY_NAME_ON_PRODUCT_PAGE = "xpath=//a[text()='%s']/parent::h2/following-sibling::div//button[text()='%s']";
	public static final String SUCCESS_ADD_TO_WISHLIST_CART_COMPARE_MESSAGE = "css=div#bar-notification p";
	public static final String CLOSE_SUCCESS_MESSAGE = "css=div.bar-notification span.close";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[text()='Add to cart']";
	public static final String HDD_OPTION_TO_BUILD_COMPUTER = "xpath=//dd[@id='product_attribute_input_3']//label[text()='%s']";
	public static final String RAM_OPTION_IN_DROPDOWN_LIST = "css=select#product_attribute_2";
	public static final String SHOPPING_CARD_ON_TOP_MENU = "css=li#topcartlink a";
	public static final String PROCESSOR_DROPDOWN_LIST = "css=select#product_attribute_1";
	public static final String RAM_DROPDOWN_LIST = "css=select#product_attribute_2";
	public static final String OS_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String SOFTWARE_CHECKBOX_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String PRICE_VALUE = "css=div.product-price span";
	public static final String TOTAL_PRICE = "css=div.totals strong";
	public static final String NUMBER_DISPLAYED_ON_SHOPPING_CART = "css=li#topcartlink span.cart-qty";
	public static final String TEXT_SHOW_NUMBER_WHEN_HOVER_OVER_SHOPPING_CARD = "css=div.count a";
	public static final String TEXT_SHOW_NUMBER_ITEMS_WHEN_HOVER_OVER_SHOPPING_CARD = "css=div.count";
	public static final String BUILDER_COMPUTER_ATTRIBUTE_ON_SHOPPING_CART = "css=div.mini-shopping-cart div.attributes";
	public static final String BUILDER_COMPUTER_PRICE_ON_SHOPPING_CART = "css=div.mini-shopping-cart div.price span";
	public static final String BUILDER_COMPUTER_SUBTOTAL_PRICE_ON_SHOPPING_CART = "div.mini-shopping-cart div.totals strong";
	public static final String ORDER_NUMBER_TEXTBOX = "css=input#product_enteredQuantity_1";
	public static final String UPDATE_BUTTON = "xpath=//button[text()='Update']";
	
}
