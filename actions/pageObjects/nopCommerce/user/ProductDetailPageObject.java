package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.ProductDetailPageUI;

public class ProductDetailPageObject extends BasePage{
	WebDriver driver;

	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToOverviewButtonByProductNameAndButtonLabel(String productName, String buttonLabel) {
		waitForElementClickable(driver, ProductDetailPageUI.DYNAMIC_OVERVIEW_BUTTON_BY_NAME, productName, buttonLabel);
		clickToElement(driver, ProductDetailPageUI.DYNAMIC_OVERVIEW_BUTTON_BY_NAME, productName, buttonLabel);
	}
	
	public void clickToOverviewButtonByProductNameAndButtonLabelOnProductPage(String productName, String buttonLabel) {
		waitForElementClickable(driver, ProductDetailPageUI.DYNAMIC_OVERVIEW_BUTTON_BY_NAME_ON_PRODUCT_PAGE, productName, buttonLabel);
		clickToElement(driver, ProductDetailPageUI.DYNAMIC_OVERVIEW_BUTTON_BY_NAME_ON_PRODUCT_PAGE, productName, buttonLabel);
	}

	public String getResultMessageAfterClickOnOverviewButtons() {
		waitForElementVisible(driver, ProductDetailPageUI.SUCCESS_ADD_TO_WISHLIST_CART_COMPARE_MESSAGE);
		return getElementText(driver, ProductDetailPageUI.SUCCESS_ADD_TO_WISHLIST_CART_COMPARE_MESSAGE);		
	}

	public void selectRAMOptionInDropdownList(String ramOption) {
		waitForElementVisible(driver, ProductDetailPageUI.RAM_OPTION_IN_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, ProductDetailPageUI.RAM_OPTION_IN_DROPDOWN_LIST, ramOption);
		
	}

	public void selectHDDOptionRadioButton(String hddOption) {
		waitForElementVisible(driver, ProductDetailPageUI.HDD_OPTION_TO_BUILD_COMPUTER, hddOption);
		if(!isElementSelected(driver, ProductDetailPageUI.HDD_OPTION_TO_BUILD_COMPUTER, hddOption)) {
			clickToElement(driver, ProductDetailPageUI.HDD_OPTION_TO_BUILD_COMPUTER, hddOption);
			
		}
	}

	public void selectProcessorInDropdown(String processorType) {
		waitForElementVisible(driver, ProductDetailPageUI.PROCESSOR_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, ProductDetailPageUI.PROCESSOR_DROPDOWN_LIST, processorType);
		
	}

	public void selectOSTypeRadioButton(String osType) {
		waitForElementVisible(driver, ProductDetailPageUI.OS_RADIO_BUTTON_BY_LABEL, osType);
		if(!isElementSelected(driver, ProductDetailPageUI.OS_RADIO_BUTTON_BY_LABEL, osType)) {
			clickToElement(driver, ProductDetailPageUI.OS_RADIO_BUTTON_BY_LABEL, osType);
			sleepInSecond(3);
		}		
	}

	public void selectSoftwareOptionCheckbox(String software) {
		waitForElementVisible(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX_BY_LABEL, software);
		if(!isElementSelected(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX_BY_LABEL, software)) {
			clickToElement(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX_BY_LABEL, software);
			sleepInSecond(3);
		}	
	}

	public void deselectSoftwareOptionCheckbox(String software) {
		waitForElementVisible(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX_BY_LABEL, software);
		if(isElementSelected(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX_BY_LABEL, software)) {
			clickToElement(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX_BY_LABEL, software);
		}			
	}
	
	public void inputOrderNumber(String orderNumber) {
		waitForElementVisible(driver, ProductDetailPageUI.ORDER_NUMBER_TEXTBOX);
		sendkeyToElement(driver, ProductDetailPageUI.ORDER_NUMBER_TEXTBOX, orderNumber);
		sleepInSecond(3);
	}

	public String getpriceValueOfAddedToCartProduct() {
		waitForElementVisible(driver, ProductDetailPageUI.PRICE_VALUE);
		return getElementText(driver,ProductDetailPageUI.PRICE_VALUE);
	}

	public String getOrderNumberDisplayedOnShoppingCartLink() {
		waitForElementVisible(driver, ProductDetailPageUI.NUMBER_DISPLAYED_ON_SHOPPING_CART);
		return getElementText(driver,ProductDetailPageUI.NUMBER_DISPLAYED_ON_SHOPPING_CART).replace("(", "").replace(")", "");
		
	}

	public boolean isCorrectInfoDisplayedOnShoppingCartLink(String expectedProcessor, String expectedRAM, String expectedHDD, String expectedOS, String expectedSoftware ) {
		waitForElementVisible(driver, ProductDetailPageUI.BUILDER_COMPUTER_ATTRIBUTE_ON_SHOPPING_CART);
		String attributesValue = getElementText(driver, ProductDetailPageUI.BUILDER_COMPUTER_ATTRIBUTE_ON_SHOPPING_CART);
		System.out.println(attributesValue);
		boolean isCorrectAttributes = false;
		String[] lines = attributesValue.split("\r\n|\n|\r");
		
		String actualProcessor = lines[0].replace("Processor: ", "");
		System.out.println(actualProcessor);
		String actualRAM = lines[1].replace("RAM: ", "");
		System.out.println(actualRAM);
		String actualHDD = lines[2].replace("HDD: ", "");
		System.out.println(actualHDD);
		String actualOS = lines[3].replace("OS: ", "");
		System.out.println(actualOS);
		String actualSoftware = lines[4].replace("Software: ", "");
		System.out.println(actualSoftware);
		if (actualProcessor.equals(expectedProcessor) && actualRAM.equals(expectedRAM) && actualHDD.equals(expectedHDD) 
				&& actualOS.equals(expectedOS) && actualSoftware.equals(expectedSoftware)) {
			isCorrectAttributes = true;
		}
	 return isCorrectAttributes;
}

	public void hoverOverShoppingCartLink() {
		waitForElementVisible(driver, ProductDetailPageUI.SHOPPING_CARD_ON_TOP_MENU);
		hoverMouseToElement(driver, ProductDetailPageUI.SHOPPING_CARD_ON_TOP_MENU);
	}

	public void closeSuccessMessage() {
		waitForElementVisible(driver, ProductDetailPageUI.CLOSE_SUCCESS_MESSAGE);
		clickToElement(driver, ProductDetailPageUI.CLOSE_SUCCESS_MESSAGE);
	}

	public String getProductPriceDisplayedOnShoppingCartLink() {
		waitForElementVisible(driver, ProductDetailPageUI.BUILDER_COMPUTER_PRICE_ON_SHOPPING_CART);
		return getElementText(driver, ProductDetailPageUI.BUILDER_COMPUTER_PRICE_ON_SHOPPING_CART);
	}

	public String getNumberItemInTextShownOnShoppingCartLink() {
		waitForElementVisible(driver, ProductDetailPageUI.TEXT_SHOW_NUMBER_WHEN_HOVER_OVER_SHOPPING_CARD);
		return getElementText(driver,  ProductDetailPageUI.TEXT_SHOW_NUMBER_WHEN_HOVER_OVER_SHOPPING_CARD).replace(" item(s)", "");
	}
	public String getTextShowNumberItemOnShoppingCartLink() {
		waitForElementVisible(driver, ProductDetailPageUI.TEXT_SHOW_NUMBER_ITEMS_WHEN_HOVER_OVER_SHOPPING_CARD);
		System.out.println(getElementText(driver,  ProductDetailPageUI.TEXT_SHOW_NUMBER_ITEMS_WHEN_HOVER_OVER_SHOPPING_CARD));
		return getElementText(driver,  ProductDetailPageUI.TEXT_SHOW_NUMBER_ITEMS_WHEN_HOVER_OVER_SHOPPING_CARD);
	}

	public int getTotalPriceShownOnShoppingCartLink() {
		waitForElementVisible(driver, ProductDetailPageUI.TOTAL_PRICE);
		System.out.println(Integer.valueOf(getElementText(driver, ProductDetailPageUI.TOTAL_PRICE).replace("$", "").replace(",", "").replace(".00", "")));
		return Integer.valueOf(getElementText(driver, ProductDetailPageUI.TOTAL_PRICE).replace("$", "").replace(",", "").replace(".00", ""));
		
		
	}

	
}
