package pageUIs.nopCommerce.user;

public class UserProductReviewPageUI {
	public static final String DYNAMIC_ADD_YOUR_REVIEW_LINK_BY_TEXT = "xpath=//a[text()='%s']";
	public static final String SUBMIT_REVIEW_BUTTON = "xpath=//button[text()='Submit review']";
	public static final String DYNAMIC_RATING_OPTION_BY_VALUE = "xpath=//div[@class='rating-options']/input[@value='%s']";
	public static final String REVIEW_TEXTBOX_TITLE= "xpath=//input[@id='AddProductReview_Title']";
	public static final String REVIEW_TEXT_AREA= "xpath=//textarea[@id='AddProductReview_ReviewText']";
	public static final String SUCCESS_ADDED_PRODUCT_REVIEW_MESSAGE = "xpath=//div[@class='result' and contains(text(),'Product review is successfully added.')]";
	public static final String REVIEW_TITLE_IN_MY_PRODUCT_REVIEW_PAGE = "xpath=//div[@class='review-title']/strong";
	public static final String REVIEW_CONTENT_IN_MY_PRODUCT_REVIEW_PAGE = "xpath=//div[@class='review-text']";
	
}
