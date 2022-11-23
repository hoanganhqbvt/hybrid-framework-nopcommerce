package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CheckoutPageUI;

public class CheckoutPageObject extends BasePage{
	WebDriver driver;
	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void selectShipToTheSameAddressCheckbox() {
		waitForElementVisible(driver, CheckoutPageUI.SHIP_TO_THE_SAME_ADDRESS_CHECKBBOX);
		if(!isElementSelected(driver, CheckoutPageUI.SHIP_TO_THE_SAME_ADDRESS_CHECKBBOX)){
			clickToElement(driver, CheckoutPageUI.SHIP_TO_THE_SAME_ADDRESS_CHECKBBOX);
		}
	}
	public void selectOptionInDropdownList(String dropdownName, String optionText) {
		waitForElementClickable(driver, CheckoutPageUI.DYNAMIC_DROPDOWN_LIST_BY_LABEL, dropdownName);
		selectItemInDefaultDropdown(driver, CheckoutPageUI.DYNAMIC_DROPDOWN_LIST_BY_LABEL, optionText, dropdownName);		
	}
	
	public void inputToTextboxByLabel(String textboxName, String inputValue) {
		waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL, textboxName);
		sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL, inputValue, textboxName);		
	}
	public void clickToContinueButtonByClass(String classContains) {
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_CLASS, classContains);
		clickToElement(driver,  CheckoutPageUI.CONTINUE_BUTTON_BY_CLASS, classContains);
	}
	public void selectShippingMethodRadioButton(String radioID) {
		waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_METHOD_BY_ID, radioID);
		if(!isElementSelected(driver, CheckoutPageUI.DYNAMIC_SHIPPING_METHOD_BY_ID, radioID)) {
			clickToElement(driver, CheckoutPageUI.DYNAMIC_SHIPPING_METHOD_BY_ID, radioID);
		}
	}
	public void selectPaymentMethodRadioButton(String radioID) {
		waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_PAYMENT_METHOD_BY_ID, radioID);
		if(!isElementSelected(driver, CheckoutPageUI.DYNAMIC_PAYMENT_METHOD_BY_ID, radioID)) {
			clickToElement(driver, CheckoutPageUI.DYNAMIC_PAYMENT_METHOD_BY_ID, radioID);
		}
	}
	public String getPaymentInformationContent() {
		waitForElementVisible(driver, CheckoutPageUI.PAYMENT_INFORMATION_TEXT);
		System.out.println(getElementText(driver, CheckoutPageUI.PAYMENT_INFORMATION_TEXT));
		return getElementText(driver, CheckoutPageUI.PAYMENT_INFORMATION_TEXT);
	}
	public String getBillingAddressInfoInConfirmSectionByClass(String billingAddressClass) {
		waitForAllElementVisible(driver, CheckoutPageUI.BILLING_INFO_BY_CLASS, billingAddressClass);
		return getElementText(driver, CheckoutPageUI.BILLING_INFO_BY_CLASS, billingAddressClass);
	}
	public String getShippingAddressInfoInConfirmSectionByClass(String shippingAddressClass) {
		waitForAllElementVisible(driver, CheckoutPageUI.SHIPPING_INFO_BY_CLASS, shippingAddressClass);
		return getElementText(driver, CheckoutPageUI.SHIPPING_INFO_BY_CLASS, shippingAddressClass);
	}
	public String getPaymentMethodInfoInConfirmSection() {
		waitForElementVisible(driver, CheckoutPageUI.PAYMENT_METHOD_IN_CONFIRM_SECTION);
		return getElementText(driver, CheckoutPageUI.PAYMENT_METHOD_IN_CONFIRM_SECTION);
	}
	public String getShippingMethodInfoInConfirmSection() {
		waitForElementVisible(driver, CheckoutPageUI.SHIPPING_METHOD_IN_CONFIRM_SECTION);
		return getElementText(driver, CheckoutPageUI.SHIPPING_METHOD_IN_CONFIRM_SECTION);
	}
	public boolean isBillingStateProvinceCityZipPostalCodeDisplayedCorrectlyInConfirmSection(String city, String stateProvince, 
			String zipPostal) {
		boolean isCorrectStateCityZip = false;
		waitForElementVisible(driver, CheckoutPageUI.STATE_CITY_ZIP_BILLING_ADDRESS_IN_CONFIRM_SECTION);
		String stateCityZip = getElementText(driver, CheckoutPageUI.STATE_CITY_ZIP_BILLING_ADDRESS_IN_CONFIRM_SECTION).trim();
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
	public String getProductAttributesOnCheckoutTable(String attributeClass) {
		waitForElementVisible(driver, CheckoutPageUI.PRODUCT_ATTRIBUTES_ON_CHECKOUT_BY_CLASS, attributeClass);
		return getElementText(driver, CheckoutPageUI.PRODUCT_ATTRIBUTES_ON_CHECKOUT_BY_CLASS, attributeClass);
	}
	public String getProductNameOnCheckoutTable() {
		waitForElementVisible(driver, CheckoutPageUI.PRODUCT_NAME_ON_CHECKOUT_BY_CLASS);
		return getElementText(driver, CheckoutPageUI.PRODUCT_NAME_ON_CHECKOUT_BY_CLASS);
	}
	public String getGiftWrappingMethodOnCheckoutPage() {
		waitForElementVisible(driver, CheckoutPageUI.GIFT_WRAPPING_DISPLAYED_ON_CHECKOUT_PAGE);
		return getElementText(driver,  CheckoutPageUI.GIFT_WRAPPING_DISPLAYED_ON_CHECKOUT_PAGE).substring(15);
	}
	public String getSummaryPriceOnCheckoutPage(String titleClass, String valueClass) {
		waitForElementVisible(driver, CheckoutPageUI.SUMMARY_PRICE_INFO_ON_CHECKOUT_BY_CLASS, titleClass, valueClass);
		return getElementText(driver, CheckoutPageUI.SUMMARY_PRICE_INFO_ON_CHECKOUT_BY_CLASS, titleClass, valueClass);
	}
	public boolean isCorrectTotalValueOnCheckoutSummary(String productTotalPriceAfter, String shippingFee, String tax, String total) {
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
	public void clickToConfirmButton() {
		waitForElementClickable(driver, CheckoutPageUI.CONFIRM_BUTTON);
		clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON);
	}
	public String getOrderSuccessMessageDisplayed() {
		waitForElementVisible(driver, CheckoutPageUI.ORDER_SUCCESS_MESSAGE);
		return getElementText(driver, CheckoutPageUI.ORDER_SUCCESS_MESSAGE);
	}
	public String getOrderNumber() {
		waitForElementVisible(driver, CheckoutPageUI.ORDER_NUMBER);
		return getElementText(driver, CheckoutPageUI.ORDER_NUMBER).substring(14);
		}
	
	
}