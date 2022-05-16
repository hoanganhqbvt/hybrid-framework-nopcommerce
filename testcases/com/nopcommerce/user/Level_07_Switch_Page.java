package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserCustomerInfoPageObject customerInfoPage;

	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		environmentName = "DEV";
		driver = getBrowserDriver(browserName, environmentName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = new UserRegisterPageObject(driver);
		firstName = "Automation";
		lastName = "FC";
		email = "afc" + generateFakeNumber() + "@mail.vn";
		password = "123456";

	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());		
	}

	@Test
	public void User_03_Customer_Info() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplay());
	}

	@Test
	public void User_04_Switch_Page() {
		addressPage = customerInfoPage.openAddressPage(driver);
		
		rewardPointPage = addressPage.openRewardPointPage(driver);
		
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		
		customerInfoPage = myProductReviewPage.openCustomerInfoPage(driver);
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
