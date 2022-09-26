package com.nopcommerce.user;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig2.ExtentTestManagerV5;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.lang.reflect.Method;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_15_ExtendV5_Screenshot extends BaseTest {
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
	public void User_01_Register(Method method) {
	ExtentTestManagerV5.startTest(method.getName(), "Register to system with valid Email and Password");
	ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
	registerPage = homePage.clickToRegisterLink();

	ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
	registerPage.inputToFirstnameTextbox(firstName);

	ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
	registerPage.inputToLastnameTextbox(lastName);

	ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is '" + email + "'");
	registerPage.inputToEmailTextbox(email);

	ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is '" + password + "'");
	registerPage.inputToPasswordTextbox(password);

	ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
	registerPage.inputToConfirmPasswordTextbox(password);

	ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 07: Click to 'Register' button");
	registerPage.clickToRegisterButton();

	ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is displayed");
	Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void User_02_Login(Method method) {
	ExtentTestManagerV5.startTest(method.getName(), "Login to system successfully");
	ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
	homePage = registerPage.clickToLogoutLink();
	loginPage = homePage.clickToLoginLink();

	ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox with value is '" + email + "'");
	loginPage.inputToEmailTextbox(email);

	ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox with value is '" + password + "'");
	loginPage.inputToPasswordTextbox(password);

	ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
	homePage = loginPage.clickToLoginButton();

	ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
	Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

	ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 06: Navigate to 'My Account' page");
	customerInfoPage = homePage.clickToMyAccountLink();

	ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 06: Verify 'Customer Infor' page is displayed");
	Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplay());
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