package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_05_Page_Factory extends BaseTest {	
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;
	private UserHomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
  public void beforeClass(String browserName, String environmentName) {
		environmentName = "DEV";
	  driver = getBrowserDriver(browserName, environmentName);
	  
	  homePage = new UserHomePageObject(driver);
	  registerPage = new RegisterPageObject(driver);
	  firstName = "Automation";
	  lastName = "FC";	  
	  invalidEmail = "afc@afc.com@.vn";
	  existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
	  notFoundEmail = "afc" + generateFakeNumber() + "@mail.com";
	  validPassword = "123456";
	  incorrectPassword  = "1236554";
	  System.out.println("Pre-condition - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	// Click to Register link -> nhảy qua trang Register -> phải khởi tạo RegisterPageObject
	  registerPage = new RegisterPageObject(driver);
		  
	  System.out.println("Pre-condition- Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox(existingEmail);
	  registerPage.inputToPasswordTextbox(validPassword);
	  registerPage.inputToConfirmPasswordTextbox(validPassword);

	  System.out.println("Pre-condition - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Pre-condition - Step 04: Verify success message displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	  
	  System.out.println("Pre-condition - Step 05: Click to logout link");
	  registerPage.clickToLogoutLink();
	  // Click logout thì sẽ quay về trang HomePage, khởi tạo lại homePage object
	  homePage = new UserHomePageObject(driver);
  }

  @Test
  public void Login_01_Empty_Data() {
	  homePage.clickToLoginLink();
	  // click to Login link -> chuyển qua loginPage
	  loginPage = new LoginPageObject(driver);
	  loginPage.clickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
  }
  @Test
  public void Login_02_Invalid_Email() {
	  homePage.clickToLoginLink();
	  // click to Login link -> chuyển qua loginPage
	  loginPage = new LoginPageObject(driver);
	  
	  loginPage.inputToEmailTextbox(invalidEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
  }
  @Test
  public void Login_03_Email_Not_Found() {	    
	  homePage.clickToLoginLink();
	  // click to Login link -> chuyển qua loginPage
	  loginPage = new LoginPageObject(driver);
	  
	  loginPage.inputToEmailTextbox(notFoundEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\n"
	  		+ "No customer account found");

  }
  @Test
  public void Login_04_Existing_Email_Empty_Password() {
	  homePage.clickToLoginLink();
	  // click to Login link -> chuyển qua loginPage
	  loginPage = new LoginPageObject(driver);
	  
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox("");
	  loginPage.clickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\n"
		  		+ "The credentials provided are incorrect");
  }
  @Test
  public void Login_05_Existing_Email_Wrong_Password() {
	  homePage.clickToLoginLink();
	  // click to Login link -> chuyển qua loginPage
	  loginPage = new LoginPageObject(driver);
	  
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox(incorrectPassword);
	  loginPage.clickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\n"
		  		+ "The credentials provided are incorrect");
	  
	  
  }
  
  @Test
  public void Login_06_Existing_Email_Correct_Password() {
	  homePage.clickToLoginLink();
	  // click to Login link -> chuyển qua loginPage
	  loginPage = new LoginPageObject(driver);
	  
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox(validPassword);
	  loginPage.clickToLoginButton();
	  
	  // Login thành công -> quay lại HomePage
	  homePage = new UserHomePageObject(driver);
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	  homePage.clickToMyAccountLink();
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