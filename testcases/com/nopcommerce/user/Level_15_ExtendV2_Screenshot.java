package com.nopcommerce.user;

import org.testng.annotations.Test;
//import com.relevantcodes.extentreports.LogStatus;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
//import reportConfig2.ExtentTestManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.lang.reflect.Method;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_15_ExtendV2_Screenshot extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl ) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = new UserRegisterPageObject(driver);
		firstName = "Automation";
		lastName = "FC";
		email = "afc" + generateFakeNumber() + "@mail.vn";
		password = "123456";

	}

	@Test
	/*
	 * public void User_01_Register(Method method) {
	 * ExtentTestManager.startTest(method.getName(), "User_01_Register");
	 * ExtentTestManager.getTest().log(LogStatus.INFO,
	 * "Register - Step 01: Navigate to 'Register' page"); registerPage =
	 * homePage.clickToRegisterLink();
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.INFO,
	 * "Register - Step 02: Enter to Firstname textbox with value is '" + firstName
	 * + "'"); registerPage.inputToFirstnameTextbox(firstName);
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.INFO,
	 * "Register - Step 03: Enter to Lastname textbox with value is '" + lastName +
	 * "'"); registerPage.inputToLastnameTextbox(lastName);
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.INFO,
	 * "Register - Step 04: Enter to Email textbox with value is '" + email + "'");
	 * registerPage.inputToEmailTextbox(email);
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.INFO,
	 * "Register - Step 05: Enter to Password textbox with value is '" + password +
	 * "'"); registerPage.inputToPasswordTextbox(password);
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.INFO,
	 * "Register - Step 06: Enter to Confirm password textbox with value is '" +
	 * password + "'"); registerPage.inputToConfirmPasswordTextbox(password);
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.INFO,
	 * "Register - Step 07: Click to 'Register' button");
	 * registerPage.clickToRegisterButton();
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.INFO,
	 * "Register - Step 08: Verify register success message is displayed");
	 * assertEquals(registerPage.getRegisterSuccessMessage(),
	 * "Your registration completed....a"); ExtentTestManager.endTest(); }
	 * 
	 * @Test public void User_02_Login(Method method) {
	 * ExtentTestManager.startTest(method.getName(), "User_012_Login");
	 * ExtentTestManager.getTest().log(LogStatus.
	 * INFO,"Pre_Condition_Logout: Click to Logout link"); homePage =
	 * registerPage.clickToLogoutLink();
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 01: Navigate to 'Login' page"); loginPage =
	 * homePage.clickToLoginLink();
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 02: Enter to Email textbox with value is ' " + email +
	 * "'"); loginPage.inputToEmailTextbox(email);
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 03: Enter to Password textbox with value is ' " + password
	 * + "'"); loginPage.inputToPasswordTextbox(password);
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 04: Click to Login button"); homePage =
	 * loginPage.clickToLoginButton();
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 05: Verify 'My account' link is displayed");
	 * assertFalse(homePage.isMyAccountLinkDisplayed());
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 06: Navigate to 'My account' page"); customerInfoPage =
	 * homePage.clickToMyAccountLink();
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 07: Verify 'Customer Info page is displayed");
	 * assertFalse(customerInfoPage.isCustomerInfoPageDisplay());
	 * ExtentTestManager.endTest(); }
	 */
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
