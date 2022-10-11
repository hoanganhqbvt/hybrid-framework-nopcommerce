package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.bankGuru.user.LoginPageObject;
import pageObject.bankGuru.user.ManagerPageObject;
import pageObject.bankGuru.user.NewCustomerPO;
import pageObject.bankGuru.user.PageGeneratorManagerBankGuru;
import pageObject.bankGuru.user.RegisterPageObject;


public class NewCustomer extends BaseTest{
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private ManagerPageObject managerPage;
	private NewCustomerPO newCustomerPage;

	WebDriver driver;
	int fakeNumber = generateFakeNumber();
	String emailAdd = "automation" + fakeNumber +"@gmail.com";
	String loginUserID, password;
	String loginPageURL = "https://demo.guru99.com/v4/";
	String customerName = "Automation";
	String DOB = "20/11/1999", address = "123 Street", city = "Ho Chi Minh", state = "SG", PIN = "111111",
			customerID, mobileNumber = "0917382666", userPassword = "123456";
	
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
		loginUserID = registerPage.getDetailAccessInfoByText("User ID :");
		
		log.info("Pre-condition - Step 05: Get User ID info");
		password = registerPage.getDetailAccessInfoByText("Password :");
		
		log.info("Pre-condition - Step 06: Open login URL");
		loginPage = registerPage.openLoginPageURL(loginPageURL);
		
		log.info("Pre-condition - Step 07: Input UserID to textbox with value is: " + loginUserID);
		loginPage.inputToUserIDPasswordTextbox("UserID", loginUserID);
		
		log.info("Pre-condition - Step 08: Input Password to textbox with value is: " + password);
		loginPage.inputToUserIDPasswordTextbox("Password", password);
		
		log.info("Pre-condition - Step 09: Click on Login button");
		managerPage = loginPage.clickToLoginButton();
}
	
	@Test
	public void New_Customer_01_Name_Cannot_Be_Empty() {
		log.info("New_Customer_01_Name_Cannot_Be_Empty - Step 01: Open New Customer page");
		managerPage.openPageOnManagerPageByName(driver, "New Customer");
		newCustomerPage = PageGeneratorManagerBankGuru.getNewCustomerPage(driver);
		
		log.info("New_Customer_01_Name_Cannot_Be_Empty - Step 02: Enter to Customer Name textbox and then tab out");
		newCustomerPage.enterToDynamicTextboxByNameAndTabOut("Customer Name");
		
		log.info("New_Customer_01_Name_Cannot_Be_Empty - Step 03: Verify the error message displayed correctly after tabing out Customer Name without value");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("Customer Name"),"Customer name must not be blank");
				
	}
	@Test
	public void New_Customer_02_Name_Cannot_Be_Numeric() {
		log.info("New_Customer_02_Name_Cannot_Be_Numeric - Step 01: Enter a number to Customer Name textbox");
		newCustomerPage.inputToDynamicTextboxByName("Customer Name", String.valueOf(fakeNumber)); 
		
		log.info("New_Customer_02_Name_Cannot_Be_Numeric - Step 02: Verify the error message displayed correctly after entering a number to Customer Name");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("Customer Name"),"Numbers are not allowed");
	}
	@Test
	public void New_Customer_03_Name_Cannot_Have_Special_Character() {
		log.info("New_Customer_03_Name_Cannot_Have_Special_Character - Step 01: Enter a special character to Customer Name textbox");
		newCustomerPage.inputToDynamicTextboxByName("Customer Name", "@"); 
		
		log.info("New_Customer_03_Name_Cannot_Have_Special_Characterc - Step 02: Verify the error message displayed correctly after entering a special character to Customer Name");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("Customer Name"),"Special characters are not allowed");
	}
	@Test
	public void New_Customer_04_Name_Cannot_Have_First_Character_As_Blank() {
		log.info("New_Customer_04_Name_Cannot_Have_First_Character_As_Blank - Step 01: Enter a blank space to Customer Name textbox");
		newCustomerPage.inputToDynamicTextboxByName("Customer Name", " "); 
		
		log.info("New_Customer_04_Name_Cannot_Have_First_Character_As_Blankc - Step 02: Verify the error message displayed correctly after entering a blank space to Customer Name");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("Customer Name"),"First character can not have space");
	}
	@Test
	public void New_Customer_05_Address_Cannot_Be_Empty() {
		log.info("New_Customer_05_Address_Cannot_Be_Empty - Step 01: Enter to Address textbox and then tab out without entering any value");
		newCustomerPage.enterToAddressTextboxAndTabOut(); 
		
		log.info("New_Customer_05_Address_Cannot_Be_Empty - Step 02: Verify the error message displayed correctly if tabing out Customer Name textbox without value");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("Address"),"Address Field must not be blank");
	}
	@Test
	public void New_Customer_06_Address_Cannot_Have_First_Blank_Space() {
		log.info("New_Customer_06_Address_Cannot_Have_First_Blank_Space - Step 01: Enter to Address textbox a first blank space");
		newCustomerPage.inputToAddressTextbox(" "); 
		
		log.info("New_Customer_06_Address_Cannot_Have_First_Blank_Space - Step 02: Verify the error message displayed correctly if entering a first blank space to Address textbox");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("Address"),"First character can not have space");
	}
	@Test
	public void New_Customer_07_City_Cannot_Be_Empty() {				
		log.info("New_Customer_07_City_Cannot_Be_Empty - Step 01: Enter to City textbox and then tab out");
		newCustomerPage.enterToDynamicTextboxByNameAndTabOut("City");
		
		log.info("New_Customer_07_City_Cannot_Be_Empty - Step 02: Verify the error message displayed correctly after tabing out City without value");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("City"),"City Field must not be blank");
				
	}
	@Test
	public void New_Customer_08_City_Cannot_Be_Numeric() {
		log.info("New_Customer_08_City_Cannot_Be_Numeric - Step 01: Enter a number to City textbox");
		newCustomerPage.inputToDynamicTextboxByName("City", String.valueOf(fakeNumber)); 
		
		log.info("New_Customer_08_City_Cannot_Be_Numeric - Step 02: Verify the error message displayed correctly after entering a number to City");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("City"),"Numbers are not allowed");
	}
	@Test
	public void New_Customer_09_City_Cannot_Have_Special_Character() {
		log.info("New_Customer_09_Citye_Cannot_Have_Special_Character - Step 01: Enter a special character to City textbox");
		newCustomerPage.inputToDynamicTextboxByName("City", "@"); 
		
		log.info("New_Customer_09_City_Cannot_Have_Special_Characterc - Step 02: Verify the error message displayed correctly after entering a special character to City");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("City"),"Special characters are not allowed");
	}
	@Test
	public void New_Customer_10_City_Cannot_Have_First_Character_As_Blank() {
		log.info("New_Customer_10_City_Cannot_Have_First_Character_As_Blank - Step 01: Enter a blank space to City textbox");
		newCustomerPage.inputToDynamicTextboxByName("City", " "); 
		
		log.info("New_Customer_10_City_Cannot_Have_First_Character_As_Blankc - Step 02: Verify the error message displayed correctly after entering a blank space to City");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("City"),"First character can not have space");
	}
	@Test
	public void New_Customer_11_State_Cannot_Be_Empty() {				
		log.info("New_Customer_11_State_Cannot_Be_Empty - Step 01: Enter to State textbox and then tab out");
		newCustomerPage.enterToDynamicTextboxByNameAndTabOut("State");
		
		log.info("New_Customer_11_StateCannot_Be_Empty - Step 02: Verify the error message displayed correctly after tabing out State without value");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("State"),"State must not be blank");
				
	}
	@Test
	public void New_Customer_12_State_Cannot_Be_Numeric() {
		log.info("New_Customer_12_State_Cannot_Be_Numeric - Step 01: Enter a number to State textbox");
		newCustomerPage.inputToDynamicTextboxByName("State", String.valueOf(fakeNumber)); 
		
		log.info("New_Customer_12_State_Cannot_Be_Numeric - Step 02: Verify the error message displayed correctly after entering a number to State");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("State"),"Numbers are not allowed");
	}
	@Test
	public void New_Customer_13_State_Cannot_Have_Special_Character() {
		log.info("New_Customer_13_State_Cannot_Have_Special_Character - Step 01: Enter a special character to State textbox");
		newCustomerPage.inputToDynamicTextboxByName("State", "@"); 
		
		log.info("New_Customer_13_State_Cannot_Have_Special_Characterc - Step 02: Verify the error message displayed correctly after entering a special character to State");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("State"),"Special characters are not allowed");
	}
	@Test
	public void New_Customer_14_State_Cannot_Have_First_Character_As_Blank() {
		log.info("New_Customer_14_State_Cannot_Have_First_Character_As_Blank - Step 01: Enter a blank space to State textbox");
		newCustomerPage.inputToDynamicTextboxByName("State", " "); 
		
		log.info("New_Customer_14_State_Cannot_Have_First_Character_As_Blankc - Step 02: Verify the error message displayed correctly after entering a blank space to State");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("State"),"First character can not have space");
	}
	@Test
	public void New_Customer_15_PIN_Cannot_Be_Empty() {				
		log.info("New_Customer_15_PIN_Cannot_Be_Empty - Step 01: Enter to PIN textbox and then tab out");
		newCustomerPage.enterToDynamicTextboxByNameAndTabOut("PIN");
		
		log.info("New_Customer_15_PIN_Cannot_Be_Empty - Step 02: Verify the error message displayed correctly after tabing out PIN without value");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("PIN"),"PIN Code must not be blank");
				
	}
	@Test
	public void New_Customer_16_PIN_Must_Be_Numeric() {
		log.info("New_Customer_16_PIN_Must_Be_Numeric - Step 01: Enter a character to PIN textbox");
		newCustomerPage.inputToDynamicTextboxByName("PIN", "a"); 
		
		log.info("New_Customer_16_PIN_Must_Be_Numeric - Step 02: Verify the error message displayed correctly after entering a character to PIN");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("PIN"),"Characters are not allowed");
	}
	@Test
	public void New_Customer_17_PIN_Cannot_Have_Special_Character() {
		log.info("New_Customer_17_PIN_Cannot_Have_Special_Character - Step 01: Enter a special character to PIN textbox");
		newCustomerPage.inputToDynamicTextboxByName("PIN", "@"); 
		
		log.info("New_Customer_17_PIN_Cannot_Have_Special_Characterc - Step 02: Verify the error message displayed correctly after entering a special character to PIN");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("PIN"),"Special characters are not allowed");
	}
	@Test
	public void New_Customer_18_PIN_Cannot_Have_First_Character_As_Blank() {
		log.info("New_Customer_18_PIN_Cannot_Have_First_Character_As_Blank - Step 01: Enter a blank space to PIN textbox");
		newCustomerPage.inputToDynamicTextboxByName("PIN", " "); 
		
		log.info("New_Customer_18_PIN_Cannot_Have_First_Character_As_Blankc - Step 02: Verify the error message displayed correctly after entering a blank space to PIN");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("PIN"),"First character can not have space");
	}
	@Test
	public void New_Customer_19_PIN_Cannot_Have_Blank_Space() {
		log.info("New_Customer_19_PIN_Cannot_Have_Blank_Space - Step 01: Enter a string has blank space to PIN textbox");
		newCustomerPage.inputToDynamicTextboxByName("PIN", "111 11"); 
		
		log.info("New_Customer_19_PIN_Cannot_Have_Blank_Space - Step 02: Verify the error message displayed correctly after entering a string has blank space to PIN");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("PIN"),"Characters are not allowed");
	}
	@Test
	public void New_Customer_20_PIN_Must_Have_6_Digits() {
		log.info("New_Customer_20_PIN_Must_Have_6_Digits - Step 01: Enter a number that has less than 6 digits to PIN textbox");
		newCustomerPage.inputToDynamicTextboxByName("PIN", "123"); 
		
		log.info("New_Customer_20_PIN_Must_Have_6_Digits - Step 02: Verify the error message displayed correctly after entering a number that has less than 6 digits to PIN");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("PIN"),"PIN Code must have 6 Digits");
	}
	@Test
	public void New_Customer_21_Mobile_Number_Cannot_Be_Empty() {				
		log.info("New_Customer_21_Mobile_Number_Cannot_Be_Empty - Step 01: Enter to Mobile Number textbox and then tab out");
		newCustomerPage.enterToDynamicTextboxByNameAndTabOut("Mobile Number");
		
		log.info("New_Customer_21_Mobile_Number_Cannot_Be_Empty - Step 02: Verify the error message displayed correctly after tabing out Mobile Number without value");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("Mobile Number"),"Mobile no must not be blank");
				
	}
	@Test
	public void New_Customer_22_Mobile_Number_Must_Be_Numeric() {
		log.info("New_Customer_22_Mobile_Number_Must_Be_Numeric - Step 01: Enter a character to Mobile Number textbox");
		newCustomerPage.inputToDynamicTextboxByName("Mobile Number", "abc"); 
		
		log.info("New_Customer_22_Mobile_Number_Must_Be_Numeric - Step 02: Verify the error message displayed correctly after entering a character to Mobile Number");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("Mobile Number"),"Characters are not allowed");
	}
	@Test
	public void New_Customer_23_Mobile_Number_Cannot_Have_Special_Character() {
		log.info("New_Customer_23_Mobile_Number_Cannot_Have_Special_Character - Step 01: Enter a special character to Mobile Number textbox");
		newCustomerPage.inputToDynamicTextboxByName("Mobile Number", "@"); 
		
		log.info("New_Customer_23_Mobile_Number_Cannot_Have_Special_Characterc - Step 02: Verify the error message displayed correctly after entering a special character to Mobile Number");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("Mobile Number"),"Special characters are not allowed");
	}
	@Test
	public void New_Customer_24_Mobile_Number_Cannot_Have_First_Character_As_Blank() {
		log.info("New_Customer_24_Mobile_Number_Cannot_Have_First_Character_As_Blank - Step 01: Enter a blank space to Mobile Number textbox");
		newCustomerPage.inputToDynamicTextboxByName("Mobile Number", " "); 
		
		log.info("New_Customer_24_Mobile_Number_Cannot_Have_First_Character_As_Blankc - Step 02: Verify the error message displayed correctly after entering a blank space to Mobile Number");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("Mobile Number"),"First character can not have space");
	}
	@Test
	public void New_Customer_25_Email_Cannot_Be_Empty() {				
		log.info("New_Customer_25_Email_Cannot_Be_Empty - Step 01: Enter to Email textbox and then tab out");
		newCustomerPage.enterToDynamicTextboxByNameAndTabOut("E-mail");
		
		log.info("New_Customer_25_Email_Cannot_Be_Empty - Step 02: Verify the error message displayed correctly after tabing out Email without value");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("E-mail"),"Email-ID must not be blank");
				
	}
	@Test
	public void New_Customer_26_Email_Must_Be_In_Correct_Format() {
		log.info("New_Customer_26_Emailr_Must_Be_In_Correct_Format - Step 01: Enter a character to Mobile Number textbox");
		newCustomerPage.inputToDynamicTextboxByName("E-mail", "abc"); 
		
		log.info("New_Customer_26_Email_Must_Be_In_Correct_Format - Step 02: Verify the error message displayed correctly after entering a character to Email");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("E-mail"),"Email-ID is not valid");
	}
	@Test
	public void New_Customer_27_Email_Cannot_Have_Space() {
		log.info("New_Customer_27_Email_Cannot_Have_Space - Step 01: Enter a special character to Email textbox");
		newCustomerPage.inputToDynamicTextboxByName("E-mail", "abc@abc @abc"); 
		
		log.info("New_Customer_27_Email_Cannot_Have_Space - Step 02: Verify the error message displayed correctly after entering a special character to Email");
		verifyEquals(newCustomerPage.getErrorMesageDisplayedNextToDynamicTextbox("E-mail"),"Email-ID is not valid");
	}
	@Test
	public void New_Customer_28_Create_A_New_Customer() {
		log.info("New_Customer_28_Create_A_New_Customer - Step 01: Input a value to Customer Name textbox");
		newCustomerPage.inputToDynamicTextboxByName("Customer Name", customerName);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 02: Input a value to Date of Birth textbox");
		newCustomerPage.inputToDOBTextboxByJS(DOB);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 03: Input a value to Address textbox");
		newCustomerPage.inputToAddressTextbox(address);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 04: Input a value to City textbox");
		newCustomerPage.inputToDynamicTextboxByName("City", city);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 05: Input a value to State textbox");
		newCustomerPage.inputToDynamicTextboxByName("State", state);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 06: Input a value to PIN textbox");
		newCustomerPage.inputToDynamicTextboxByName("PIN", PIN);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 07: Input a value to Mobile Number textbox");
		newCustomerPage.inputToDynamicTextboxByName("Mobile Number", mobileNumber);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 08: Input a value to E-mail textbox");
		newCustomerPage.inputToDynamicTextboxByName("E-mail", emailAdd);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 09: Input a value to Password textbox");
		newCustomerPage.inputToDynamicTextboxByName("Password", userPassword);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 10: Click on Submit button");
		newCustomerPage.clickToSubmitButton();
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 11: Verify the success message displayed after creating new customer");
		verifyTrue(newCustomerPage.isCreatedNewCustomerSuccessMessageDisplayed());
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 12: Get Customer ID value on customer detail info after created");
		customerID = newCustomerPage.getCustomerInfoByFieldName("Customer ID");
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 13: Verify the created Customer Name is matched the name input");
		verifyEquals(newCustomerPage.getDetailInfoOfCreatedCustomerByFieldName("Customer Name"), customerName);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 14: Verify the created Customer Address is matched the addres input");
		verifyEquals(newCustomerPage.getDetailInfoOfCreatedCustomerByFieldName("Address"), address);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 15: Verify the created Customer City is matched the city input");
		verifyEquals(newCustomerPage.getDetailInfoOfCreatedCustomerByFieldName("City"), city);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 16: Verify the created Customer State is matched the state input");
		verifyEquals(newCustomerPage.getDetailInfoOfCreatedCustomerByFieldName("State"), state);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 17: Verify the created Customer PIN is matched the PIN input");
		verifyEquals(newCustomerPage.getDetailInfoOfCreatedCustomerByFieldName("Pin"), PIN);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 18: Verify the created Customer Mobile is matched the Mobile input");
		verifyEquals(newCustomerPage.getDetailInfoOfCreatedCustomerByFieldName("Mobile No."), mobileNumber);
		
		log.info("New_Customer_28_Create_A_New_Customer - Step 19: Verify the created Customer Email is matched the Email input");
		verifyEquals(newCustomerPage.getDetailInfoOfCreatedCustomerByFieldName("Email"), emailAdd);
		
	}
	
	  @AfterTest(alwaysRun = true) 
	  public void afterClass() { driver.quit();
	  }
	 
	 
	 
	
	 
}