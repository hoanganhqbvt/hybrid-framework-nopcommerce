package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.bankGuru.user.EditCustomerPO;
import pageObject.bankGuru.user.LoginPageObject;
import pageObject.bankGuru.user.ManagerPageObject;
import pageObject.bankGuru.user.NewCustomerPO;
import pageObject.bankGuru.user.PageGeneratorManagerBankGuru;
import pageObject.bankGuru.user.RegisterPageObject;

public class EditCustomer extends BaseTest{
	WebDriver driver;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private ManagerPageObject managerPage;
	private EditCustomerPO editCustomerPage;
	private NewCustomerPO newCustomerPage;
	
	int fakeNumber = generateFakeNumber();
	String emailAdd = "automation" + fakeNumber + "@gmail.com";
	String userID, password;
	String loginPageURL = "https://demo.guru99.com/v4";
	String customerName = "Automation";
	String DOB = "20/11/1999", address = "123 Street", city = "Ho Chi Minh", state = "SG", PIN = "111111",
			customerID, mobileNumber = "0917382666", userPassword = "123456";
	String editAddress = "edited street", editCity = "Ha Noi", editPIN = "222222", editMobile = "0372722789",
			editSate= "HN", editEmail = "editEmail" + fakeNumber + "@gmail.com";
	
	
	@Parameters({ "browser", "registerUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String registerUrl) {
		log.info("Pre-condition - Step 01: Open browser and access register URL");
		driver = getBrowserDriver(browserName, registerUrl);
		registerPage = PageGeneratorManagerBankGuru.getRegisterPage(driver);
		
		log.info("Pre-condition - Step 02: Input email to Email ID textbox to get detail access info");
		registerPage.inputToEmailIDTextbox(emailAdd);
		
		log.info("Pre-condition - Step 03: Click on Submit button");
		registerPage.clickToSubmitButton();
		
		log.info("Pre-condition - Step 04: Get User ID info");
		userID = registerPage.getDetailAccessInfoByText("User ID :");
		
		log.info("Pre-condition - Step 05: Get User ID info");
		password = registerPage.getDetailAccessInfoByText("Password :");
		
		log.info("Pre-condition - Step 06: Open login URL");
		loginPage = registerPage.openLoginPageURL(loginPageURL);
		
		log.info("Pre-condition - Step 07: Input UserID to textbox with value is: " + userID);
		loginPage.inputToUserIDPasswordTextbox("UserID", userID);
		
		log.info("Pre-condition - Step 08: Input Password to textbox with value is: " + password);
		loginPage.inputToUserIDPasswordTextbox("Password", password);
		
		log.info("Pre-condition - Step 09: Click on Login button");
		managerPage = loginPage.clickToLoginButton();
		
		log.info("Pre-condition - Step 10: Open New Customer page");
		managerPage.openPageOnManagerPageByName(driver, "New Customer");
		newCustomerPage = PageGeneratorManagerBankGuru.getNewCustomerPage(driver);
		
		log.info("Pre-condition - Step 11: Input a value to Customer Name textbox");
		newCustomerPage.inputToDynamicTextboxByName("Customer Name", customerName);
		
		log.info("Pre-condition - Step 12: Input a value to Date of Birth textbox");
		newCustomerPage.inputToDOBTextboxByJS(DOB);
		
		log.info("Pre-condition - Step 13: Input a value to Address textbox");
		newCustomerPage.inputToAddressTextbox(address);
		
		log.info("Pre-condition - Step 14: Input a value to City textbox");
		newCustomerPage.inputToDynamicTextboxByName("City", city);
		
		log.info("Pre-condition - Step 15: Input a value to State textbox");
		newCustomerPage.inputToDynamicTextboxByName("State", state);
		
		log.info("Pre-condition - Step 16: Input a value to PIN textbox");
		newCustomerPage.inputToDynamicTextboxByName("PIN", PIN);
		
		log.info("Pre-condition - Step 17: Input a value to Mobile Number textbox");
		newCustomerPage.inputToDynamicTextboxByName("Mobile Number", mobileNumber);
		
		log.info("Pre-condition - Step 18: Input a value to E-mail textbox");
		newCustomerPage.inputToDynamicTextboxByName("E-mail", emailAdd);
		
		log.info("Pre-condition - Step 19: Input a value to Password textbox");
		newCustomerPage.inputToDynamicTextboxByName("Password", userPassword);
		
		log.info("Pre-condition - Step 20: Click on Submit button");
		newCustomerPage.clickToSubmitButton();
		
		log.info("Pre-condition - Step 21: Verify the success message displayed after creating new customer");
		verifyTrue(newCustomerPage.isCreatedNewCustomerSuccessMessageDisplayed());
		
		log.info("Pre-condition - Step 22: Get Customer ID value on customer detail info after created");
		customerID = newCustomerPage.getCustomerInfoByFieldName("Customer ID");
		
}
	
	@Test
	public void Edit_Customer_01_Address_Cannot_Be_Empty() {				
		log.info("Edit_Customer_01_Address_Cannot_Be_Empty - Step 01: Open Edit Customer page");
		managerPage.openPageOnManagerPageByName(driver, "Edit Customer");
		editCustomerPage = PageGeneratorManagerBankGuru.getEditCustomerPage(driver);
		
		log.info("Edit_Customer_01_Address_Cannot_Be_Empty - Step 02: Input Customer ID to textbox to go to Edit Customer page");
		editCustomerPage.inputToCustomerIDTextboxToGoToEditPage(customerID);
		
		log.info("Edit_Customer_01_Address_Cannot_Be_Empty - Step 03: Click on Submit button");
		editCustomerPage.clickToSubmitButton();
		
		log.info("Edit_Customer_01_Address_Cannot_Be_Empty - Step 04: Make Address blank");
		editCustomerPage.inputToAddressTextbox("");
		
		log.info("Edit_Customer_01_Address_Cannot_Be_Empty - Step 05: Verify the error message displayed with text 'Address Field must not be blank'");
		verifyEquals(editCustomerPage.getErrorMessageNextToTextboxByFieldName("Address"),"Address Field must not be blank");
	}
	
		@Test
		public void Edit_Customer_02_City_Cannot_Be_Empty() {				
		log.info("Edit_Customer_02_City_Cannot_Be_Empty - Step 01: Make City blank");
		editCustomerPage.inputToCustomerInfoTextboxByFieldName("City", "");
		
		log.info("Edit_Customer_02_City_Cannot_Be_Empty - Step 02: Verify the error message displayed with text 'City Field must not be blank'");
		verifyEquals(editCustomerPage.getErrorMessageNextToTextboxByFieldName("City"),"City Field must not be blank");
		}
		@Test
		public void Edit_Customer_03_City_Cannot_Be_Numeric() {				
			log.info("Edit_Customer_03_City_Cannot_Be_Numericy - Step 01: Input a number to City textbox");
			editCustomerPage.inputToCustomerInfoTextboxByFieldName("City", "12");
			
			log.info("Edit_Customer_03_City_Cannot_Be_Numeric - Step 02: Verify the error message displayed with text 'Numbers are not allowed'");
			verifyEquals(editCustomerPage.getErrorMessageNextToTextboxByFieldName("City"),"Numbers are not allowed");
		}
		@Test
		public void Edit_Customer_04_City_Cannot_Have_Special_Character() {				
		log.info("Edit_Customer_04_City_Cannot_Have_Special_Character - Step 01: Input a Special character to City textbox");
		editCustomerPage.inputToCustomerInfoTextboxByFieldName("City", "@");
		
		log.info("Edit_Customer_04_City_Cannot_Have_Special_Character - Step 02: Verify the error message displayed with text 'Special characters are not allowed'");
		verifyEquals(editCustomerPage.getErrorMessageNextToTextboxByFieldName("City"),"Special characters are not allowed");
		}
		
		@Test
		public void Edit_Customer_05_Change_Some_Field_And_Submit() {			
		log.info("Edit_Customer_05_Change_Some_Field_And_Submit - Step 01: Input a valid value to Address textbox");
		editCustomerPage.inputToAddressTextbox(editAddress);
		
		log.info("Edit_Customer_05_Change_Some_Field_And_Submit - Step 02: Input a valid value to City textbox");
		editCustomerPage.inputToCustomerInfoTextboxByFieldName("City", editCity);
		
		log.info("Edit_Customer_05_Change_Some_Field_And_Submit - Step 03: Input a valid value to State textbox");
		editCustomerPage.inputToCustomerInfoTextboxByFieldName("State", editSate);
		
		log.info("Edit_Customer_05_Change_Some_Field_And_Submit - Step 04: Input a valid value to PIN textbox");
		editCustomerPage.inputToCustomerInfoTextboxByFieldName("PIN", editPIN);
		
		log.info("Edit_Customer_05_Change_Some_Field_And_Submit - Step 05: Input a valid value to Mobile textbox");
		editCustomerPage.inputToCustomerInfoTextboxByFieldName("Mobile Number", editMobile);
		
		log.info("Edit_Customer_05_Change_Some_Field_And_Submit - Step 06: Input a valid value to Email textbox");
		editCustomerPage.inputToCustomerInfoTextboxByFieldName("E-mail", editEmail);
		
		log.info("Edit_Customer_05_Change_Some_Field_And_Submit - Step 07: Click on Submit button");
		editCustomerPage.clickToSubmitButton();
		
}
		@AfterClass(alwaysRun = true)
		public void afterClass() {
			driver.quit();
		}
}