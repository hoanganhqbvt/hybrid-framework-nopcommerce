package pageUIs.jQuery.uploadFile;

import java.io.File;

public class BasePageJQueryUploadFileUI {
public static final String ADDRESS_LINK = "xpath=//li[contains(@class,'customer-addresses')]/a";
public static final String CUSTOMER_INFO_LINK = "XPATH=//li[contains(@class,'customer-info')]/a";
public static final String REWARD_POINT_LINK = "XPath=//li[contains(@class,'reward-points')]/a";
public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
public static final String MY_PRODUCT_REVIEW_LINK = "Xpath=//li[contains(@class,'customer-reviews')]/a";
public static final String PROJECT_PATH = System.getProperty("user.dir");
public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles";
}
