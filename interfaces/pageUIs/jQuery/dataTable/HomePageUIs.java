package pageUIs.jQuery.dataTable;

public class HomePageUIs {
	
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String ACTIVED_PAGE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String TOTAL_PAGINATION = "css=li.qgrd-pagination-page";
	public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String ALL_ROW_COUNTRY_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='country']";
	
	// Index của cái cột mà mình cần ednter/ click/ select vào
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/td[text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String LOAD_BUTTON = "css=button#btnLoad";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tr[%s]/td[%s]/input[@type='checkbox']";
	public static final String ICON_BY_TITLE_AND_BY_ROW_INDEX = "xpath=//tr[%s]/td/button[@title='%s']";
}
