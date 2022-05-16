package com.jquery.uploadfile;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomepageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	String javaFile = "Java.png";
	String rubyFile = "Ruby.png";
	String pythonFile = "Python.png";
	String[] multipleFileName = { javaFile, rubyFile, pythonFile };
	WebDriver driver;
	HomepageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		// step 01 - Load single file
		homePage.uploadMultipleFiles(driver, javaFile);

		// step 02 - Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(javaFile));

		// Step 03 - Click to Start button
		homePage.clickToStartButton();

		// Step 04 - Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFile));

		// Step 05 - Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFile));
	}

	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurentPage(driver);
		// Step 01 - Load multiple files
		homePage.uploadMultipleFiles(driver, multipleFileName);

		// step 02 - Verify multiple files loaded success
		// javaFile/ rubyFile/ pythonFile
		Assert.assertTrue(homePage.isFileLoadedByName(javaFile));
		Assert.assertTrue(homePage.isFileLoadedByName(rubyFile));
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFile));

		// Step 03 - Click to Start button
		homePage.clickToStartButton();

		// Step 04 - Verify multiple files link uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFile));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(rubyFile));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(pythonFile));

		// Step 05 - Verify multiple files image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFile));
		Assert.assertTrue(homePage.isFileImageUploadedByName(rubyFile));
		Assert.assertTrue(homePage.isFileImageUploadedByName(pythonFile));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
