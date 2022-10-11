package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage {		
	private WebDriver driver;
	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementVisible(driver, UserProductReviewPageUI.REVIEW_TEXTBOX_TITLE);
		sendkeyToElement(driver, UserProductReviewPageUI.REVIEW_TEXTBOX_TITLE, reviewTitle);
	}
	public void inputToReviewTextArea(String reviewText) {
		waitForElementVisible(driver, UserProductReviewPageUI.REVIEW_TEXT_AREA);
		sendkeyToElement(driver, UserProductReviewPageUI.REVIEW_TEXT_AREA, reviewText);
	}
	
	public void clickToSubmitReviewButton() {
		waitForElementClickable(driver, UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver,  UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}
	public void selectRatingLevelRadioButtonByValue(String ratingValue) {
		waitForElementClickable(driver, UserProductReviewPageUI.DYNAMIC_RATING_OPTION_BY_VALUE, ratingValue);
		if(!isElementSelected(driver, UserProductReviewPageUI.DYNAMIC_RATING_OPTION_BY_VALUE, ratingValue)) {
			clickToElement(driver, UserProductReviewPageUI.DYNAMIC_RATING_OPTION_BY_VALUE, ratingValue);
		}
		
	}
	public boolean isSuccessAddProductReviewMessageDisplayed() {
		waitForElementVisible(driver, UserProductReviewPageUI.SUCCESS_ADDED_PRODUCT_REVIEW_MESSAGE);
		return isElementDisplay(driver, UserProductReviewPageUI.SUCCESS_ADDED_PRODUCT_REVIEW_MESSAGE);
	}
	public String getReviewTitleInMyProductReviewPage() {
		waitForElementVisible(driver, UserProductReviewPageUI.REVIEW_TITLE_IN_MY_PRODUCT_REVIEW_PAGE);
		return getElementText(driver,  UserProductReviewPageUI.REVIEW_TITLE_IN_MY_PRODUCT_REVIEW_PAGE);
	}
	public String getReviewContentInMyProductReviewPage() {
		waitForElementVisible(driver, UserProductReviewPageUI.REVIEW_CONTENT_IN_MY_PRODUCT_REVIEW_PAGE);
		return getElementText(driver,  UserProductReviewPageUI.REVIEW_CONTENT_IN_MY_PRODUCT_REVIEW_PAGE);
	
		
	}	
}
