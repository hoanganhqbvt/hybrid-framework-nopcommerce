package pageObjects.orangeHRM.admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.orangeHRM.admin.PIMPageUI;

public class PIMEmployeeListPO extends BasePage{
	WebDriver driver;
	
	public PIMEmployeeListPO(WebDriver driver) {
		this.driver = driver;
	}
	public PIMAddEmployeePO clickToAddButton() {
		waitForElementClickable(driver, PIMPageUI.ADD_BUTTON_ON_EMPLOYEE_LIST_PAGE);
		clickToElement(driver, PIMPageUI.ADD_BUTTON_ON_EMPLOYEE_LIST_PAGE);
		return PageGeneratorManagerOrangeHRM.getPIMAddEmployeePage(driver);
	}
	public void inputToTextboxOnSearchPageByName(String textboxName, String searchInput) {
		waitForElementVisible(driver, PIMPageUI.DYNAMIC_TEXTBOX_ON_SEARCH_PAGE_BY_NAME, textboxName);
		sendkeyToElement(driver, PIMPageUI.DYNAMIC_TEXTBOX_ON_SEARCH_PAGE_BY_NAME, searchInput, textboxName);
	}
	public void selectOptionInDropdownListByName(String dropdownName, String selectOption) {
		waitForElementClickable(driver, PIMPageUI.DYNAMIC_ARROW_DROPDOWN_ON_SEARCH_PAGE_BY_NAME, dropdownName);
		selectItemInCustomDropdown(driver, PIMPageUI.DYNAMIC_ARROW_DROPDOWN_ON_SEARCH_PAGE_BY_NAME, PIMPageUI.DYNAMIC_OPTIONS_IN_DROPDOWN_LIST_BY_LABEL, selectOption, dropdownName);
		
	}
	public void clickToSearchButton() {
		waitForElementClickable(driver, PIMPageUI.SEARCH_BUTTON);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;		 
		jsExecutor.executeScript("window.scrollBy(0,-200)");
		clickToElement(driver, PIMPageUI.SEARCH_BUTTON);
	}
	public boolean isSearchedEmployeeMatchedSearchCondition(String columnName, String rowNumber, String searchEmployeeValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;		 
		jsExecutor.executeScript("window.scrollBy(0,300)");
		waitForElementVisible(driver, PIMPageUI.DYNAMIC_COLUMN_INDEX_BY_NAME, columnName);
		int columnIndex = getElementSize(driver, PIMPageUI.DYNAMIC_COLUMN_INDEX_BY_NAME, columnName) + 1;
		System.out.println(columnIndex);
		String actualVale = getElementText(driver, PIMPageUI.DYNAMIC_TEXBOX_BY_COLUMN_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));		
		System.out.println(actualVale);
		boolean correct;
		 if(actualVale.equals(searchEmployeeValue)) {
			 correct = true;
		 }else {correct = false;
		 
		 } return correct;
		 
	}
	public void selectSuggestEmployeeFullName() {
		waitForElementVisible(driver, PIMPageUI.AUTO_COMPLETE_TEXT_INPUT);
		clickToElement(driver, PIMPageUI.AUTO_COMPLETE_TEXT_INPUT);
		
	}
		
}
