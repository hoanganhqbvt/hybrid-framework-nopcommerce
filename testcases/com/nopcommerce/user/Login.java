package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;


public class Login extends BaseTest{
	 WebDriver driver;
	 private UserHomePageObject userHomePage;
	 private UserLoginPageObject loginPage;
	 String invalidEmail = "abc@123@abc";
	 int fakeNumber = generateFakeNumber();
	 String validEmail = "auto" + fakeNumber + "@gmail.com", firstName = "Automation", lastName = "Testing", gender = "Male",
			password = "Abc@123456", confirmPassword = password, day = "20", month = "October", year = "1990";
	 String existingEmail = "auto3888@gmail.com";
	 String unregisteredEmail = "hta@gmai.com";
	 
		@Parameters({"browser", "userURL"})
		@BeforeClass
		public void beforeClass(String browserName, String userURL) {
			log.info("Pre-condition - Step 01: Open browser");
			driver = getBrowserDriver(browserName, userURL);
			userHomePage = PageGeneratorManager.getUserHomePage(driver);
			
			log.info("Pre-condition - Step 02: Click to Login link menu");
			userHomePage.openLinkPageAtHomePageByName(driver, "Log in");
			loginPage = PageGeneratorManager.getUserLoginPage(driver);
		}
		@Test
		public void Login_01_Login_With_Empty_Data() {
			log.info("Login_01_Login_With_Empty_Data - Step 01: Click to Login button without input data");
			loginPage.clickToLoginButton();
			
			log.info("Login_01_Login_With_Empty_Data - Step 02: Verify the error message displayed with the correct content is: 'Please enter your email'");
			verifyEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");			
		}
		
		@Test
		public void Login_02_Login_With_Invalid_Email() {
			log.info("Login_02_Login_With_Invalid_Email - Step 01: Input an invalid email to Email textbox");
			loginPage.inputToDynamicTextboxByID("Email", invalidEmail);
			
			log.info("Login_02_Login_With_Invalid_Email - Step 02: Click to Login button");
			loginPage.clickToLoginButton();
			
			log.info("Login_02_Login_With_Invalid_Email - Step 03: Verify error message displayed correctly with content is 'Wrong email'");
			verifyEquals(loginPage.getErrorMessageByID("Email"), "Wrong email");		
		}
		@Test
		public void Login_03_Login_With_Unregistered_Email() {
			log.info("Login_03_Login_With_Unregistered_Email - Step 01: Input unregistered email to Email textbox");
			loginPage.inputToDynamicTextboxByID("Email", unregisteredEmail);
			
			log.info("Login_03_Login_With_Unregistered_Email - Step 02: Click to Login button");
			loginPage.clickToLoginButton();
			
			log.info("Login_03_Login_With_Unregistered_Email - Step 03: Verify error message displayed correctly with content is 'Login was unsuccessful. Please correct the errors and try again.\r\n"
					+ "No customer account found'");
			verifyEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again." + "\n"
					+ "No customer account found");		
		}
		
		@Test
		public void Login_04_Login_With_Registered_Email_But_Without_Password() {
			log.info("Login_04_Login_With_Registered_Email_But_Without_Password - Step 01: Input a registered email to Email textbox");
			loginPage.inputToDynamicTextboxByID("Email", existingEmail);
			
			log.info("Login_04_Login_With_Registered_Email_But_Without_Password - Step 02: Click to Login button");
			loginPage.clickToLoginButton();
			
			log.info("Login_04_Login_With_Registered_Email_But_Without_Password - Step 03: Verify error message displayed correctly with content is 'Login was unsuccessful. Please correct the errors and try again." + "\n"
					
					+ "The credentials provided are incorrect'");
			verifyEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again." + "\n"
					
					+"The credentials provided are incorrect");		
		}
		
		@Test
		public void Login_04_Login_With_Registered_Email_But_Wrong_Password() {
			log.info("Login_04_Login_With_Registered_Email_But_Wrong_Password - Step 01: Input a registered email to Email textbox");
			loginPage.inputToDynamicTextboxByID("Email", existingEmail);
			
			log.info("Login_04_Login_With_Registered_Email_But_Wrong_Password - Step 02: Input wrong password to Password textbox");
			loginPage.inputToDynamicTextboxByID("Password", "12345789");
			
			log.info("Login_04_Login_With_Registered_Email_But_Wrong_Password - Step 03: Click to Login button");
			loginPage.clickToLoginButton();
			
			log.info("Login_04_Login_With_Registered_Email_But_Wrong_Password - Step 04: Verify error message displayed correctly with content is 'Login was unsuccessful. Please correct the errors and try again." + "\n"
					
					+ "The credentials provided are incorrect'");
			verifyEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again." + "\n"
					
					+"The credentials provided are incorrect");	
		}
		@Test
		public void Login_05_Login_With_Registered_Email_And_Correct_Password() {
			log.info("Login_04_Login_With_Registered_Email_And_Correct_Password - Step 01: Input a registered email to Email textbox");
			loginPage.inputToDynamicTextboxByID("Email", existingEmail);
			
			log.info("Login_04_Login_With_Registered_Email_And_Correct_Password - Step 02: Input correct password to Password textbox");
			loginPage.inputToDynamicTextboxByID("Password", password);
			
			log.info("Login_04_Login_With_Registered_Email_And_Correct_Password - Step 03: Click to Login button");
			userHomePage = loginPage.clickToLoginButton();
			
			log.info("Login_04_Login_With_Registered_Email_And_Correct_Password - Step 04: Verify user login successfully");
			verifyTrue(userHomePage.isMyAccountLinkDisplayed());
		}
		
		@AfterClass(alwaysRun = true)
		public void afterClass() {
		driver.quit();
}
}
