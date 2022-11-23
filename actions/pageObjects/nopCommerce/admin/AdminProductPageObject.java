package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.admin.AdminProductPageUI;

public class AdminProductPageObject extends BasePage{
	WebDriver driver;
	
public AdminProductPageObject(WebDriver driver) {
	this.driver = driver;
}

public void inputToTextboxByID(String inputValue, String textboxID) {
	waitForElementVisible(driver, AdminProductPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
	sendkeyToElement(driver, AdminProductPageUI.DYNAMIC_TEXTBOX_BY_ID, inputValue, textboxID);
}

public void clickToSearchButton() {
	waitForElementClickable(driver, AdminProductPageUI.SEARCH_BUTTON);
	clickToElement(driver, AdminProductPageUI.SEARCH_BUTTON);
	sleepInSecond(2);
}

public String getSearchedProductInfoInTable(String rowNuber, String columnName) {
	waitForElementVisible(driver, AdminProductPageUI.COLUMN_NUMBER_BY_TITLE, columnName);
	int columnNumber = Integer.valueOf(getElementSize(driver, AdminProductPageUI.COLUMN_NUMBER_BY_TITLE, columnName)) + 1;
	return getElementText(driver, AdminProductPageUI.CELL_INDEX_BY_ROW_NUMBER_AND_COLUM_NUMBER, rowNuber, String.valueOf(columnNumber));
}

public int getNumberOfProductMatched() {
	waitForAllElementVisible(driver, AdminProductPageUI.NUMBER_SEARCH_PRODUCT_LINE_IN_TABLE);
	return getElementSize(driver, AdminProductPageUI.NUMBER_SEARCH_PRODUCT_LINE_IN_TABLE);
	
}

public void selectOptionInDropdownListByName(String dropdownListID, String optionName) {
	waitForElementVisible(driver, AdminProductPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID, dropdownListID);
	selectItemInDefaultDropdown(driver, AdminProductPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID, optionName, dropdownListID);
	}

public void uncheckSearchSubcategoryCheckbox() {
	waitForElementVisible(driver, AdminProductPageUI.SEARCH_SUBCATEGORIES_CHECKBOX);
	if(isElementSelected(driver, AdminProductPageUI.SEARCH_SUBCATEGORIES_CHECKBOX)) {
		clickToElement(driver, AdminProductPageUI.SEARCH_SUBCATEGORIES_CHECKBOX);
	}
}

public boolean isNoDataAvailableMessageDisplayed() {
	waitForElementVisible(driver, AdminProductPageUI.NO_DATA_AVAILABLE_MESSAGE);
	return isElementDisplay(driver, AdminProductPageUI.NO_DATA_AVAILABLE_MESSAGE);
}

public void checkSearchSubcategoryCheckbox() {
	waitForElementVisible(driver, AdminProductPageUI.SEARCH_SUBCATEGORIES_CHECKBOX);
	if(!isElementSelected(driver, AdminProductPageUI.SEARCH_SUBCATEGORIES_CHECKBOX)) {
		clickToElement(driver, AdminProductPageUI.SEARCH_SUBCATEGORIES_CHECKBOX);
	}
	
}

public void clickToGoToSKUbutton() {
	waitForElementClickable(driver, AdminProductPageUI.GO_TO_PRODUCT_SKU_BUTTON);
	clickToElement(driver, AdminProductPageUI.GO_TO_PRODUCT_SKU_BUTTON);
}

public String getProductValueDisplayedOnProductDetailPage(String label, String attributeName) {
	waitForElementVisible(driver, AdminProductPageUI.DYNAMIC_PRODUCT_VALUE_ON_DETAIL_PAGE_BY_LABEL, label);
	System.out.println(getElementAttributeValue(driver, AdminProductPageUI.DYNAMIC_PRODUCT_VALUE_ON_DETAIL_PAGE_BY_LABEL, attributeName, label));
	return getElementAttributeValue(driver, AdminProductPageUI.DYNAMIC_PRODUCT_VALUE_ON_DETAIL_PAGE_BY_LABEL, attributeName, label);
}

public String getProductCategoryOnDetailPage() {
	waitForElementVisible(driver, AdminProductPageUI.PRODUCT_CATEGORY_ON_DETAIL_PAGE);
	System.out.println(getElementText(driver, AdminProductPageUI.PRODUCT_CATEGORY_ON_DETAIL_PAGE));
	return getElementText(driver, AdminProductPageUI.PRODUCT_CATEGORY_ON_DETAIL_PAGE);
}


}
