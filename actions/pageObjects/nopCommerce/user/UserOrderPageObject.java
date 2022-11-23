package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserOrderPageUI;

public class UserOrderPageObject extends BasePage{
	WebDriver driver;
	public UserOrderPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getOrderNumberDisplayedOnOrderPage() {
		waitForAllElementVisible(driver, UserOrderPageUI.ORDER_NUMBER_ON_ORDER_PAGE);
		return getElementText(driver, UserOrderPageUI.ORDER_NUMBER_ON_ORDER_PAGE).substring(14);
	}
	public String getOrderNumberDisplayedOnOrderDetailPage() {
		waitForAllElementVisible(driver, UserOrderPageUI.ORDER_NUMBER_ON_ORDER_DETAIL_PAGE);
		return getElementText(driver, UserOrderPageUI.ORDER_NUMBER_ON_ORDER_DETAIL_PAGE).substring(7);
	}
	
	public String getBillingAddressInfoOnOrderDetailPageByClass(String billingAddressClass) {
		waitForAllElementVisible(driver, UserOrderPageUI.BILLING_INFO_BY_CLASS, billingAddressClass);
		return getElementText(driver, UserOrderPageUI.BILLING_INFO_BY_CLASS, billingAddressClass);
	}
	public String getShippingAddressInfoOnOrderDetailPageByClass(String shippingAddressClass) {
		waitForAllElementVisible(driver, UserOrderPageUI.SHIPPING_INFO_BY_CLASS, shippingAddressClass);
		return getElementText(driver, UserOrderPageUI.SHIPPING_INFO_BY_CLASS, shippingAddressClass);
	}
	public String getPaymentMethodInfoOnOrderDetailPage() {
		waitForElementVisible(driver, UserOrderPageUI.PAYMENT_METHOD_ON_ORDER_PAGE);
		return getElementText(driver, UserOrderPageUI.PAYMENT_METHOD_ON_ORDER_PAGE);
	}
	public String getShippingMethodInfoOnOrderDetailPage() {
		waitForElementVisible(driver, UserOrderPageUI.SHIPPING_METHOD_ON_ORDER_PAGE);
		return getElementText(driver, UserOrderPageUI.SHIPPING_METHOD_ON_ORDER_PAGE);
	}
	public boolean isBillingStateProvinceCityZipPostalCodeDisplayedCorrectlyOnOrderDetailPage(String city, String stateProvince, 
			String zipPostal) {
		boolean isCorrectStateCityZip = false;
		waitForElementVisible(driver, UserOrderPageUI.STATE_CITY_ZIP_BILLING_ADDRESS_ON_ORDER_PAGE);
		String stateCityZip = getElementText(driver, UserOrderPageUI.STATE_CITY_ZIP_BILLING_ADDRESS_ON_ORDER_PAGE).trim();
		String[] addressPart = stateCityZip.split(",");
		
		String displayedState = addressPart[1];
		String displayedCity= addressPart[0];
		String displayedZip = addressPart[2];
		System.out.println("Displayed state is:" + displayedState);
		System.out.println("Displayed city is:" + displayedCity);
		System.out.println("Displayed zip is:" + displayedZip);
		if(displayedState.equals(stateProvince) && displayedCity.equals(city) && displayedZip.equals(zipPostal)){
			isCorrectStateCityZip = true;
		} else {
			isCorrectStateCityZip = false;
	}return isCorrectStateCityZip;
}
	public String getProductAttributesOnOrderDetailPage(String attributeClass) {
		waitForElementVisible(driver, UserOrderPageUI.PRODUCT_ATTRIBUTES_ON_ORDER_PAGE_BY_CLASS, attributeClass);
		return getElementText(driver, UserOrderPageUI.PRODUCT_ATTRIBUTES_ON_ORDER_PAGE_BY_CLASS, attributeClass);
	}
	public String getProductNameOnOrderDetailPage() {
		waitForElementVisible(driver, UserOrderPageUI.PRODUCT_NAME_ON_ORDER_PAGE);
		return getElementText(driver, UserOrderPageUI.PRODUCT_NAME_ON_ORDER_PAGE);
	}
	public String getGiftWrappingMethodOnOrderDetailPage() {
		waitForElementVisible(driver, UserOrderPageUI.GIFT_WRAPPING_DISPLAYED_ON_ORDER_PAGE);
		return getElementText(driver, UserOrderPageUI.GIFT_WRAPPING_DISPLAYED_ON_ORDER_PAGE).substring(15);
	}
	public String getSummaryPriceOnOrderDetailPage(String titleClass, String valueClass) {
		waitForElementVisible(driver, UserOrderPageUI.SUMMARY_PRICE_INFO_ON_ORDER_PAGE_BY_LABEL, titleClass, valueClass);
		return getElementText(driver, UserOrderPageUI.SUMMARY_PRICE_INFO_ON_ORDER_PAGE_BY_LABEL, titleClass, valueClass);
	}
	public boolean isCorrectTotalValueOnOrderDetailPage(String productTotalPriceAfter, String shippingFee, String tax, String total) {
		boolean isCorrectTotal = false;
		int subTotalValue = Integer.valueOf(productTotalPriceAfter.replace(".00", "").replaceAll("[^0-9]", ""));
		int shippingValue = Integer.valueOf(shippingFee.replace(".00", "").replaceAll("[^0-9]", ""));
		int taxValue = Integer.valueOf(tax.replace(".00", "").replaceAll("[^0-9]", ""));
		int totalValue = Integer.valueOf(total.replace(".00", "").replaceAll("[^0-9]", ""));
		if(totalValue == subTotalValue + shippingValue + taxValue ) {
			isCorrectTotal = true;
		}
		return isCorrectTotal;
}
	public void clickToDetailButton() {
		waitForElementClickable(driver, UserOrderPageUI.DETAIL_BUTTON);
		clickToElement(driver, UserOrderPageUI.DETAIL_BUTTON);
	}
}