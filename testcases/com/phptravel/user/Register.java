package com.phptravel.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.phpTravel.user.PageGeneratorManagerPHPTravel;
import pageObjects.phpTravel.user.UserLandingPageObject;
import pageObjects.phpTravel.user.UserRegisterPageObjectPHPTravel;

public class Register extends BaseTest{
	WebDriver driver;
	private UserLandingPageObject userLandingPage;
	private UserRegisterPageObjectPHPTravel userRegisterPage;
	
	@Parameters({"browser", "userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String userURL) {
		log.info("Pre-condition - Step 01: Open browser");
		driver = getBrowserDriver(browserName, userURL);
		userLandingPage = PageGeneratorManagerPHPTravel.getUserLandingPage(driver);
	}
	@Test
	public void Register_01_Register_With_Emty_Data() {
		log.info("Register_01_Register_With_Emty_Data - Step 01: Click on Customer Signup link");
		userRegisterPage = userLandingPage.clickToOptionsInAccountMenu("Customer Signup");
		
		log.info("Register_01_Register_With_Emty_Data - Step 02: Click on Got it button to close Cookie confirm");
		userRegisterPage.clickToGotItButtonOnCookieConfirmation();
		
		log.info("Register_01_Register_With_Emty_Data - Step 03: Click on Signup button with empty data");
		userRegisterPage.clickToSignupButton();
		
		log.info("Register_01_Register_With_Emty_Data - Step 04: Verify required error message displayed when signing up with empty data 'Please enter all credentials to signup'");
		verifyTrue(userRegisterPage.isRequiredErrorMessageDisplayed());
		
	}
}
