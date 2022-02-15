package com.nopcommerce.user;

import org.testng.annotations.Test;

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager_II {	
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;
	private String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
	  
	  homePage = new HomePageObject(driver);
	  
	  firstName = "Automation";
	  lastName = "FC";	  
	  invalidEmail = "afc@afc.com@.vn";
	  existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
	  notFoundEmail = "afc" + generateFakeNumber() + "@mail.com";
	  validPassword = "123456";
	  incorrectPassword  = "1236554";
	  System.out.println("Pre-condition - Step 01: Click to Register link");
	  registerPage = homePage.clickToRegisterLink();
	// Click to Register link -> nhảy qua trang Register -> phải khởi tạo RegisterPageObject
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
  }

  @Test
  public void Login_01_Empty_Data() {
	  loginPage = homePage.clickToLoginLink();
	  // click to Login link -> chuyển qua loginPage
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
  }
  @Test
  public void Login_02_Invalid_Email() {
	  loginPage = homePage.clickToLoginLink();
	  // click to Login link -> chuyển qua loginPage
	  
	  loginPage.inputToEmailTextbox(invalidEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
  }
  @Test
  public void Login_03_Email_Not_Found() {	    
	  loginPage = homePage.clickToLoginLink();
	  // click to Login link -> chuyển qua loginPage
	  
	  loginPage.inputToEmailTextbox(notFoundEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\n"
	  		+ "No customer account found");

  }
  @Test
  public void Login_04_Existing_Email_Empty_Password() {
	  loginPage = homePage.clickToLoginLink();
	  // click to Login link -> chuyển qua loginPage
	  
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox("");
	  loginPage.clickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\n"
		  		+ "The credentials provided are incorrect");
  }
  @Test
  public void Login_05_Existing_Email_Wrong_Password() {
	  loginPage = homePage.clickToLoginLink();
	  // click to Login link -> chuyển qua loginPage
	  
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox(incorrectPassword);
	  loginPage.clickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\n"
		  		+ "The credentials provided are incorrect");
	  
	  
  }
  
  @Test
  public void Login_06_Existing_Email_Correct_Password() {
	  loginPage = homePage.clickToLoginLink();
	  // click to Login link -> chuyển qua loginPage
	  
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox(validPassword);
	  homePage = loginPage.clickToLoginButton();
	  
	  // Login thành công -> quay lại HomePage
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
