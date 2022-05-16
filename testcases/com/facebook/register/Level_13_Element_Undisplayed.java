package com.facebook.register;

import org.testng.annotations.Test;

import commons.BaseTest;

import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateAccountButton();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
		
	}
	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		// Verify True - mong đợi Confirm email displayed
		
		loginPage.enterToEmailAddressTextbox("hta@gmail.com");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailTextboxDisplayed());
		
		// Verify False - mong đợi Confirm email Undisplayed
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(2);
		//verifyFalse(loginPage.isConfirmEmailTextboxDisplayed());
		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayed());
	}
	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickCloseIconAtRegisterFomr();
		loginPage.sleepInSecond(2);
		// verifyFalse(loginPage.isConfirmEmailTextboxDisplayed());
		 
		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayed());
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
