package com.nopcommerce.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminCustomerPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductPageObject;

public class Admin extends BaseTest{
	String adminUser = "admin@yourstore.com";
	String adminPassword = "admin";
	WebDriver driver;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminProductPageObject adminProductPage;
	private AdminCustomerPageObject adminCustomerPage;
	String searchProduct = "Lenovo IdeaCentre 600 All-in-One PC";
	String category = "Computers", childCategory = "Computers >> Desktops", allCategory = "All", manufacturer = "Apple";
	String sku = "LE_IC_600";
	String email = "automation" + getRandomNumberByDateTime() + "@testmail.com", password = "Abc@1234", firstname = "Automation", lastname = "FC";
	String gender = "Male", dob = "12/20/1990", companyName = "ACB", newLetter = "Test store 2", vendor = "Vendor 1", adminComment = "I am admin.";
	String customerRole = "Guests", defaultCustomerRole = "Registered";
	
	@Parameters({"browser", "adminURL"})
	@BeforeClass
	public void beforeClass(String browserName, String adminURL) {
		log.info("Pre-condition - Step 01: Open admin URL");
		driver = getBrowserDriver(browserName, adminURL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-condition - Step 02: Input to Email textbox");
		adminLoginPage.inputToUsernameTextbox(adminUser);
		
		log.info("Pre-condition - Step 03: Input to Password textbox");
		adminLoginPage.inputToPasswordTextbox(adminPassword);
		
		log.info("Pre-condition - Step 04: Click on LOGIN button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
		
}
	@Test (priority = 1)
	public void Admin_01_Search_With_Product_Name() {
		log.info("Admin_01_Search_With_Product_Name - Step 01: Click on Catalog menu");
		adminDashboardPage.clickToMenuLinkByClass("nav-icon fas fa-book");
		
		log.info("Admin_01_Search_With_Product_Name - Step 02: Click on Product link page");
		adminDashboardPage.clickToSubPageByName(" Products");
		adminProductPage = PageGeneratorManager.getadminProductPage(driver);
		
		log.info("Admin_01_Search_With_Product_Name - Step 03: Input to search product textbox: " + searchProduct);
		adminProductPage.inputToTextboxByID(searchProduct, "SearchProductName");
		
		log.info("Admin_01_Search_With_Product_Name - Step 04: Click on SEARCH button");
		adminProductPage.clickToSearchButton();
		
		log.info("Admin_01_Search_With_Product_Name - Step 05: Verify that only one searched product displayed");
		verifyEquals(adminProductPage.getNumberOfProductMatched(),1);
		
		log.info("Admin_01_Search_With_Product_Name - Step 06: Verify searched product matches searched condition");		
		verifyEquals(adminProductPage.getSearchedProductInfoInTable("1", "Product name"), searchProduct);
	}
	@Test (priority = 2)
	public void Admin_02_Search_With_Product_Name_Category_Without_Subcategory() {	
		log.info("Admin_02_Search_With_Product_Name_Category_Without_Subcategory - Step 01: Input to Product name textbox");
		adminProductPage.inputToTextboxByID(searchProduct, "SearchProductName");
		
		log.info("Admin_02_Search_With_Product_Name_Category_Without_Subcategory - Step 02: Select category in dropdown list: " + category);
		adminProductPage.selectOptionInDropdownListByName("SearchCategoryId", category);
		
		log.info("Admin_02_Search_With_Product_Name_Category_Without_Subcategory - Step 03: Uncheck Search subcategories checkbox");
		adminProductPage.uncheckSearchSubcategoryCheckbox();
				
		log.info("Admin_02_Search_With_Product_Name_Category_Without_Subcategory - Step 04: Click on SEARCH button");
		adminProductPage.clickToSearchButton();
		
		log.info("Admin_02_Search_With_Product_Name_Category_Without_Subcategory - Step 05: Verify message 'No data available in table' displayed");
		verifyTrue(adminProductPage.isNoDataAvailableMessageDisplayed());		
	}
	@Test (priority = 3)
	public void Admin_03_Search_With_Product_Name_Category_Wit_Subcategory() {	
		log.info("Admin_03_Search_With_Product_Name_Category_Wit_Subcategory - Step 01: Input to Product name textbox");
		adminProductPage.inputToTextboxByID(searchProduct, "SearchProductName");
		
		log.info("Admin_03_Search_With_Product_Name_Category_Wit_Subcategory - Step 02: Select category in dropdown list: " + category);
		adminProductPage.selectOptionInDropdownListByName("SearchCategoryId", category);
		
		log.info("Admin_03_Search_With_Product_Name_Category_Wit_Subcategory - Step 03: Check Search subcategories checkbox");
		adminProductPage.checkSearchSubcategoryCheckbox();
				
		log.info("Admin_03_Search_With_Product_Name_Category_Wit_Subcategory - Step 04: Click on SEARCH button");
		adminProductPage.clickToSearchButton();
		
		log.info("Admin_03_Search_With_Product_Name_Category_Wit_Subcategory - Step 05: Verify that only one searched product displayed");
		verifyEquals(adminProductPage.getNumberOfProductMatched(),1);
		
		log.info("Admin_03_Search_With_Product_Name_Category_Wit_Subcategory - Step 06: Verify searched product matches searched condition");		
		verifyEquals(adminProductPage.getSearchedProductInfoInTable("1", "Product name"), searchProduct);		
	}
	@Test (priority = 4)
	public void Admin_04_Search_With_Product_Name_And_Child_Category() {	
		log.info("Admin_04_Search_With_Product_Name_And_Child_Category - Step 01: Input to Product name textbox");
		adminProductPage.inputToTextboxByID(searchProduct, "SearchProductName");
		
		log.info("Admin_04_Search_With_Product_Name_And_Child_Category - Step 02: Select child category in dropdown list: " + childCategory);
		adminProductPage.selectOptionInDropdownListByName("SearchCategoryId", childCategory);
		
		log.info("Admin_04_Search_With_Product_Name_And_Child_Category - Step 03: Uncheck Search subcategories checkbox");
		adminProductPage.uncheckSearchSubcategoryCheckbox();
				
		log.info("Admin_04_Search_With_Product_Name_And_Child_Category - Step 04: Click on SEARCH button");
		adminProductPage.clickToSearchButton();
		
		log.info("Admin_04_Search_With_Product_Name_And_Child_Category- Step 05: Verify that only one searched product displayed");
		verifyEquals(adminProductPage.getNumberOfProductMatched(),1);
		
		log.info("Admin_04_Search_With_Product_Name_And_Child_Category - Step 06: Verify searched product matches searched condition");		
		verifyEquals(adminProductPage.getSearchedProductInfoInTable("1", "Product name"), searchProduct);		
	}
	@Test (priority = 5)
	public void Admin_05_Search_With_Product_Name_And_Manufacturer() {	
		log.info("Admin_05_Search_With_Product_Name_And_Manufacturer - Step 01: Input to Product name textbox");
		adminProductPage.inputToTextboxByID(searchProduct, "SearchProductName");
		
		log.info("Admin_05_Search_With_Product_Name_And_Manufacturer - Step 02: Select category in dropdown list: " + allCategory);
		adminProductPage.selectOptionInDropdownListByName("SearchCategoryId", allCategory);
		
		log.info("Admin_05_Search_With_Product_Name_And_Manufacturer - Step 03: Uncheck Search subcategories checkbox");
		adminProductPage.uncheckSearchSubcategoryCheckbox();
				
		log.info("Admin_05_Search_With_Product_Name_And_Manufacturer - Step 04: Click on SEARCH button");
		adminProductPage.selectOptionInDropdownListByName("SearchManufacturerId", manufacturer);
		
		log.info("Admin_05_Search_With_Product_Name_And_Manufacturer - Step 05: Click on SEARCH button");
		adminProductPage.clickToSearchButton();
		
		log.info("Admin_05_Search_With_Product_Name_And_Manufacturer - Step 06: Verify message 'No data available in table' displayed");
		verifyTrue(adminProductPage.isNoDataAvailableMessageDisplayed());	
		
		log.info("Admin_05_Search_With_Product_Name_And_Manufacturer - Step 07: Refresh the page");
		adminProductPage.refreshCurentPage(driver);
	}
	
	@Test (priority = 6)
	public void Admin_06_Go_Directly_To_Product_SKU() {
		log.info("Admin_06_Go_Directly_To_Product_SKU - Step 01: Input to SKU textbox");
		adminProductPage.inputToTextboxByID(sku, "GoDirectlyToSku");
		
		log.info("Admin_06_Go_Directly_To_Product_SKU - Step 02: Click on Go to product SKU button");
		adminProductPage.clickToGoToSKUbutton();
		
		log.info("Admin_06_Go_Directly_To_Product_SKU - Step 03: Verify title product displayed correctly on Product detail page");
		verifyEquals(adminProductPage.getProductValueDisplayedOnProductDetailPage("Product name", "value"), searchProduct);
		
		log.info("Admin_06_Go_Directly_To_Product_SKU - Step 03: Verify SKU product displayed correctly on Product detail page");
		verifyEquals(adminProductPage.getProductValueDisplayedOnProductDetailPage("SKU", "value"), sku);
		
		log.info("Admin_06_Go_Directly_To_Product_SKU - Step 03: Verify title product displayed correctly on Product detail page");
		verifyEquals(adminProductPage.getProductCategoryOnDetailPage(), childCategory);		
	}
	
	@Test (priority = 7)
	public void Admin_07_Create_New_Customer() {
		log.info("Admin_07_Create_New_Customer - Step 01: Click on Customer menu");		
		adminDashboardPage.clickToMenuLinkByClass("nav-icon far fa-user");
		
		log.info("Admin_07_Create_New_Customer - Step 02: Click on Customer link page");
		adminDashboardPage.clickToSubPageByName(" Customers");
		adminCustomerPage = PageGeneratorManager.getadminCustomerPage(driver);
		
		log.info("Admin_07_Create_New_Customer - Step 03: Click on Add new button");
		adminCustomerPage.clickToAddNewButton();
		
		log.info("Admin_07_Create_New_Customer - Step 04: Input to email textbox: " + email);
		adminCustomerPage.inputToTextboxByID("Email", email);
		
		log.info("Admin_07_Create_New_Customer - Step 05: Input to password textbox: " + password);
		adminCustomerPage.inputToTextboxByID("Password", password);
		
		log.info("Admin_07_Create_New_Customer - Step 06: Input to firstname textbox: " + firstname);
		adminCustomerPage.inputToTextboxByID("FirstName", firstname);
		
		log.info("Admin_07_Create_New_Customer - Step 07: Input to lastname textbox: " + lastname);
		adminCustomerPage.inputToTextboxByID("LastName", lastname);
		
		log.info("Admin_07_Create_New_Customer - Step 08: Select gender radio button: " + gender);
		adminCustomerPage.selectGenderByID("Gender_Male");
		
		log.info("Admin_07_Create_New_Customer - Step 09: Input to DOB textbox: " + dob);
		adminCustomerPage.inputToTextboxByID("DateOfBirth", dob);
		
		log.info("Admin_07_Create_New_Customer - Step 10: Input to Company Name textbox: " + companyName);
		adminCustomerPage.inputToTextboxByID("Company", companyName);
		
		log.info("Admin_07_Create_New_Customer - Step 11: Check tax exempt checkbox");
		adminCustomerPage.checkToCheckboxByID("IsTaxExempt");
		
		log.info("Admin_07_Create_New_Customer - Step 12: Select New letter in dropdown list: " + newLetter);
		adminCustomerPage.selectNewLetterInDropdown(newLetter);
		
		log.info("Admin_07_Create_New_Customer - Step 13: Deselect default Customer role in dropdown list: " + defaultCustomerRole);
		adminCustomerPage.selectCustomerRoleInDropdown(defaultCustomerRole);
		
		log.info("Admin_07_Create_New_Customer - Step 14: Select Customer role in dropdown list: " + customerRole);
		adminCustomerPage.selectCustomerRoleInDropdown(customerRole);
		
		log.info("Admin_07_Create_New_Customer - Step 15: Select Vendor in dropdown list: " + vendor);
		adminCustomerPage.selectVendorInDropdown(vendor);
		
		log.info("Admin_07_Create_New_Customer - Step 16: Check Active checkbox");
		adminCustomerPage.checkToCheckboxByID("Active");
		
		log.info("Admin_07_Create_New_Customer - Step 17: Input to Admin comment text area: " + adminComment);
		adminCustomerPage.inputToAdminCommentArea(adminComment);
		
		log.info("Admin_07_Create_New_Customer - Step 18: Click on Save button");
		adminCustomerPage.clickToSaveButton();
		
		log.info("Admin_07_Create_New_Customer - Step 19: Get success message displayed");
		verifyEquals(adminCustomerPage.getAddedCustomerMessageResult(), "The new customer has been added successfully.");
		
		log.info("Admin_07_Create_New_Customer - Step 20: Close the popup result message");
		adminCustomerPage.closePopupResultMessage();
		
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	
}