package com.liveguru.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.LoginPageObject;
import pageObject.liveGuru.MyDashboardPageObject;
import pageObject.liveGuru.PageGeneratorManager;
import pageObject.liveGuru.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager_III extends BaseTest{	

	private WebDriver driver;
	private String firstName, lastName, email, password;
	private String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private MyDashboardPageObject myDashboardPage;
	private LoginPageObject loginPage;
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://live.techpanda.org/index.php");
	  
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
	  firstName = "anh";
	  lastName = "hoang";
	  email = "hta" + generateFakeNumber() + "@gmail.com";
	  password = "123456";
  }
  @Test
  public void User_01_Register_To_System() {
	  homePage.clickToAccountIcon();
	  registerPage = homePage.clickToRegisterLink();
	  registerPage.inputToFirstnameTextbox(firstName);
	  registerPage.inputToLastnameTextbox(lastName);
	  registerPage.inputToEmailTextbox(email);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  myDashboardPage = registerPage.clickToRegisterButton();
	  Assert.assertEquals(myDashboardPage.getRegisterSuccessMessage(),"Thank you for registering with Main Website Store.");
	  myDashboardPage.clickToAccountIcon();
	  homePage = myDashboardPage.clickToLogoutLink();
  }
	 @Test
	 public void User_02_Login_To_System() {
		 homePage.clickToAccountIcon();
		 loginPage = homePage.clickToLoginLink();
		 loginPage.inputEmailAddress(email);
		 loginPage.inputPassword(password);
		 myDashboardPage = loginPage.clickToLoginButton();
		 Assert.assertEquals(myDashboardPage.getLoginSuccessMessage(),"Hello, " + firstName + " " + lastName + "!");
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
