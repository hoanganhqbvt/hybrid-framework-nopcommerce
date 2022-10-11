package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import commons.BaseTest;
import pageObject.bankGuru.user.PageGeneratorManagerBankGuru;
import pageObject.bankGuru.user.RegisterPageObject;

public class PreConditionGetAccessInfo extends BaseTest{
	WebDriver driver;
	private RegisterPageObject registerPage;
	int fakeNumber = generateFakeNumber();
	String emailAdd = "automation" + fakeNumber +"@gmail.com";
	String userID, password;
	
	@Parameters({ "browser", "registerUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String registerUrl) {
	log.info("Pre-condition - Step 01: Open browser and access register URL");
	driver = getBrowserDriver(browserName, registerUrl);
	registerPage = PageGeneratorManagerBankGuru.getRegisterPage(driver);
	
	}
	public  void  main(String[] args) {
		
	log.info("Pre-condition - Step 02: Input email to Email ID textbox to get detail access info");
	registerPage.inputToEmailIDTextbox(emailAdd);
	
	log.info("Pre-condition - Step 03: Click on Submit button");
	registerPage.clickToSubmitButton();
	
	log.info("Pre-condition - Step 04: Get User ID info");
	userID = registerPage.getDetailAccessInfoByText("User ID :");
	
	log.info("Pre-condition - Step 05: Get User ID info");
	password = registerPage.getDetailAccessInfoByText("Password :");
}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
	driver.quit();
	
}
}