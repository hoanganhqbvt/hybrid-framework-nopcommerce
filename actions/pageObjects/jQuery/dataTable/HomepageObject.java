package pageObjects.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUIs;

public class HomepageObject extends BasePage{
	WebDriver driver;

	
	public HomepageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void openPagingByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUIs.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUIs.PAGINATION_PAGE_BY_NUMBER, pageNumber);		
	}
	public void enterToHeaderTextboxByLabel(String headerLabel, String searchValue) {
		waitForElementVisible(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABEL, searchValue, headerLabel);
		pressKeyToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
		
	}
	public boolean isPageNuumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUIs.ACTIVED_PAGE_BY_NUMBER, pageNumber);
		return isElementDisplay(driver, HomePageUIs.ACTIVED_PAGE_BY_NUMBER, pageNumber);		 
	}
	
	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUIs.TOTAL_PAGINATION);
		System.out.println("Total page= " + totalPage);
		
		List<String> allRowValueAllPage = new ArrayList<>();
		
		// Duyet qua tat ca cac page number (paging)
		for(int index = 1; index <= totalPage; index++ ) {
			clickToElement(driver, HomePageUIs.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			
			// Get text của all row mỗi page đưa vào ArrayList
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUIs.ALL_ROW_COUNTRY_EACH_PAGE);
			for(WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		// In tất cả giá trị row - tất cả các page
		for(String value : allRowValueAllPage) {
			System.out.println(value);
		}
		return allRowValueAllPage;
	}
	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToEnter) {
		// Column index dựa vào tên cột
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		
		// Sendkey vào dòng nào
		waitForElementVisible(driver, HomePageUIs.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUIs.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber, String.valueOf(columnIndex));
	
	}
	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUIs.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUIs.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columnIndex));
		
	}
	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUIs.LOAD_BUTTON);
		clickToElement(driver, HomePageUIs.LOAD_BUTTON);
	}
	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {	
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}
	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {	
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}
	public void clickToIconByRowNumber(String rowIndex, String iconName) {
		waitForElementClickable(driver, HomePageUIs.ICON_BY_TITLE_AND_BY_ROW_INDEX, rowIndex, iconName);
		clickToElement(driver, HomePageUIs.ICON_BY_TITLE_AND_BY_ROW_INDEX, rowIndex, iconName);
		
	}
}
