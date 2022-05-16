package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;

import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_14_Log_ReportNG extends BaseTest {
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
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);
		
		log.info("Register - Step 04: Enter to Email textbox with value is '" + email + "'");
		registerPage.inputToEmailTextbox(email);
		
		log.info("Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 06: Enter to Confirm password textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 08: Verify register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed....a");
		
		log.info("Register - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();

		
	}
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Enter to Email textbox with value is ' " + email + "'");
		loginPage.inputToEmailTextbox(email);
		
		log.info("Login - Step 03: Enter to Password textbox with value is ' " + password + "'");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: Verify 'My account' link is displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());		
		
		log.info("Login - Step 06: Navigate to 'My account' page");
		customerInfoPage = homePage.clickToMyAccountLink();
		
		log.info("Login - Step 07: Verify 'Customer Info page is displayed");
		verifyFalse(customerInfoPage.isCustomerInfoPageDisplay());
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
