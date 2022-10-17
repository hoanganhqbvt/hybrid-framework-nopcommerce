package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;

import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;

public class Search_Advanced_Search extends BaseTest{
	WebDriver driver;
	 private UserHomePageObject userHomePage;
	 private UserRegisterPageObject registerPage;
	 private UserSearchPageObject userSearchPage;
	 String invalidEmail = "abc@123@abc";
	 int fakeNumber = generateFakeNumber();
	 String validEmail = "automail" + fakeNumber + "@gmail.com", firstName = "Automation", lastName = "Testing", gender = "Male",
			password = "Abc@123456", confirmPassword = password, day = "20", month = "October", year = "1990";
	String notExistData = "Macbook Pro 2050";
			
		@Parameters({"browser", "userURL"})
		@BeforeClass
		public void beforeClass(String browserName, String userURL) {
			log.info("Pre-condition - Step 01: Open browser");
			driver = getBrowserDriver(browserName, userURL);
			userHomePage = PageGeneratorManager.getUserHomePage(driver);
			
			log.info("Pre-condition - Step 02: Click to Register link");
			userHomePage.clickToPageLinkByName("Register");
			registerPage = PageGeneratorManager.getUserRegisterPage(driver);
			
			log.info("Pre-condition - Step 03: Select gender radio button that is Male");
			registerPage.selectGenderRadioButton("Male", gender);
			
			log.info("Pre-condition - Step 04: Input to Firstname textbox: " + firstName);
			registerPage.inputToDynamicTextboxByID("FirstName", firstName);
			
			log.info("Pre-condition - Step 05: Input to Lastname textbox: " + lastName);
			registerPage.inputToDynamicTextboxByID("LastName", lastName);
			
			log.info("Pre-condition - Step 06: Select a day of birth in Day dropdown list that has value: " + day);
			registerPage.selectDOBInDropdownListByName("DateOfBirthDay", day);
			
			log.info("Pre-condition - Step 07: Select a month of birth in Month dropdown list that has value: " + month);
			registerPage.selectDOBInDropdownListByName("DateOfBirthMonth", month);
			
			log.info("Pre-condition - Step 08: Select a year of birth in Year dropdown list that has value: " + year);
			registerPage.selectDOBInDropdownListByName("DateOfBirthYear", year);
			
			log.info("Pre-condition - Step 09: Input to Email textbox: " + validEmail);
			registerPage.inputToDynamicTextboxByID("Email", validEmail);
			
			log.info("Pre-condition - Step 10: Input to Password textbox: " + password);
			registerPage.inputToDynamicTextboxByID("Password", password);
			
			log.info("Pre-condition - Step 11: Input to ConfirmPassword textbox: " + password);
			registerPage.inputToDynamicTextboxByID("ConfirmPassword", confirmPassword);
			
			log.info("Pre-condition - Step 12: Click to Register button");
			registerPage.clickToRegisterButton();
			
			log.info("Pre-condition - Step 13: Verify success registered message displayed correctly with content is 'Your registration completed'");
			verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");						
}
		
		@Test
		public void Search_01_Search_With_Emty_Data() {
			log.info("Search_01_Search_With_Emty_Data - Step 01: Click on Search link at page bottom");
			registerPage.openLinkPageAtHomePageByName(driver, "Search");
			userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
			
			log.info("Search_01_Search_With_Emty_Data - Step 02: Click on Search button with empty data search");
			userSearchPage.clickToSearchButton();
			
			log.info("Search_01_Search_With_Emty_Data - Step 03: VeriverifyEquals(userSearchPage.getWarningMessageDisplayedWhenSearchingWithEmptyData()fy the warning message displayed correctly with content is 'Search term minimum length is 3 characters'");
			verifyEquals(userSearchPage.getWarningMessageDisplayedWhenSearchingWithEmptyData(), "Search term minimum length is 3 characters");						
		}
		
		@Test
		public void Search_02_Search_With_Not_Existing_Data() {
			log.info("Search_02_Search_With_Not_Existing_Data - Step 01: Input not existing data to Search Keyword textbox");
			userSearchPage.inputToSearchKeywordTextbox(notExistData);
		
			log.info("Search_02_Search_With_Not_Existing_Data - Step 02: Click on Search button");
			userSearchPage.clickToSearchButton();
			
			log.info("earch_02_Search_With_Not_Existing_Data - Step 03: Verify the result message displayed with content is 'No products were found that matched your criteria.'");
			verifyEquals(userSearchPage.getResultMessageDisplayedWhenSearchingWithNotExistData(),"No products were found that matched your criteria.");
		}
		
		@Test
		public void Search_03_Search_With_Product_Name_Comparative() {
			
			log.info("Search_03_Search_With_Product_Name_Comparative - Step 01: Input to Search Keyword textbox");
			userSearchPage.inputToSearchKeywordTextbox("Lenovo");
			
			log.info("Search_03_Search_With_Product_Name_Comparative - Step 02: Click on Search button");
			userSearchPage.clickToSearchButton();
			
			log.info("Search_03_Search_With_Product_Name_Comparative - Step 03: Verify all searched products' title contain the search keyword: 'Lenovo'");
			verifyTrue(userSearchPage.isAllSearchedProductTitleContainSearchKeyword("Lenovo"));
			
		}
		
			@Test
			public void Search_04_Search_With_Product_Name_Absolutly() {
				log.info("Search_Advanced_Search_04_Search_With_Product_Name_Absolutly - Step 01: Input to Search Keyword textbox");
				userSearchPage.inputToSearchKeywordTextbox("Lenovo Thinkpad X1 Carbon Laptop");
				
				log.info("Search_Advanced_Search_04_Search_With_Product_Name_Absolutly - Step 02: Click on Search button");
				userSearchPage.clickToSearchButton();
				
				log.info("Search_Advanced_Search_04_Search_With_Product_Name_Absolutly - Step 03: Verify searched product's title equal the search keyword: 'Lenovo Thinkpad X1 Carbon Laptop'");
				verifyTrue(userSearchPage.isSearchedProductTitleEqualSearchKeyword("Lenovo Thinkpad X1 Carbon Laptop"));				
		}
			
			@Test
			public void Search_05_Search_Advanced_With_Parent_Category() {
				log.info("Search_05_Search_Advanced_With_Parent_Category - Step 01: Input to Search Keyword textbox");
				userSearchPage.inputToSearchKeywordTextbox("Apple MacBook Pro");
				
				log.info("Search_05_Search_Advanced_With_Parent_Category - Step 02: Check the Advanced search checkbox");
				userSearchPage.selectCheckboxByLabel("Advanced search");
				
				log.info("Search_05_Search_Advanced_With_Parent_Category - Step 03: Select category in dropdown list");
				userSearchPage.selectCategoryInDropdownList("Computers");
				
				log.info("Search_05_Search_Advanced_With_Parent_Category - Step 04: Click on Search button");
				userSearchPage.clickToSearchButton();
				
				log.info("Search_05_Search_Advanced_With_Parent_Category - Step 05: Verify the result message displayed with correct content that is 'No products were found that matched your criteria.'");
				verifyEquals(userSearchPage.getResultMessageDisplayedWhenSearchingWithNotExistData(),"No products were found that matched your criteria.");

			}
			
			@Test
			public void Search_06_Search_Advanced_With_Sub_Category() {
				log.info("Search_06_Search_Advanced_With_Sub_Category - Step 01: Input to Search Keyword textbox");
				userSearchPage.inputToSearchKeywordTextbox("Apple MacBook Pro");
				
				log.info("Search_06_Search_Advanced_With_Sub_Category - Step 02: Check the Advanced search checkbox");
				userSearchPage.selectCheckboxByLabel("Advanced search");
				
				log.info("Search_06_Search_Advanced_With_Sub_Category - Step 03: Select category in dropdown list");
				userSearchPage.selectCategoryInDropdownList("Computers");
				
				log.info("Search_06_Search_Advanced_With_Sub_Category - Step 04: Check the Auto search sub category checkbox");
				userSearchPage.selectCheckboxByLabel("Automatically search sub categories");
				
				log.info("Search_06_Search_Advanced_With_Sub_Category - Step 05: Click on Search button");
				userSearchPage.clickToSearchButton();
				
				log.info("Search_06_Search_Advanced_With_Sub_Category - Step 06: Verify a product matched criteria");
				verifyTrue(userSearchPage.isAllSearchedProductTitleContainSearchKeyword("Apple MacBook Pro"));			
			}		
			@Test
			public void Search_07_Search_Advanced_With_Incorrect_Manufacturer() {
				log.info("Search_07_Search_Advanced_With_Incorrect_Manufacturer - Step 01: Input to Search Keyword textbox");
				userSearchPage.inputToSearchKeywordTextbox("Apple MacBook Pro");
				
				log.info("Search_07_Search_Advanced_With_Incorrect_Manufacturer - Step 02: Check the Advanced search checkbox");
				userSearchPage.selectCheckboxByLabel("Advanced search");
				
				log.info("Search_07_Search_Advanced_With_Incorrect_Manufacturer - Step 03: Select category in dropdown list");
				userSearchPage.selectCategoryInDropdownList("Computers");
				
				log.info("Search_07_Search_Advanced_With_Incorrect_Manufacturer - Step 04: Check the Auto search sub category checkbox");
				userSearchPage.selectCheckboxByLabel("Automatically search sub categories");
				
				log.info("Search_07_Search_Advanced_With_Incorrect_Manufacturer - Step 05: Select a manufacturer in dropdown list");
				userSearchPage.selectManufactorerInDropdownList("HP");
				
				log.info("Search_07_Search_Advanced_With_Incorrect_Manufacturer - Step 06: Click on Search button");
				userSearchPage.clickToSearchButton();
				
				log.info("Search_07_Search_Advanced_With_Incorrect_Manufacturer - Step 07: Verify the result message displayed with correct content that is 'No products were found that matched your criteria.'");
				verifyEquals(userSearchPage.getResultMessageDisplayedWhenSearchingWithNotExistData(),"No products were found that matched your criteria.");	
			}
			
			@Test
			public void Search_08_Search_Advanced_With_Correct_Manufacturer() {
				log.info("Search_08_Search_Advanced_With_Correct_Manufacturer - Step 01: Input to Search Keyword textbox");
				userSearchPage.inputToSearchKeywordTextbox("Apple MacBook Pro");
				
				log.info("Search_08_Search_Advanced_With_Correct_Manufacturer - Step 02: Check the Advanced search checkbox");
				userSearchPage.selectCheckboxByLabel("Advanced search");
				
				log.info("Search_08_Search_Advanced_With_Correct_Manufacturer - Step 03: Select category in dropdown list");
				userSearchPage.selectCategoryInDropdownList("Computers");
				
				log.info("Search_08_Search_Advanced_With_Correct_Manufacturer - Step 04: Check the Auto search sub category checkbox");
				userSearchPage.selectCheckboxByLabel("Automatically search sub categories");
				
				log.info("Search_08_Search_Advanced_With_Correct_Manufacturer - Step 05: Select a manufacturer in dropdown list");
				userSearchPage.selectManufactorerInDropdownList("Apple");
				
				log.info("Search_08_Search_Advanced_With_Correct_Manufacturer - Step 06: Click on Search button");
				userSearchPage.clickToSearchButton();
				
				log.info("Search_08_Search_Advanced_With_Correct_Manufacturer - Step 07: Verify a product matched criteria");
				verifyTrue(userSearchPage.isAllSearchedProductTitleContainSearchKeyword("Apple MacBook Pro"));
			}
		@AfterClass(alwaysRun = true)
		public void afterClass() {
		driver.quit();
}
}