package pageUIs.nopCommerce.user;

public class UserComputerPageUI {
	public static final String SORT_BY_DROPDOWN = "xpath=//select[@id='products-orderby']";
	public static final String PRODUCTS_PRICE = "xpath=//div[@class='item-grid']//span[@class='price actual-price']";
	public static final String DYNAMIC_PRODUCTS_BY_TITLE = "xpath=//h2[@class='product-title']/a[text()='%s']";
	public static final String NUMBER_PRODUCTS_DISPLAYED_PER_PAGE_DROPDOWN = "css=select#products-pagesize";
	public static final String NUMBER_PAGE_OF_PRODUCT = "xpath=//li[@class='next-page']/preceding-sibling::li";
	public static final String NUMBER_PRODUCT_ON_A_DYNAMIC_PAGE = "xpath=//span[text()='%s']/ancestor::div[@class='pager']/preceding-sibling::div//div[@class='item-box']";
	public static final String NUMBER_PRODUCT_ON_FIRST_PAGE = "xpath=//span[text()='1']/ancestor::div[@class='pager']/preceding-sibling::div//div[@class='item-box']";
	public static final String NEXT_PAGE_ICON = "css=li.next-page a";
	public static final String PREVIOUS_PAGE_ICON = "css=li.previous-page a";
	public static final String NUMBER_PRODUCTS_IF_ONLY_ONE_PAGE = "css=div.item-box";
	public static final String PAGING_LINE = "css=div.pager";
	public static final String PAGE_NUMBER_OF_CURRENT_PAGE = "css=div.pager span";
	public static final String SELECT_PAGE_BY_NUMBER = "xpath=//a[text()='%s']";
}

