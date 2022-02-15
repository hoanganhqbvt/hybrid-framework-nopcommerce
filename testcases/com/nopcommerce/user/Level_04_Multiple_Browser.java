package com.nopcommerce.user;

import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_04_Multiple_Browser extends BaseTest{	
	private WebDriver driverTestClass;
	private String firstName, lastName, emailAddress, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	
	@Parameters("browser")
	@BeforeClass
  public void beforeClass(String browserName) {
	driverTestClass = getBrowserDriver(browserName);		
	  
	// Mở URL lên qua trang HomePage
	homePage = new HomePageObject(driverTestClass);
	  
	  firstName = "Automation";
	  lastName = "FC";	  
	  emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
	  password = "123456";
}

  @Test
  public void Register_01_Empty_Data() {
	  System.out.println("Home Page - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  // Click to Register link -> nhảy qua trang Register -> phải khởi tạo RegisterPageObject
	  registerPage = new RegisterPageObject(driverTestClass);
	  
	  System.out.println("Home Page - Step 02: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Home Page - Step 03: Vefify error message displayed");
	  Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	  
	  
  }
  @Test
  public void Register_02_Invalid_Email() {
	  
	  System.out.println("Home Page - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	// Click to Register link -> nhảy qua trang Register -> phải khởi tạo RegisterPageObject
	  registerPage = new RegisterPageObject(driverTestClass);
		  
	  System.out.println("Home Page - Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox("abc#123.123");
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  System.out.println("Home Page - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Home Page - Step 04: Vefify error message displayed");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	  
  }
  @Test
  public void Register_03_Register_Success() {	    
	  System.out.println("Home Page - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	// Click to Register link -> nhảy qua trang Register -> phải khởi tạo RegisterPageObject
	  registerPage = new RegisterPageObject(driverTestClass);
		  
	  System.out.println("Home Page - Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);

	  System.out.println("Home Page - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Home Page - Step 04: Verify success message displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	  
	  System.out.println("Home Page - Step 05: Click to logout link");
	  registerPage.clickToLogoutLink();

  }
  @Test
  public void Register_04_Register_Existing_Email() {
	  
	  System.out.println("Home Page - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	// Click to Register link -> nhảy qua trang Register -> phải khởi tạo RegisterPageObject
	  registerPage = new RegisterPageObject(driverTestClass);

	  System.out.println("Home Page - Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);

	  System.out.println("Home Page - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Home Page - Step 04: Verify error existing email message displayed");
	  Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	 	  
  }
  @Test
  public void Register_05_Register_Password_Less_Than_6_Chars() {
	  
	  System.out.println("Home Page - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();	  
	// Click to Register link -> nhảy qua trang Register -> phải khởi tạo RegisterPageObject
	  registerPage = new RegisterPageObject(driverTestClass);
	  
	  System.out.println("Home Page - Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);	  
	  registerPage.inputToPasswordTextbox("123");
	  registerPage.inputToConfirmPasswordTextbox("123");

	  System.out.println("Home Page - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Home Page - Step 04: Verify error message displayed");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\n"
		  		+ "must have at least 6 characters");
	  
  }
  
  @Test
  public void Register_06_Register_Invalid_Confirm_Password() {
	  System.out.println("Home Page - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();	  
	// Click to Register link -> nhảy qua trang Register -> phải khởi tạo RegisterPageObject
	  registerPage = new RegisterPageObject(driverTestClass);
	  
	  System.out.println("Home Page - Step 02: Input to required fields");
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(emailAddress);

	  System.out.println("Home Page - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Home Page - Step 04: Verify error message displayed");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");		  
	  
  }
  @AfterClass
  public void afterClass() {
	  driverTestClass.quit();
  }
  
  public int generateFakeNumber() {
	  Random rand = new Random();
	  return rand.nextInt(9999);
	 }
	

}
