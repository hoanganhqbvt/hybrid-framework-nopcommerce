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

public class Register extends BaseTest{
 WebDriver driver;
 private UserHomePageObject userHomePage;
 private UserRegisterPageObject registerPage;
 String invalidEmail = "abc@123@abc";
 int fakeNumber = generateFakeNumber();
 String validEmail = "auto" + fakeNumber + "@gmail.com", firstName = "Automation", lastName = "Testing", gender = "Male",
		password = "Abc@123456", confirmPassword = password, day = "20", month = "October", year = "1990";
 String existingEmail = validEmail;
 
 
	@Parameters({"browser", "userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL) {
		log.info("Pre-condition - Step 01: Open browser");
		driver = getBrowserDriver(browserName, userURL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Pre-condition - Step 02: Click to Register link page");
		userHomePage.openLinkPageAtHomePageByName(driver, "Register");
		registerPage = PageGeneratorManager.getUserRegisterPage(driver);
	}
	@Test
	public void Register_01_Register_With_Empty_Date() {
		log.info("Register_01_Register_With_Empty_Date - Step 01: Click to Register button without input any value");
		registerPage.clickToRegisterButton();
		
		log.info("Register_01_Register_With_Empty_Date - Step 02: Verify error message displayed correctlly next to Firstname fields textbox with content: 'First name is required.'");
		verifyEquals(registerPage.getErrorMessageDisplayedNextToRequiredFieldsTextbox("First name:"), "First name is required.");
		
		log.info("Register_01_Register_With_Empty_Date - Step 03: Verify error message displayed correctlly next to Lastname fields textbox with content: 'Last name is required.'");
		verifyEquals(registerPage.getErrorMessageDisplayedNextToRequiredFieldsTextbox("Last name:"), "Last name is required.");
		
		log.info("Register_01_Register_With_Empty_Date - Step 04: Verify error message displayed correctlly next to Email fields textbox with content: 'Email is required.'");
		verifyEquals(registerPage.getErrorMessageDisplayedNextToRequiredFieldsTextbox("Email:"), "Email is required.");
		
		log.info("Register_01_Register_With_Empty_Date - Step 05: Verify error message displayed correctlly next to Password fields textbox with content: 'Password is required.'");
		verifyEquals(registerPage.getErrorMessageDisplayedNextToRequiredFieldsTextbox("Password:"), "Password is required.");
		
		log.info("Register_01_Register_With_Empty_Date - Step 06: Verify error message displayed correctlly next to Confirm password fields textbox with content: 'Confirm password is required.'");
		verifyEquals(registerPage.getErrorMessageDisplayedNextToRequiredFieldsTextbox("Confirm password:"), "Password is required.");		
	}
	
	@Test
	public void Register_02_Register_With_Invalid_Email() {
		log.info("Register_02_Register_With_Invalid_Email - Step 01: Input an invalid email to Email textbox");
		registerPage.inputToDynamicTextboxByID("Email", invalidEmail);
		
		log.info("Register_02_Register_With_Invalid_Email - Step 02: Verify error message displayed correctly next to the email textbox with content is 'Wrong email'");
		verifyEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}
	
	@Test
	public void Register_03_Register_With_Valid_Data() {
		log.info("Register_03_Register_With_Valid_Data - Step 01: Select gender radio button that is Male");
		registerPage.selectGenderRadioButton("Male", gender);
		
		log.info("Register_03_Register_With_Valid_Data - Step 02: Input to Firstname textbox: " + firstName);
		registerPage.inputToDynamicTextboxByID("FirstName", firstName);
		
		log.info("Register_03_Register_With_Valid_Data - Step 03: Input to Lastname textbox: " + lastName);
		registerPage.inputToDynamicTextboxByID("LastName", lastName);
		
		log.info("Register_03_Register_With_Valid_Data - Step 04: Select a day of birth in Day dropdown list that has value: " + day);
		registerPage.selectDOBInDropdownListByName("DateOfBirthDay", day);
		
		log.info("Register_03_Register_With_Valid_Data - Step 05: Select a month of birth in Month dropdown list that has value: " + month);
		registerPage.selectDOBInDropdownListByName("DateOfBirthMonth", month);
		
		log.info("Register_03_Register_With_Valid_Data - Step 06: Select a year of birth in Year dropdown list that has value: " + year);
		registerPage.selectDOBInDropdownListByName("DateOfBirthYear", year);
		
		log.info("Register_03_Register_With_Valid_Data - Step 07: Input to Email textbox: " + validEmail);
		registerPage.inputToDynamicTextboxByID("Email", validEmail);
		
		log.info("Register_03_Register_With_Valid_Data - Step 08: Input to Password textbox: " + password);
		registerPage.inputToDynamicTextboxByID("Password", password);
		
		log.info("Register_03_Register_With_Valid_Data - Step 09: Input to ConfirmPassword textbox: " + password);
		registerPage.inputToDynamicTextboxByID("ConfirmPassword", confirmPassword);
		
		log.info("Register_03_Register_With_Valid_Data - Step 10: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_03_Register_With_Valid_Data - Step 11: Verify success registered message displayed correctly with content is 'Your registration completed'");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register_03_Register_With_Valid_Data - Step 12: Click to Logout link");
		registerPage.openLinkPageAtHomePageByName(driver, "Log out");
		
		log.info("Register_03_Register_With_Valid_Data - Step 13: Open Register page");
		registerPage.openLinkPageAtHomePageByName(driver, "Register");
		
	}
	
	@Test
	public void Register_04_Register_With_An_Existing_Email() {
		log.info("Register_04_Register_With_An_Existing_Email - Step 01: Select gender radio button that is Male");
		registerPage.selectGenderRadioButton("Male", gender);
		
		log.info("Register_04_Register_With_An_Existing_Email - Step 02: Input to Firstname textbox: " + firstName);
		registerPage.inputToDynamicTextboxByID("FirstName", firstName);
		
		log.info("Register_04_Register_With_An_Existing_Email - Step 03: Input to Lastname textbox: " + lastName);
		registerPage.inputToDynamicTextboxByID("LastName", lastName);
		
		log.info("Register_04_Register_With_An_Existing_Email - Step 04: Select a day of birth in Day dropdown list that has value: " + day);
		registerPage.selectDOBInDropdownListByName("DateOfBirthDay", day);
		
		log.info("Register_04_Register_With_An_Existing_Email - Step 05: Select a month of birth in Month dropdown list that has value: " + month);
		registerPage.selectDOBInDropdownListByName("DateOfBirthMonth", month);
		
		log.info("Register_04_Register_With_An_Existing_Email - Step 06: Select a year of birth in Year dropdown list that has value: " + year);
		registerPage.selectDOBInDropdownListByName("DateOfBirthYear", year);
		
		log.info("Register_04_Register_With_An_Existing_Email - Step 07: Input to Email textbox with an existing email that is: " + existingEmail);
		registerPage.inputToDynamicTextboxByID("Email", existingEmail);
		
		log.info("Register_04_Register_With_An_Existing_Email - Step 08: Input to Password textbox: " + password);
		registerPage.inputToDynamicTextboxByID("Password", password);
		
		log.info("Register_04_Register_With_An_Existing_Email - Step 09: Input to ConfirmPassword textbox: " + password);
		registerPage.inputToDynamicTextboxByID("ConfirmPassword", confirmPassword);
		
		log.info("Register_04_Register_With_An_Existing_Email - Step 10: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_04_Register_With_An_Existing_Email - Step 11: Verify the error message displayed with content is 'The specified email already exists'");
		verifyEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");		
	}
	
	@Test
	public void Register_05_Register_With_Password_Less_Than_6_Characters() {
		log.info("Register_05_Register_With_Password_Less_Than_6_Characters - Step 01: Select gender radio button that is Male");
		registerPage.selectGenderRadioButton("Male", gender);
		
		log.info("Register_05_Register_With_Password_Less_Than_6_Characters - Step 02: Input to Firstname textbox: " + firstName);
		registerPage.inputToDynamicTextboxByID("FirstName", firstName);
		
		log.info("Register_05_Register_With_Password_Less_Than_6_Characters - Step 03: Input to Lastname textbox: " + lastName);
		registerPage.inputToDynamicTextboxByID("LastName", lastName);
		
		log.info("Register_05_Register_With_Password_Less_Than_6_Characters - Step 04: Select a day of birth in Day dropdown list that has value: " + day);
		registerPage.selectDOBInDropdownListByName("DateOfBirthDay", day);
		
		log.info("Register_05_Register_With_Password_Less_Than_6_Characters - Step 05: Select a month of birth in Month dropdown list that has value: " + month);
		registerPage.selectDOBInDropdownListByName("DateOfBirthMonth", month);
		
		log.info("Register_05_Register_With_Password_Less_Than_6_Characters - Step 06: Select a year of birth in Year dropdown list that has value: " + year);
		registerPage.selectDOBInDropdownListByName("DateOfBirthYear", year);
		
		log.info("Register_05_Register_With_Password_Less_Than_6_Characters - Step 07: Input to Email textbox with a valid email that is: " + validEmail);
		registerPage.inputToDynamicTextboxByID("Email", validEmail);
		
		log.info("Register_05_Register_With_Password_Less_Than_6_Characters - Step 08: Input to a password less than 6 characters to Password textbox: '12345'");
		registerPage.inputToDynamicTextboxByID("Password", "12345");	
		
		log.info("Register_05_Register_With_Password_Less_Than_6_Characters - Step 09: Click to Register button");
		registerPage.clickToRegisterButton();
				
		log.info("Register_05_Register_With_Password_Less_Than_6_Characters - Step 10: Verify the error message displayed with content is 'Password must meet the following rules: must have at least 6 characters'");
		verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:" + "\n" + "must have at least 6 characters");
	}
	
	@Test
	public void Register_06_Register_With_Not_Matched_Confirm_Password() {
		log.info("Register_06_Register_With_Not_Matched_Confirm_Password - Step 01: Select gender radio button that is Male");
		registerPage.selectGenderRadioButton("Male", gender);
		
		log.info("Register_05_Register_With_Password_Less_Than_6_CharactRegister_06_Register_With_Not_Matched_Confirm_Passworders - Step 02: Input to Firstname textbox: " + firstName);
		registerPage.inputToDynamicTextboxByID("FirstName", firstName);
		
		log.info("Register_06_Register_With_Not_Matched_Confirm_Password - Step 03: Input to Lastname textbox: " + lastName);
		registerPage.inputToDynamicTextboxByID("LastName", lastName);
		
		log.info("Register_06_Register_With_Not_Matched_Confirm_Password - Step 04: Select a day of birth in Day dropdown list that has value: " + day);
		registerPage.selectDOBInDropdownListByName("DateOfBirthDay", day);
		
		log.info("Register_06_Register_With_Not_Matched_Confirm_Password - Step 05: Select a month of birth in Month dropdown list that has value: " + month);
		registerPage.selectDOBInDropdownListByName("DateOfBirthMonth", month);
		
		log.info("Register_06_Register_With_Not_Matched_Confirm_Password - Step 06: Select a year of birth in Year dropdown list that has value: " + year);
		registerPage.selectDOBInDropdownListByName("DateOfBirthYear", year);
		
		log.info("Register_06_Register_With_Not_Matched_Confirm_Password - Step 07: Input to Email textbox with a valid email that is: " + validEmail);
		registerPage.inputToDynamicTextboxByID("Email", validEmail);
		
		log.info("Register_06_Register_With_Not_Matched_Confirm_Password - Step 08: Input valid password  to Password textbox: " + password);
		registerPage.inputToDynamicTextboxByID("Password", password);	
		
		log.info("Register_06_Register_With_Not_Matched_Confirm_Password - Step 09: Input not matched password  to Confirm Password textbox: '1234578'");
		registerPage.inputToDynamicTextboxByID("ConfirmPassword", "1234578");
		
		log.info("Register_06_Register_With_Not_Matched_Confirm_Password - Step 10: Click to Register button");
		registerPage.clickToRegisterButton();
				
		log.info("Register_06_Register_With_Not_Matched_Confirm_Password - Step 11: Verify the error message displayed with content is 'The password and confirmation password do not match.'");
		verifyEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
}
