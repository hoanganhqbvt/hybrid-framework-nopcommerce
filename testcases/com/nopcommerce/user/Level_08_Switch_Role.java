package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String userEmailAddress, adminEmailAddress, userPassword, adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		environmentName = " DEV";
		driver = getBrowserDriver(browserName, environmentName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userEmailAddress = "hta@gmail.com";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void Role_01_User() {
		userLoginPage = userHomePage.openUserLoginPage(driver);
		
		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_02_Admin() {
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_TESTING_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		// Login as Admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplay());
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
