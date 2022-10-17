package com.nopcommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserComputerPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Sort_Display_Paging extends BaseTest{
	WebDriver driver;
	 private UserHomePageObject userHomePage;
	 private UserRegisterPageObject registerPage;
	 private UserComputerPageObject userComputerPage;
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
			
		@Test (priority = 1)
		public void Sort_01_Sort_With_Price_Low_To_High() {
			log.info("Sort_01_Sort_With_Price_Low_To_High - Step 01: Select submenu in Computers menu");
			userComputerPage = registerPage.selectASubmenuByName("Computers ", "Notebooks ");
			
			log.info("Sort_01_Sort_With_Price_Low_To_High - Step 02: Get product' price list before filter price");
			List<Double> beforeFilterPriceList = userComputerPage.getProductPriceList();
			
			log.info("Sort_01_Sort_With_Price_Low_To_High - Step 03: Select sort by Price: Low to High");
			userComputerPage.selectSortByOptionInDropdownList("Price: Low to High");
			
			log.info("Sort_01_Sort_With_Price_Low_To_High - Step 04: Get product' price list after filter price");
			List<Double> afterFilterPriceList = userComputerPage.getProductPriceList();
			
			log.info("Sort_01_Sort_With_Price_Low_To_High - Step 05: Verify products are sorted correctly by Price: Low to High");
			verifyTrue(userComputerPage.isSortedPriceLowToHighCorrectly(beforeFilterPriceList, afterFilterPriceList));			
			
		}
		
		@Test (priority = 2)
		public void Sort_02_Sort_With_Price_High_To_Low() {
			log.info("Sort_02_Sort_With_Price_High_To_Low - Step 01: Select submenu in Computers menu");
			userComputerPage = registerPage.selectASubmenuByName("Computers ", "Notebooks ");
			
			log.info("Sort_02_Sort_With_Price_High_To_Low - Step 02: Get product' price list before filter price");
			List<Double> beforeFilterPriceList = userComputerPage.getProductPriceList();
			
			log.info("Sort_02_Sort_With_Price_High_To_Low - Step 03: Select sort by Price: High to Low");
			userComputerPage.selectSortByOptionInDropdownList("Price: High to Low");
			
			log.info("Sort_02_Sort_With_Price_High_To_Low - Step 04: Get product' price list after filter price");
			List<Double> afterFilterPriceList = userComputerPage.getProductPriceList();
			
			log.info("Sort_02_Sort_With_Price_High_To_Low - Step 05: Verify products are sorted correctly by Price: High to Low");
			verifyTrue(userComputerPage.isSortedPriceHighToLowCorrectly(beforeFilterPriceList, afterFilterPriceList));									
}
		@Test (priority = 3)
		public void Display_03_Display_3_Products_Per_Page() {
			log.info("Display_03_Display_3_Products_Per_Page - Step 01: Select page size option is 3");
			userComputerPage.selectPageSizeOption("3");
			
			log.info("Display_03_Display_3_Products_Per_Page - Step 02: Verify number of product displayed on a page");
			verifyTrue(userComputerPage.isNumberProductDisplayedCorrect(3));
			
			log.info("Display_03_Display_3_Products_Per_Page - Step 03: Select the first page '1'");
			userComputerPage.selectPageByNumber("1");
			
			log.info("Display_03_Display_3_Products_Per_Page - Step 04: Verify the Next page icon will displays if User are on 1 page to on previous last pages");
			verifyTrue(userComputerPage.isNextOrPreviousPageIconDisplayed());
			
			log.info("Display_03_Display_3_Products_Per_Page - Step 05: Select page number '2' - that the last page");
			userComputerPage.selectPageByNumber("2");
			
			log.info("Display_03_Display_3_Products_Per_Page - Step 06: Verify the Previous page icon will displays if User are on the last pages");
			verifyTrue(userComputerPage.isNextOrPreviousPageIconDisplayed());
		}
		
		@Test (priority = 4)
		public void Display_04_Display_6_Products_Per_Page() {
			log.info("Display_04_Display_6_Products_Per_Page - Step 01: Select page size option is 6");
			userComputerPage.selectPageSizeOption("6");
			
			log.info("Display_04_Display_6_Products_Per_Page - Step 02: Verify number of product displayed on a page");
			verifyTrue(userComputerPage.isNumberProductDisplayedCorrect(6));
			
			log.info("Display_04_Display_6_Products_Per_Page - Step 03: Verify the paging is not displayed if page size = 6");
			verifyTrue(userComputerPage.isPagingIsNotDisplayed());						
		}
		
		@Test (priority = 5)
		public void Display_05_Display_9_Products_Per_Page() {
			log.info("Display_05_Display_9_Products_Per_Page - Step 01: Select page size option is 9");
			userComputerPage.selectPageSizeOption("9");
			
			log.info("Display_05_Display_9_Products_Per_Page - Step 02: Verify number of product displayed on a page");
			verifyTrue(userComputerPage.isNumberProductDisplayedCorrect(9));
			
			log.info("Display_05_Display_9_Products_Per_Page - Step 03: Verify the paging is not displayed if page size = 9");
			verifyTrue(userComputerPage.isPagingIsNotDisplayed());
		}
}