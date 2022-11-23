package pageUIs.nopCommerce.user;

public class CheckoutPageUI {
	public static final String SHIP_TO_THE_SAME_ADDRESS_CHECKBBOX = "css=input#ShipToSameAddress";
	public static final String DYNAMIC_DROPDOWN_LIST_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::select";
	public static final String DYNAMIC_TEXTBOX_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::input";
	public static final String CONTINUE_BUTTON_BY_CLASS = "xpath=//button[contains(@class,'%s')]";
	public static final String DYNAMIC_SHIPPING_METHOD_BY_ID = "xpath=//div[@id='shipping-methods-form']//input[@id='%s']";
	public static final String DYNAMIC_PAYMENT_METHOD_BY_ID = "xpath=//ul[@id='payment-method-block']//input[@id='%s']";
	public static final String PAYMENT_INFORMATION_TEXT = "xpath=//form[@id='co-payment-info-form']//td";
	public static final String BILLING_INFO_BY_CLASS = "xpath=//div[@class='billing-info']//li[@class='%s']";
	public static final String SHIPPING_INFO_BY_CLASS = "xpath=//div[@class='shipping-info']//li[@class='%s']";
	public static final String PAYMENT_METHOD_IN_CONFIRM_SECTION = "css=li.payment-method>span.value";
	public static final String SHIPPING_METHOD_IN_CONFIRM_SECTION = "css=li.shipping-method>span.value";
	public static final String STATE_CITY_ZIP_BILLING_ADDRESS_IN_CONFIRM_SECTION = "css=div.billing-info li.city-state-zip";
	public static final String STATE_CITY_ZIP_SHIPPING_ADDRESS_IN_CONFIRM_SECTION = "css=div.shipping-info li.city-state-zip";
	public static final String PRODUCT_ATTRIBUTES_ON_CHECKOUT_BY_CLASS = "xpath=//table[@class='cart']//td[@class='%s']/span";
	public static final String PRODUCT_NAME_ON_CHECKOUT_BY_CLASS = "xpath=//table[@class='cart']//td[@class='product']/a";
	public static final String SUMMARY_PRICE_INFO_ON_CHECKOUT_BY_CLASS = "xpath=//table[@class='cart-total']//tr[@class='%s']//span[@class='%s']";
	public static final String GIFT_WRAPPING_DISPLAYED_ON_CHECKOUT_PAGE = "css=div.selected-checkout-attributes";
	public static final String CONFIRM_BUTTON = "xpath=//button[text()='Confirm']";
	public static final String ORDER_SUCCESS_MESSAGE = "xpath=//div[@class='section order-completed']/div[@class='title']/strong";
	public static final String ORDER_NUMBER = "xpath=//div[@class='order-number']/strong";
	
}
