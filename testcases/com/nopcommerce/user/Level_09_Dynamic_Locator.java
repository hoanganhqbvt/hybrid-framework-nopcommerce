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

public class Level_09_Dynamic_Locator extends BaseTest {
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
	public void User_01_Register_Login() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();

		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());		

		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplay());
	}

	@Test
	public void User_02_Switch_Page() {
		// customer info -> address
		addressPage = customerInfoPage.openAddressPage(driver);
		
		// address -> reward point
		rewardPointPage = addressPage.openRewardPointPage(driver);
		
		// reward -> my product review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);

	}
	
	@Test
	public void User_03_Dynamic_Page_01() {
		// my product review -> reward point
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Reward points");
		
		// reward point -> address
		addressPage = (UserAddressPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "Addresses");
		
		// address -> reward point
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPageAtMyAccountByName(driver, "Reward points");
		
		// reward point -> My product review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "My product reviews");
		
		// my product review -> customer info
		customerInfoPage = (UserCustomerInfoPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Customer info");
	}

	@Test
	public void User_03_Dynamic_Page_02() {
		
		// Customer info -> my product review
		customerInfoPage.openPageAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		// my product review -> reward point
		myProductReviewPage.openPageAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		// reward point -> address
		rewardPointPage.openPageAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		
		// address -> reward point
		addressPage.openPageAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		// reward point -> My product review
		rewardPointPage.openPageAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		// my product review -> customer info
		myProductReviewPage.openPageAtMyAccountByPageName(driver, "Customer info");
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
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
