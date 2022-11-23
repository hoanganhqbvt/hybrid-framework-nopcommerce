package pageUIs.nopCommer.admin;

public class AdminProductPageUI {
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_LIST_BY_ID = "xpath=//select[@id='%s']";
	public static final String SEARCH_BUTTON = "css=button#search-products";
	public static final String NUMBER_SEARCH_PRODUCT_LINE_IN_TABLE = "xpath=//div[@class='dataTables_scrollHead']/following-sibling::div//tbody/tr";
	public static final String COLUMN_NUMBER_BY_TITLE = "xpath=//div[@class='dataTables_scrollHeadInner']//th[text()='%s']/preceding-sibling::th";
	public static final String CELL_INDEX_BY_ROW_NUMBER_AND_COLUM_NUMBER = "xpath=//tbody/tr[%s]/td[%s]";
	public static final String SEARCH_SUBCATEGORIES_CHECKBOX = "css=input#SearchIncludeSubCategories";
	public static final String NO_DATA_AVAILABLE_MESSAGE = "xpath=//td[text()='No data available in table']";
	public static final String GO_TO_PRODUCT_SKU_BUTTON = "css=button#go-to-product-by-sku";
	public static final String DYNAMIC_PRODUCT_VALUE_ON_DETAIL_PAGE_BY_LABEL = "xpath=//label[text()='%s']/ancestor::div[@class='col-md-3']/following-sibling::div//input";
	public static final String PRODUCT_CATEGORY_ON_DETAIL_PAGE = "xpath=//ul[@id='SelectedCategoryIds_taglist']//span[@class='k-select']/preceding-sibling::span";
	
}
