package pageUIs.nopCommerce.user;

public class UserOrderPageUI {
	public static final String ORDER_NUMBER_ON_ORDER_PAGE = "xpath=//div[@class='order-list']//strong";
	public static final String ORDER_NUMBER_ON_ORDER_DETAIL_PAGE = "xpath=//div[@class='order-number']/strong";
	public static final String DETAIL_BUTTON = "css=div.buttons>button";
	public static final String BILLING_INFO_BY_CLASS = "xpath=//div[@class='billing-info']//li[@class='%s']";
	public static final String SHIPPING_INFO_BY_CLASS = "xpath=//div[@class='shipping-info']//li[@class='%s']";
	public static final String PAYMENT_METHOD_ON_ORDER_PAGE = "css=li.payment-method>span.value";
	public static final String SHIPPING_METHOD_ON_ORDER_PAGE = "css=li.shipping-method>span.value";
	public static final String STATE_CITY_ZIP_BILLING_ADDRESS_ON_ORDER_PAGE = "css=div.billing-info li.city-state-zip";
	public static final String STATE_CITY_ZIP_SHIPPING_ADDRESS_ON_ORDER_PAGE = "css=div.shipping-info li.city-state-zip";
	public static final String PRODUCT_ATTRIBUTES_ON_ORDER_PAGE_BY_CLASS = "xpath=//table[@class='data-table']//td[@class='%s']/span";
	public static final String PRODUCT_NAME_ON_ORDER_PAGE = "xpath=//table[@class='data-table']//td[@class='product']//a";
	public static final String SUMMARY_PRICE_INFO_ON_ORDER_PAGE_BY_LABEL = "xpath=//label[text()='%s']/parent::td/following-sibling::td/span";
	public static final String GIFT_WRAPPING_DISPLAYED_ON_ORDER_PAGE = "css=div.selected-checkout-attributes";
}
