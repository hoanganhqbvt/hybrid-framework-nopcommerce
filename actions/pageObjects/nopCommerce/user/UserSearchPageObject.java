package pageObjects.nopCommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserSearchPageUI;

public class UserSearchPageObject extends BasePage{
	private WebDriver driver;
	
	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println(this.driver.toString());
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}

	public String getWarningMessageDisplayedWhenSearchingWithEmptyData() {
		waitForElementVisible(driver, UserSearchPageUI.WARNING_MESSAGE_WHEN_SEARCHING_WITH_EMPTY_DATA);
		return getElementText(driver, UserSearchPageUI.WARNING_MESSAGE_WHEN_SEARCHING_WITH_EMPTY_DATA);
	}

	public void inputToSearchKeywordTextbox(String notExistData) {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		sendkeyToElement(driver, UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX, notExistData);
	}

	public String getResultMessageDisplayedWhenSearchingWithNotExistData() {
		waitForElementVisible(driver, UserSearchPageUI.RESULT_MESSAGE_WHEN_SEARCHING_WITH_NOT_EXIST_DATA);
		return getElementText(driver, UserSearchPageUI.RESULT_MESSAGE_WHEN_SEARCHING_WITH_NOT_EXIST_DATA);
	}

	public boolean isAllSearchedProductTitleContainSearchKeyword(String searchKeyword) {
		waitForAllElementVisible(driver, UserSearchPageUI.SEARCHED_PRODUCT_TITLE);
		List<WebElement> searchedProductsTitle = getListWebElement(driver, UserSearchPageUI.SEARCHED_PRODUCT_TITLE);
		int productNumber = searchedProductsTitle.size();
		boolean AllMatched = false;
		int productCount = 0;
		for(WebElement productTitle:searchedProductsTitle) {
			if(productTitle.getText().contains(searchKeyword)) {
				productCount++;
			}else {System.out.println("The searched product's title does NOT contain searched keyword");
		} 
			if(productCount == productNumber){
				AllMatched = true;
		} else { AllMatched = false;
	}		
} return AllMatched;
	}

	public boolean isSearchedProductTitleEqualSearchKeyword(String searchKeyword) {
		waitForElementVisible(driver, UserSearchPageUI.SEARCHED_PRODUCT_TITLE);
		boolean productTitleMatched = false;
		if(getElementText(driver, UserSearchPageUI.SEARCHED_PRODUCT_TITLE).equals(searchKeyword)) {
			productTitleMatched = true;
		}
		return productTitleMatched;
	}

	public void selectCheckboxByLabel(String checkboxLabel) {
		waitForElementClickable(driver, UserSearchPageUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabel);
		if(!isElementSelected(driver, UserSearchPageUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabel)){
		clickToElement(driver, UserSearchPageUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabel);		
	}
	}

	public void selectCategoryInDropdownList(String optionText) {
		waitForElementVisible(driver, UserSearchPageUI.CATEGORY_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, UserSearchPageUI.CATEGORY_DROPDOWN_LIST, optionText);
	}

	public void selectManufactorerInDropdownList(String manufactorerName) {
		waitForElementVisible(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN_LIST, manufactorerName);
		
	}
	
	
}
