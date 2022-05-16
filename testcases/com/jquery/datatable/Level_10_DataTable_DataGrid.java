package com.jquery.datatable;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomepageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	HomepageObject homePage;
	private WebDriver driver;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	//@Test
	public void Table_01_Paging() {
		homePage.openPagingByNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNuumberActived("10"));
		
		homePage.openPagingByNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNuumberActived("20"));
		
		homePage.openPagingByNumber("7");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNuumberActived("7"));
		
		homePage.openPagingByNumber("18");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNuumberActived("18"));
	}
	//@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurentPage(driver);
		
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");	
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
		homePage.sleepInSecond(2);
		
		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Females", "276880");
		homePage.enterToHeaderTextboxByLabel("Males", "276472");	
		homePage.enterToHeaderTextboxByLabel("Total", "553353");
		homePage.sleepInSecond(2);
	}
	//@Test
	public void Table_03_GetValueonPage() {
		// Đọc dữ liệu của file country.txt
		// Lưu vào 1 List<String> = Expected value
		//List<String> expected = expectedAllCountryValues;
		
		//actual values
		actualAllCountryValues = homePage.getValueEachRowAtAllPage(); 
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}
	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(3);
		// Value nhập liệu - tham số 1
		// Row bumber: tại row nào
		// Ex: Nhập vào textbox tại dòng số 3/ 5/ 2
		// Column name: Album/ Artist/ Year/ Price
		homePage.enterToTextboxByColumnNameAtRowNumber("Album", "2", "Michael Jackson");
		//homePage.sleepInSecond(1);
		
		homePage.enterToTextboxByColumnNameAtRowNumber("Artist", "4", "Dance");
		//homePage.sleepInSecond(1);
		
		homePage.enterToTextboxByColumnNameAtRowNumber("Year", "3", "1999");
		//homePage.sleepInSecond(1);
		
		homePage.enterToTextboxByColumnNameAtRowNumber("Price", "1", "150");
		//homePage.sleepInSecond(1);
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin","5", "Japan");
		//homePage.sleepInSecond(1);
		
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "1");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "2");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "4");
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "3");
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "5");
		
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Insert Row Above");
		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.clickToIconByRowNumber("1", "Move Down");
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
