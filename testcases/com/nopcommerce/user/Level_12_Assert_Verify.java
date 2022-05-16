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

public class Level_12_Assert_Verify extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
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
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed....a");
		homePage = registerPage.clickToLogoutLink();

		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		verifyFalse(homePage.isMyAccountLinkDisplayed());		

		customerInfoPage = homePage.clickToMyAccountLink();
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
