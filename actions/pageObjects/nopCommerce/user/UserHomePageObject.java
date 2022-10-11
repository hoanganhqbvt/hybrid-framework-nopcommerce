package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage {		
	private WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		// CÁCH 2
		// return new RegisterPageObject(driver);
		// CÁCH 3
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		// cách 2: return new LoginPageObject(driver);
		// Cách 3
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);		
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
		
	}
	
		public UserCustomerInfoPageObject clickToMyAccountLink() {
			waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
			clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
			return PageGeneratorManager.getUserMyAccountPage(driver);
		}

		public void clickToPageLinkByName(String pageName) {
			waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);
			clickToElement(driver, HomePageUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);						
		}

		public void clickToAProductToViewDetail(String productLinkText) {
			waitForElementVisible(driver, HomePageUI.DYNAMIC_PRODUCT_LINK_BY_TEXT, productLinkText);
			clickToElement(driver, HomePageUI.DYNAMIC_PRODUCT_LINK_BY_TEXT, productLinkText);	
			
		}

		public UserMyProductReviewPageObject clickToAddYourReviewLink() {
			waitForElementVisible(driver, HomePageUI.ADD_YOUR_REVIEW_LINK);
			clickToElement(driver, HomePageUI.ADD_YOUR_REVIEW_LINK);
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		}

}
