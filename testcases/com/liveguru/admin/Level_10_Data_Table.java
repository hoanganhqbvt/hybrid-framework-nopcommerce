package com.liveguru.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveGuru.AdminHomePageObject;
import pageObject.liveGuru.AdminLoginPageObject;
import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.PageGeneratorManager;
import pageObject.liveGuru.RegisterPageObject;


public class Level_10_Data_Table extends BaseTest{
	private RegisterPageObject registerPage;
	private WebDriver driver;
	private HomePageObject homePage;
	private AdminHomePageObject adminHomePage;
	private AdminLoginPageObject adminLoginPage;
	private String adminUsername = "user01";
	private String adminPassword = "guru99com";
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}	
	
	@Test
	public void registerAnAccount() {
		homePage.clickToAccountIcon();
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox("AutomationFC");
		registerPage.inputToLastnameTextbox("HTA");
		registerPage.inputToEmailTextbox("htaautomationfc@gmail.com");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		driver.quit();
		
	}
	@Test
	public void verifyCreatedAccountOnWebAdmin() {
		driver.get("http://live.techpanda.org/index.php/backendlogin/customer/");
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.inputUsername(adminUsername);
		adminLoginPage.inputPassword(adminPassword);
		adminLoginPage.clickToLoginButton();
		adminHomePage = PageGeneratorManager.getAdminHomePage(driver);
		adminHomePage.closePopup();
		
		
	}
}
