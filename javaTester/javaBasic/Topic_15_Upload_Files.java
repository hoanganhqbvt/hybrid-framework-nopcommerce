package javaBasic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveGuru.HomePageObject;

public class Topic_15_Upload_Files extends BaseTest{
	String javaFile = "Java.png";
	String rubyFile = "Ruby.png";
	String pythonFile = "Python.png";
	String[] multipleFileName = {javaFile, rubyFile, pythonFile};
	WebDriver driver;
	HomePageObject homePage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
	}
	
	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, javaFile);
	}
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, multipleFileName);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
