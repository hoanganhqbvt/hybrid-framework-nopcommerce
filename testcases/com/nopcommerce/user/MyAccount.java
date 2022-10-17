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
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.CustomerInfoPO;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class MyAccount extends BaseTest{
	 WebDriver driver;
	 private UserHomePageObject userHomePage;
	 private UserRegisterPageObject registerPage;
	 private CustomerInfoPO customerInfoPage;
	 private UserAddressPageObject addressPage;
	 private UserChangePasswordPageObject userChangePasswordPage;
	 private UserLoginPageObject userLoginPage;
	 private UserMyProductReviewPageObject userMyProductReviewPage;
	 String invalidEmail = "abc@123@abc";
	 int fakeNumber = generateFakeNumber();
	 String validEmail = "automail" + fakeNumber + "@gmail.com", firstName = "Automation", lastName = "Testing", gender = "Male",
			password = "Abc@123456", confirmPassword = password, day = "20", month = "October", year = "1990";
	 String updateGender = "Female", updateFirstname = "AutoUpdated", updateLastname = "UpdatedLastName", 
			 updateEmail = "updatedmail" + fakeNumber + "@hotmail.com", companyName = "ACB";
	 String updateDay = "1", updateMonth = "November", updateYear = "1999";
	 String unregisteredEmail = "hta@gmai.com";
	 String addressFirstname = "AddFirstname", addressLastname = "AddLastname", addCountry = "United States", 
			 state = "California", city = "Oakland", zipPostalCode = "123456", phoneNumber = "0987654321", faxNumber = "0123456789",
			 address1 = "123 No Street", address2 = "789 Highway";
	 String newPassword = "Newpass@123";
	 String reviewTitle = "My Review Product Title", reviewText = "This product is rather good with a reasonable price";
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

			log.info("Pre-condition - Step 14: Click to My account link");
			customerInfoPage = registerPage.clickToMyaccountLink();
}
@Test
public void MyAccount_01_Update_Customer_Info() {
			log.info("MyAccount_01_Update_Customer_Info - Step 01: Change gender to Female");
			customerInfoPage.selectGenderRadioButton(updateGender, updateGender);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 02: Change firstname");
			customerInfoPage.inputToDynamicTextboxByID("FirstName", updateFirstname);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 03: Change lastname");
			customerInfoPage.inputToDynamicTextboxByID("LastName", updateLastname);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 04: Change day of birth");
			customerInfoPage.selectDOBInDropdownListByName("DateOfBirthDay", updateDay);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 05: Change month of birth");
			customerInfoPage.selectDOBInDropdownListByName("DateOfBirthMonth", updateMonth);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 06: Change year of birth");
			customerInfoPage.selectDOBInDropdownListByName("DateOfBirthYear", updateYear);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 07: Change email");
			customerInfoPage.inputToDynamicTextboxByID("Email", updateEmail);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 08: Update company name");
			customerInfoPage.inputToDynamicTextboxByID("Company", companyName);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 09: Click on Save button");
			customerInfoPage.clickToSaveButton();
			
			log.info("MyAccount_01_Update_Customer_Info - Step 10: Verify Firstname is updated correctly");
			verifyEquals(customerInfoPage.getCustomerInfoByID("FirstName", "value"), updateFirstname);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 11: Verify Lastname is updated correctly");
			verifyEquals(customerInfoPage.getCustomerInfoByID("LastName", "value"), updateLastname);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 12: Verify email is updated correctly");
			verifyEquals(customerInfoPage.getCustomerInfoByID("Email", "value"), updateEmail);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 13: Verify company is updated correctly");
			verifyEquals(customerInfoPage.getCustomerInfoByID("Company", "value"), companyName);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 14: Verify day of birth is updated correctly");
			verifyEquals(customerInfoPage.getDOBValueByName("DateOfBirthDay"), updateDay);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 15: Verify month of birth is updated correctly");
			verifyEquals(customerInfoPage.getDOBValueByName("DateOfBirthMonth"), updateMonth);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 16: Verify year of birth is updated correctly");
			verifyEquals(customerInfoPage.getDOBValueByName("DateOfBirthYear"), updateYear);
			
			log.info("MyAccount_01_Update_Customer_Info - Step 14: Verify gender is updated correctly to Female");
			verifyTrue(customerInfoPage.isGenderSelectedCorrectly("Female"));
			
}
@Test
public void MyAccount_02_Update_Address(){
	log.info("MyAccount_02_Update_Address - Step 01: Click on Address link page");
	customerInfoPage.openPageAtMyAccountByPageName(driver, "Addresses");
	addressPage = PageGeneratorManager.getUserAddressPage(driver);
	
	log.info("MyAccount_02_Update_Address - Step 02: Click on ADD NEW button");
	addressPage.clickToAddNewButton();
	
	log.info("MyAccount_02_Update_Address - Step 03: Input to Firstname textbox a value is: " + addressFirstname);
	addressPage.inputToDynamicTextboxByID("Address_FirstName", addressFirstname);
	
	log.info("MyAccount_02_Update_Address - Step 04: Input to Lastname textbox a value is: " + addressLastname);
	addressPage.inputToDynamicTextboxByID("Address_LastName", addressLastname);
	
	log.info("MyAccount_02_Update_Address - Step 05: Input to Email textbox a value is: " + validEmail);
	addressPage.inputToDynamicTextboxByID("Address_Email", validEmail);
	
	log.info("MyAccount_02_Update_Address - Step 06: Input to Company textbox a value is: " + companyName);
	addressPage.inputToDynamicTextboxByID("Address_Company", companyName);
	
	log.info("MyAccount_02_Update_Address - Step 07: Select a country in dropdown list with value is: " + addCountry);
	addressPage.selectOptionInDropdownListByID("Address_CountryId", addCountry);
	
	log.info("MyAccount_02_Update_Address - Step 08: Select State/province in dropdown list with value is: " + state);
	addressPage.selectOptionInDropdownListByID("Address_StateProvinceId", state);
	
	log.info("MyAccount_02_Update_Address - Step 09: Input to City textbox a value is: " + city);
	addressPage.inputToDynamicTextboxByID("Address_City", city);
	
	log.info("MyAccount_02_Update_Address - Step 10: Input to Address 1 textbox a value is: " + address1);
	addressPage.inputToDynamicTextboxByID("Address_Address1", address1);
	
	log.info("MyAccount_02_Update_Address - Step 11: Input to Address 2 textbox a value is: " + address2);
	addressPage.inputToDynamicTextboxByID("Address_Address2", address2);
	
	log.info("MyAccount_02_Update_Address - Step 12: Input to Zip/postal code textbox a value is: " + zipPostalCode);
	addressPage.inputToDynamicTextboxByID("Address_ZipPostalCode", zipPostalCode);
	
	log.info("MyAccount_02_Update_Address - Step 13: Input to Phone textbox a value is: " + phoneNumber);
	addressPage.inputToDynamicTextboxByID("Address_PhoneNumber", phoneNumber);
	
	log.info("MyAccount_02_Update_Address - Step 14: Input to Fax textbox a value is: " + faxNumber);
	addressPage.inputToDynamicTextboxByID("Address_FaxNumber", faxNumber);
	
	log.info("MyAccount_02_Update_Address - Step 15: Click on Save button");
	addressPage.clickToSaveButton();
	
	log.info("MyAccount_02_Update_Address - Step 16: Verify Address's name Info is correct");
	verifyEquals(addressPage.getAddedAddressInfoByLabel("name"), addressFirstname + " " + addressLastname);
	
	log.info("MyAccount_02_Update_Address - Step 17: Verify Address's emai Info is correct");
	verifyEquals(addressPage.getAddedAddressInfoByLabel("email").substring(7), validEmail);
	System.out.println(addressPage.getAddedAddressInfoByLabel("email").substring(7));
	
	log.info("MyAccount_02_Update_Address - Step 18: Verify Address's phone Info is correct");
	verifyEquals(addressPage.getAddedAddressInfoByLabel("phone").substring(14), phoneNumber);	
	
	log.info("MyAccount_02_Update_Address - Step 19: Verify Address's fax Info is correct");
	verifyEquals(addressPage.getAddedAddressInfoByLabel("fax").substring(12), faxNumber);
	
	log.info("MyAccount_02_Update_Address - Step 20: Verify Address's company Info is correct");
	verifyEquals(addressPage.getAddedAddressInfoByLabel("company"), companyName);
	
	log.info("MyAccount_02_Update_Address - Step 21: Verify Address's address1 Info is correct");
	verifyEquals(addressPage.getAddedAddressInfoByLabel("address1"), address1);
	
	log.info("MyAccount_02_Update_Address - Step 22: Verify Address's address2 Info is correct");
	verifyEquals(addressPage.getAddedAddressInfoByLabel("address2"), address2);
	
	log.info("MyAccount_02_Update_Address - Step 23: Verify Address's country Info is correct");
	verifyEquals(addressPage.getAddedAddressInfoByLabel("country"), addCountry);
	
	log.info("MyAccount_02_Update_Address - Step 24: Verify Address's city, state, zip Info is correct");
	verifyEquals(addressPage.getAddedAddressInfoByLabel("city-state-zip"), city + ", " + state + ", " + zipPostalCode);
}
@Test
public void MyAccount_03_Change_Password() {
	log.info("MyAccount_03_Change_Password - Step 01: Click on Change Password link");
	addressPage.openPageAtMyAccountByPageName(driver, "Change password");
	userChangePasswordPage = PageGeneratorManager.getUserChangePasswordPage(driver);
	
	log.info("MyAccount_03_Change_Password - Step 02: Input to Old password textbox");
	userChangePasswordPage.inputToDynamicTextboxOnChangePasswordPageByID("OldPassword", password);
	
	log.info("MyAccount_03_Change_Password - Step 03: Input to New password textbox");
	userChangePasswordPage.inputToDynamicTextboxOnChangePasswordPageByID("NewPassword", newPassword);
	
	log.info("MyAccount_03_Change_Password - Step 04: Input to Confirm new password textbox");
	userChangePasswordPage.inputToDynamicTextboxOnChangePasswordPageByID("ConfirmNewPassword", newPassword);
	
	log.info("MyAccount_03_Change_Password - Step 05: Click on CHANGE PASSWORD button");
	userChangePasswordPage.clickToChangePasswordButton();
	
	log.info("MyAccount_03_Change_Password - Step 06: Verify the change password success message displayed correctly with content 'Password was changed'");
	verifyEquals(userChangePasswordPage.getChangePasswordSuccessMessage(),"Password was changed");
	
	log.info("MyAccount_03_Change_Password - Step 07: Close change password success message");
	userChangePasswordPage.closeChangePasswordSuccessMessage();
	
	log.info("MyAccount_03_Change_Password - Step 08: Click on Logout link");
	userChangePasswordPage.openLinkPageAtHomePageByName(driver, "Log out");
	userHomePage = PageGeneratorManager.getUserHomePage(driver);
	
	log.info("MyAccount_03_Change_Password - Step 09: Click on Login link");
	userLoginPage = userHomePage.clickToLoginLink();
	
	log.info("MyAccount_03_Change_Password - Step 10: Input to Email textbox on Login page");
	userLoginPage.inputToDynamicTextboxByID("Email", updateEmail);
	
	log.info("MyAccount_03_Change_Password - Step 11: Input old password on Login page");
	userLoginPage.inputToDynamicTextboxByID("Password", password);
	
	log.info("MyAccount_03_Change_Password - Step 12: Click on Login button");
	userLoginPage.clickToLoginButton();
	
	log.info("MyAccount_03_Change_Password - Step 13: Verify unsucces login message displayed wit correct content 'Login was unsuccessful. Please correct the errors and try again."
			+ "\n" + "No customer account found");
	verifyEquals(userLoginPage.getUnsuccessLoginMessage(),"Login was unsuccessful. Please correct the errors and try again." + "\n"
			+ "The credentials provided are incorrect");
	
	log.info("MyAccount_03_Change_Password - Step 14: Input new password on Login page");
	userLoginPage.inputToDynamicTextboxByID("Password", newPassword);
	
	log.info("MyAccount_03_Change_Password - Step 15: Click on Login button");
	userHomePage = userLoginPage.clickToLoginButton();
	
	log.info("MyAccount_03_Change_Password - Step 16: Verify My Account link is displayed");
	userHomePage.isMyAccountLinkDisplayed();
}
@Test
public void MyAccount_04_My_Product_Review() {
	log.info("MyAccount_04_My_Product_Review - Step 01: Click on a product link to view detail");
	userHomePage.clickToAProductToViewDetail("Build your own computer");
	
	log.info("MyAccount_04_My_Product_Review - Step 02: Click on 'Add your review' link");
	userMyProductReviewPage = userHomePage.clickToAddYourReviewLink();
	
	log.info("MyAccount_04_My_Product_Review - Step 03: Input to Review title textbox");
	userMyProductReviewPage.inputToReviewTitleTextbox(reviewTitle);
	
	log.info("MyAccount_04_My_Product_Review - Step 04: Input to Review text area");
	userMyProductReviewPage.inputToReviewTextArea(reviewText);
	
	log.info("MyAccount_04_My_Product_Review - Step 05: ");
	userMyProductReviewPage.selectRatingLevelRadioButtonByValue("5");
	
	log.info("MyAccount_04_My_Product_Review - Step 06: Click on SUBMIT REVIEW button");
	userMyProductReviewPage.clickToSubmitReviewButton();
	
	log.info("MyAccount_04_My_Product_Review - Step 07: Verify success added review product message displayed with content is 'Product review is successfully added.'");
	verifyTrue(userMyProductReviewPage.isSuccessAddProductReviewMessageDisplayed());
	
	log.info("MyAccount_04_My_Product_Review - Step 08: Click on My account link");
	userMyProductReviewPage.openLinkPageAtHomePageByName(driver, "My account");
	
	log.info("MyAccount_04_My_Product_Review - Step 09: Click on My Product Review link");
	userMyProductReviewPage.openMyProductReviewPage(driver);
	
	log.info("MyAccount_04_My_Product_Review - Step 10: Verify review title is correct that equal: " + reviewTitle);
	verifyEquals(userMyProductReviewPage.getReviewTitleInMyProductReviewPage(), reviewTitle);
	
	
	log.info("MyAccount_04_My_Product_Review - Step 11: Verify review content is correct that equal: " + reviewText);
	verifyEquals(userMyProductReviewPage.getReviewContentInMyProductReviewPage(), reviewText);
	
	
}
@AfterClass(alwaysRun = true)
public void afterClass() {
driver.quit();
}
}
