package pageObjects.nopCommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.RecentlyViewProductPageUI;

public class RecentlyViewProductPageObject extends BasePage{
 WebDriver driver;
 
 public RecentlyViewProductPageObject( WebDriver driver) {
	 this.driver = driver;
 }

public boolean isThreeLastestViewProductDisplayedOnPage(String productName1, String productName2, String productName3) {
	boolean isOnly3LastestProduct = false;
	waitForElementVisible(driver, RecentlyViewProductPageUI.PRODUCT_NAME_LIST_ON_RECENTLY_VIEW_PAGE);
	List<WebElement> actualProductNameList = getListWebElement(driver, RecentlyViewProductPageUI.PRODUCT_NAME_LIST_ON_RECENTLY_VIEW_PAGE);
	String[] expectedProductNameList = {productName1, productName2, productName3};
	if(actualProductNameList.size() == 3) {
		for(String expectedProductName : expectedProductNameList) {
		for(WebElement productName : actualProductNameList) {			
			if(productName.getText().equals(expectedProductName)) {
				isOnly3LastestProduct = true;
					}
				}
			}	
		} return isOnly3LastestProduct;
	}
}
