package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import commons.BasePage;
import commons.PageGeneratorManager;
import commons.VerificationFailures;
import pageUIs.nopCommerce.user.UserComputerPageUI;

public class UserComputerPageObject extends BasePage{
 WebDriver driver;

public UserComputerPageObject(WebDriver driver) {
	this.driver = driver;
}

public void selectSortByOptionInDropdownList(String sortbyOption) {
	waitForElementClickable(driver, UserComputerPageUI.SORT_BY_DROPDOWN);
	selectItemInDefaultDropdown(driver, UserComputerPageUI.SORT_BY_DROPDOWN, sortbyOption);
	sleepInSecond(2);
}

public List<Double> getProductPriceList() {
	List<WebElement> prices = getListWebElement(driver, UserComputerPageUI.PRODUCTS_PRICE);
	List<Double> priceList = new ArrayList<>();
	
	for(WebElement price : prices) {
		priceList.add(Double.valueOf(price.getText().replace("$", "").replace(",", "").replace(".00", "")));
	}
	return priceList;
}

	public boolean isSortedPriceLowToHighCorrectly(List<Double> beforeFilterList, List<Double> afterFilterList) {
		boolean pass = true;
		Collections.sort(beforeFilterList);	
		try {
			Assert.assertEquals(beforeFilterList, afterFilterList);	
		} catch (Throwable e) {			
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	public boolean isSortedPriceHighToLowCorrectly(List<Double> beforeFilterList, List<Double> afterFilterList) {
		boolean pass = true;
		Collections.sort(beforeFilterList);	
		Collections.reverse(beforeFilterList);
		try {
			Assert.assertEquals(beforeFilterList, afterFilterList);	
		} catch (Throwable e) {			
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public void selectPageSizeOption(String pageSizeOption) {
		waitForElementVisible(driver, UserComputerPageUI.NUMBER_PRODUCTS_DISPLAYED_PER_PAGE_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserComputerPageUI.NUMBER_PRODUCTS_DISPLAYED_PER_PAGE_DROPDOWN, pageSizeOption);
		sleepInSecond(2);
	}

	public boolean isNumberProductDisplayedCorrect(int pageSize) {
		boolean isCorrectNumber = false;		
		if(isElementUndisplayed(driver, UserComputerPageUI.NEXT_PAGE_ICON))
		 {
			waitForElementVisible(driver, UserComputerPageUI.NUMBER_PRODUCTS_IF_ONLY_ONE_PAGE);
			if(getListWebElement(driver, UserComputerPageUI.NUMBER_PRODUCTS_IF_ONLY_ONE_PAGE).size()<= pageSize) {				
			isCorrectNumber = true;
		} else isCorrectNumber = false;	
		}else {	
			waitForElementVisible(driver, UserComputerPageUI.NUMBER_PAGE_OF_PRODUCT);
			int numberOfPage = getElementSize(driver, UserComputerPageUI.NUMBER_PAGE_OF_PRODUCT);		
			for(int i=1; i<=(numberOfPage-1); i++) {						
			waitForElementVisible(driver, UserComputerPageUI.NUMBER_PRODUCT_ON_A_DYNAMIC_PAGE, String.valueOf(i));
			int numberProductOnAPage = getElementSize(driver, UserComputerPageUI.NUMBER_PRODUCT_ON_A_DYNAMIC_PAGE, String.valueOf(i));															
			waitForElementVisible(driver, UserComputerPageUI.NEXT_PAGE_ICON);
			clickToElement(driver, UserComputerPageUI.NEXT_PAGE_ICON);
			waitForElementVisible(driver, UserComputerPageUI.NUMBER_PRODUCT_ON_A_DYNAMIC_PAGE, String.valueOf(numberOfPage));			
			int numberProductOnLastPage = getElementSize(driver, UserComputerPageUI.NUMBER_PRODUCT_ON_A_DYNAMIC_PAGE, String.valueOf(numberOfPage));
			
			if(numberProductOnAPage == pageSize && numberProductOnLastPage <= pageSize) {
				isCorrectNumber = true;
			}}	
} 
		return isCorrectNumber;
}

	public boolean isNextOrPreviousPageIconDisplayed() {
		boolean isPagingIconDisplayedCorrectly = false;				
			waitForElementVisible(driver, UserComputerPageUI.NUMBER_PAGE_OF_PRODUCT);
			int numberOfPage = getElementSize(driver, UserComputerPageUI.NUMBER_PAGE_OF_PRODUCT);
			waitForElementVisible(driver, UserComputerPageUI.PAGE_NUMBER_OF_CURRENT_PAGE);
			if(Integer.parseInt(getElementText(driver, UserComputerPageUI.PAGE_NUMBER_OF_CURRENT_PAGE)) <numberOfPage) {
							
			if(isElementDisplay(driver, UserComputerPageUI.NEXT_PAGE_ICON)){
				isPagingIconDisplayedCorrectly = true;
			} } else if(Integer.parseInt(getElementText(driver, UserComputerPageUI.PAGE_NUMBER_OF_CURRENT_PAGE)) == numberOfPage) {
				if(isElementDisplay(driver, UserComputerPageUI.PREVIOUS_PAGE_ICON)){
					isPagingIconDisplayedCorrectly = true;
} }
			
		return isPagingIconDisplayedCorrectly;
}

	public void selectPageByNumber(String pageNumber) {
		waitForElementVisible(driver, UserComputerPageUI.SELECT_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, UserComputerPageUI.SELECT_PAGE_BY_NUMBER, pageNumber);		
	}

	public boolean isPagingIsNotDisplayed() {
		return isElementUndisplayed(driver, UserComputerPageUI.PAGING_LINE);		
	}

	public ProductDetailPageObject selectAProductByNameToViewDetail(String productName) {
		waitForElementVisible(driver, UserComputerPageUI.DYNAMIC_PRODUCTS_BY_TITLE, productName);
		clickToElement(driver, UserComputerPageUI.DYNAMIC_PRODUCTS_BY_TITLE, productName);	
		return PageGeneratorManager.getProductDetailPage(driver);
	}
		
	}
	
	
