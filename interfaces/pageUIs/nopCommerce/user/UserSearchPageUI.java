package pageUIs.nopCommerce.user;

public class UserSearchPageUI {
	public static final String WARNING_MESSAGE_WHEN_SEARCHING_WITH_EMPTY_DATA = "css=div.warning";
	public static final String SEARCH_BUTTON = "xpath=//div[@class='buttons']/button[text()='Search']";
	public static final String SEARCH_KEYWORD_TEXTBOX = "xpath=//label[text()='Search keyword:']/following-sibling::input";
	public static final String RESULT_MESSAGE_WHEN_SEARCHING_WITH_NOT_EXIST_DATA = "css=div.no-result";
	public static final String SEARCHED_PRODUCT_TITLE = "css=div.search-results h2.product-title a";
	public static final String ADVANCED_SEARCH_CHECKBOX = "xpath=//input[@id='advs']";
	public static final String CATEGORY_DROPDOWN_LIST = "xpath=//select[@id='cid']";
	public static final String MANUFACTURER_DROPDOWN_LIST = "xpath=//select[@id='mid']";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	
}
