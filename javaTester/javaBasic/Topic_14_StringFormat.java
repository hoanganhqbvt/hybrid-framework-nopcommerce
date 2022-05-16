package javaBasic;

public class Topic_14_StringFormat {
	
	// 14 page = 14 biến locator
	public static  String ADDRESS_LINK = "//li[contains(@class,'customer-addresses')]/a";
	public static  String CUSTOMER_INFO_LINK = "//li[contains(@class,'customer-info')]/a";
	public static  String REWARD_POINT_LINK = "//li[contains(@class,'reward-points')]/a";
	public static  String MY_PRODUCT_REVIEW_LINK = "//li[contains(@class,'customer-reviews')]/a";
	
	// 1 biến cho cả 14 page hoặc n page (format giống nhau chỉ khác nhau bởi tên page)
	public static String DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME = "//li[contains(@class,'%s')]/a";
	
	// 1 locator để đại diện cho các page (header/ sidebar/ footer)
	
		public static void main(String[] args) {
		clickToSideBarLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "customer-info");
		clickToSideBarLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "customer-addresses");
		clickToSideBarLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "reward-points");
		clickToSideBarLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME,"customer-reviews");
		
	}
		
	public static void clickToSideBarLink(String locator) {
		System.out.println("Click to: " +locator);
	}
	
	// 1 tham số động
//	public static void clickToSideBarLink(String dynamicLocator, String pageName) {
//		// dynamicLocator = "//li[contains(@class,'%s')]/a"
//		// pageName = Customer Info
//		String locator = String.format(dynamicLocator, pageName);
//		System.out.println("Click to: " + locator);
// }
	// n tham số động
	public static void clickToSideBarLink(String dynamicLocator, String... params) {
		// dynamicLocator = "//li[contains(@class,'%s')]/a"
		// pageName = Customer Info
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Click to: " + locator);
}
}
