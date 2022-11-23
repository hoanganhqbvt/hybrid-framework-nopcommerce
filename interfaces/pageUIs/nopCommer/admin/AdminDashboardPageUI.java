package pageUIs.nopCommer.admin;

public class AdminDashboardPageUI {
	public static final String DASHBOARD_HEADER = "xpath=//h1[contains(text(),'Dashboard')]";
	public static final String DYNAMIC_MENU_LINK_BY_CLASS = "xpath=//i[@class='%s']";
	public static final String DYNAMIC_SUB_PAGE_BY_NAME = "xpath=//li[@class='nav-item has-treeview menu-open']//p[text()='%s']/ancestor::a";
	
}
