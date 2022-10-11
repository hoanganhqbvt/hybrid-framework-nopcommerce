package com.bankguru.user;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.bankGuru.user.EditAccountPO;
import pageObject.bankGuru.user.LoginPageObject;
import pageObject.bankGuru.user.ManagerPageObject;
import pageObject.bankGuru.user.NewAccountPO;
import pageObject.bankGuru.user.PageGeneratorManagerBankGuru;

public class Payment extends BaseTest{
	WebDriver driver;
	private ManagerPageObject managerPage;
	private NewAccountPO newAccountPage;
	private LoginPageObject loginPageObject;
	private EditAccountPO editAccountPage;
	String userID = "mngr442995", password = "myzEqYt";
	String customerID = "41128";
	String initialDeposit = "1200";
	String accountType = "Current";
	String accountID;
	
	@Parameters({ "browser", "loginUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String loginUrl) {
		log.info("Pre-condition - Step 01: Open browser and access login URL");
		driver = getBrowserDriver(browserName, loginUrl);
		loginPageObject = PageGeneratorManagerBankGuru.getLoginPage(driver);
		
		log.info("Pre-condition - Step 02: Input to UserID textbox to login");
		loginPageObject.inputToUserIDPasswordTextbox("UserID", userID);
		
		log.info("Pre-condition - Step 03: Input to Password textbox to login");
		loginPageObject.inputToUserIDPasswordTextbox("Password", password);
		
		log.info("Pre-condition - Step 04: Click on Login button");
		managerPage = loginPageObject.clickToLoginButton();
}
	
	@Test
	public void Payment_01_Create_New_Customer_Account() {
		log.info("Payment_01_Create_New_Customer_Account - Step 01: Open New Account page");
		managerPage.openPageOnManagerPageByName(driver, "New Account");
		newAccountPage = PageGeneratorManagerBankGuru.getNewAccountPage(driver);
		
		log.info("Payment_01_Create_New_Customer_Account - Step 02: Input to Customer ID textbox");
		newAccountPage.inputToNewAccountTextboxByName("Customer id", customerID);
		
		log.info("Payment_01_Create_New_Customer_Account - Step 03: Select Account Type in dropdown list that is: " + accountType);
		newAccountPage.selectAccountTypeIndropdownList(accountType);
		
		log.info("Payment_01_Create_New_Customer_Account - Step 04: Input to Initial Deposit textbox a value is: " + initialDeposit);
		newAccountPage.inputToNewAccountTextboxByName("Initial deposit", initialDeposit);
		
		log.info("Payment_01_Create_New_Customer_Account - Step 05: Click on Submit button");
		newAccountPage.clickToSubmitButton();
		
		log.info("Payment_01_Create_New_Customer_Account - Step 06: Verify success created new account message displayed");
		verifyTrue(newAccountPage.isSuccessCreatedNewAccountMessageDisplayed());
		
		log.info("Payment_01_Create_New_Customer_Account - Step 07: Get Account ID of created Account");
		accountID = newAccountPage.getDetailInfoOfCreatedAccountByFieldName("Account ID");
		System.out.println(accountID);
		
		log.info("Payment_01_Create_New_Customer_Account - Step 08: Verify Customer ID is displayed correctly");
		verifyEquals(newAccountPage.getDetailInfoOfCreatedAccountByFieldName("Customer ID"), customerID);
		
		log.info("Payment_01_Create_New_Customer_Account - Step 09: Verify Account type is displayed correctly");
		verifyEquals(newAccountPage.getDetailInfoOfCreatedAccountByFieldName("Account Type"), accountType);
		
		log.info("Payment_01_Create_New_Customer_Account - Step 10: Verify current amount is displayed correctly = initila deposit");
		verifyEquals(newAccountPage.getDetailInfoOfCreatedAccountByFieldName("Current Amount"), initialDeposit);
		
		log.info("Payment_01_Create_New_Customer_Account - Step 11: Verify the open account date is displayed correctly = the current date of system");		
		LocalDate currentDate = java.time.LocalDate.now();
		System.out.println(currentDate);
		verifyEquals(newAccountPage.getDetailInfoOfCreatedAccountByFieldName("Date of Opening"), String.valueOf(currentDate));
	}
	
	@Test
	public void Payment_02_Edit_Customer_Account() {
		log.info("Payment_02_Edit_Customer_Account - Step 01: Open Edit account page");
		newAccountPage.openPageOnManagerPageByName(driver, "Edit Account");
		editAccountPage = PageGeneratorManagerBankGuru.getEditAccountPage(driver);
		
		log.info("Payment_02_Edit_Customer_Account - Step 02: Input to Account Number textbox to open Edit account page");
		editAccountPage.inputToAccountIDTextbox(accountID);
		
		log.info("Payment_02_Edit_Customer_Account - Step 03: Click on Submit button");
		editAccountPage.clickToSubmitButton();
		
		
		
		
	}
}