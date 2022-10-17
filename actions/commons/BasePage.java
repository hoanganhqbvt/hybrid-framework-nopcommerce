package commons;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageUI.bankGuru.user.BasePageBankGuruUI;
import pageUIs.jQuery.dataTable.BasePageJQueryUI;
import pageUIs.nopCommerce.user.BasePageNopcommerceUI;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.MyAccountPageUI;
import pageUIs.orangeHRM.admin.BasePageOrangeHRMUI;


public class BasePage {
	
	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver ) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshCurentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
		
	}
	
	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	
	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver, String tabTitle) {

		Set<String> allWindowIDs = driver.getWindowHandles();
				for (String id : allWindowIDs) {
				driver.switchTo().window(id);
				String actualTitle = driver.getTitle();
				System.out.println("Actual title: " + actualTitle);
				if (actualTitle.equals(tabTitle)) {
					break;
				}
			}
		}
	
	public void closeAllTabsExceptParentByID(WebDriver driver, String parentTabID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentTabID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentTabID);
		}
		
	}
	
	public void closeAllTabsExceptParentByTitle(WebDriver driver, String parentTabTitle) {

		Set<String> allWindowIDs = driver.getWindowHandles();
				for (String id : allWindowIDs) {
					driver.switchTo().window(id);
				String actualTitle = driver.getTitle();
				if (!actualTitle.equals(parentTabTitle)) {
					driver.close();				
									}
			}
		
	}
	
	//=9locatorType: id=/ css=/ xpath=/ name=/ class=?
	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		}
			else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLass="))
			{ by = By.className(locatorType.substring(6)); 
			}
			
			else if(locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) 
			{ by = By.name(locatorType.substring(5)); 
			}
			else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css="))
			{ by = By.cssSelector(locatorType.substring(4));
			
			}
			 else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath=")) {
				 by = By.xpath(locatorType.substring(6));
				 }
			 else { throw new RuntimeException("Locator type is not supported");
					 
				 }
		return by;
	}
	
	private String getDynamicXpath(String locatorType, String... dynamicValues) {	
		if(locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=") 
				|| locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;
		
	}
		
	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}
	
	public WebElement getWebElement(WebDriver driver, String locatorType, String...dynamicValues) {
		return driver.findElement(getByLocator(getDynamicXpath(locatorType, dynamicValues)));
	}
	
	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}
	
	public List<WebElement> getListWebElement(WebDriver driver, String locatorType, String...dynamicValues) {
		return driver.findElements(getByLocator(getDynamicXpath(locatorType, dynamicValues)));
	}
	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, locatorType, dynamicValues).click();
	}
		
	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);				
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String...dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);				
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String...dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}
	
	public String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		List <WebElement> allItems = driver.findElements(getByLocator(childXpath));
		System.out.println("Item size = " + allItems.size());
		for (WebElement item : allItems) {
			if(item.getText().trim().equals(expectedTextItem)) {			
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}
	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem, String...jobDropdownLabel) {
		
		getWebElement(driver, parentXpath, jobDropdownLabel).click();
		sleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, getDynamicXpath(childXpath, jobDropdownLabel))));
		List <WebElement> allItems = getListWebElement(driver, getDynamicXpath(childXpath, jobDropdownLabel));
		System.out.println("Item size = " + allItems.size());
		for (WebElement item : allItems) {
			if(item.getText().trim().equals(expectedTextItem)) {			
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
			sleepInSecond(1);
			item.click();
			break;
			}
		}
	}
	
	public void sleepInSecond(long time) {
			try {
				Thread.sleep(time * 1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
	public String getElementAttributeValue(WebDriver driver, String locatorType, String attributeName) {
		return	getWebElement(driver, locatorType).getAttribute(attributeName);
	}
	
	public String getElementAttributeValue(WebDriver driver, String locatorType, String attributeName, String...dynamicValue) {
			return	getWebElement(driver, locatorType, dynamicValue).getAttribute(attributeName);
		}
	public String getElementText(WebDriver driver, String locatorType) {
		return	getWebElement(driver, locatorType).getText();
	}	
		
	public String getElementText(WebDriver driver, String locatorType, String...dynamicValues) {
		return	getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}	
	
	public void inputToTextboxByID(WebDriver driver, String locatorType, String value, String textboxID) {
		waitForElementVisible(driver, locatorType, textboxID);
		sendkeyToElement(driver, locatorType, value, textboxID);
		
	}
	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
			return getWebElement(driver, locatorType).getCssValue(propertyName);
		}
		
	public String getHexaColorFromRGBA(String rgbaValue) {
			return Color.fromString(rgbaValue).asHex();
		}
	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}
	public int getElementSize(WebDriver driver, String locatorType, String...dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}
	
	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType, String...dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType, String...dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplay(WebDriver driver, String locatorType) {
		try {
		return getWebElement(driver, locatorType).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean isElementDisplay(WebDriver driver, String locatorType, String...dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}
	
	public void overrideImplicitTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	// case 2 + 3 (Undisplayed elements)
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		System.out.println("Start time = " + new Date().toString());
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locator);
		overrideImplicitTimeout(driver, longTimeout);
		
		if (elements.size() == 0) {
			System.out.println("Element is not in DOM");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element is in DOM but not visible/ displayed");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else {
			System.out.println("Element is in DOM and visible");
			return false;
		}
	}
	public boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}
	public boolean isElementSelected(WebDriver driver, String locatorType, String...dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected();
	}
	
	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locatorType, String...dynamicValues) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType, dynamicValues)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void hightlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isImageLoaded(WebDriver driver, String locatorType, String...dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return status;
	}
	/*
	 * wait for element Undisplayed in DOM or not in DOM and override implicit timeout 
	 */
	
	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForElementUndisplayed(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideImplicitTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitTimeout(driver, longTimeout);
	}
	public void waitForElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	public void waitForAllElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForAllElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));		
	}
	
	public void waitForAllElementInvisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues))));		
	}
	
	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	public void waitForElementClickable(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	public void uploadMultipleFiles(WebDriver driver, String...fileNames) {
		// Đường dẫn thư mục uploadFiles: Windows/ MAC/ Linux
		String filePath = GlobalConstants.UPLOAD_FILE;
		
		//Đường dẫn của tất cả các files
		String fullFileName = "";
		for (String file: fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, BasePageJQueryUI.UPLOAD_FILE, fileNames).sendKeys(fullFileName);
	}
	// Tối ưu ở bài Level_07_Switch Page
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageNopcommerceUI.ADDRESS_LINK);
		clickToElement(driver, BasePageNopcommerceUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	public UserLoginPageObject openUserLoginPage(WebDriver driver) {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageNopcommerceUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, BasePageNopcommerceUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageNopcommerceUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageNopcommerceUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageNopcommerceUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageNopcommerceUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}
	
	// Tối ưu ở bài Level_09_Dynamic_Locator
	 public BasePage openPageAtMyAccountByName(WebDriver driver, String pageName) {
		 waitForElementClickable(driver, BasePageNopcommerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		 clickToElement(driver, BasePageNopcommerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		 switch (pageName) {
		 case "Customer info":
			 return PageGeneratorManager.getUserCustomerInfoPage(driver);
		 case "Addresses":
			 return PageGeneratorManager.getUserAddressPage(driver);
		 case "Reward points":
			 return PageGeneratorManager.getUserRewardPointPage(driver);
		 case "My product reviews":
			 return PageGeneratorManager.getUserMyProductReviewPage(driver);
		 default:
			 throw new RuntimeException("Invalid page name at My Account area");
		 }
	 }
	 public void openPageAtMyAccountByPageName(WebDriver driver, String pageName) {
		 waitForElementClickable(driver, BasePageNopcommerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		 clickToElement(driver, BasePageNopcommerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
	 }
	 
	 public void openLinkPageAtHomePageByName(WebDriver driver, String pageName) {
		 waitForElementClickable(driver, BasePageNopcommerceUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);
		 clickToElement(driver, BasePageNopcommerceUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);
	 }
	 
	 public void openPageAtEmployeeDetailByPageName(WebDriver driver, String pageName) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;	
		 js.executeScript("window.scrollBy(0,-250)");	 
		 waitForElementClickable(driver, BasePageOrangeHRMUI.DYNAMIC_PAGE_AT_EMPLOYEE_DETAIL, pageName);
		 clickToElement(driver, BasePageOrangeHRMUI.DYNAMIC_PAGE_AT_EMPLOYEE_DETAIL, pageName);
	 }
	 
	 public void openTabOnPIMPageByName(WebDriver driver, String tabName) {
	 JavascriptExecutor js = (JavascriptExecutor) driver;	
	 js.executeScript("window.scrollBy(0,-250)");	 
	 waitForElementClickable(driver, BasePageOrangeHRMUI.DYNAMIC_TAB_ON_PIM_PAGE_BY_NAME, tabName);
	 clickToElement(driver, BasePageOrangeHRMUI.DYNAMIC_TAB_ON_PIM_PAGE_BY_NAME, tabName);
	 }
	 
	 public void openPageOnManagerPageByName(WebDriver driver, String pageName) {		
		 waitForElementClickable(driver, BasePageBankGuruUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);
		 clickToElement(driver, BasePageBankGuruUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);		 
	 }
		 
	 private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	 private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
}
