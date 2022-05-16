package javaBasic;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(commons.MethodListener.class)
public class Topic_17_Assert extends BaseTest{
WebDriver driver;
@BeforeClass
public void beforeClass() {
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://demo.guru99.com/v4/");
}
@Test
public void TC_01_VallidateCurrentURL() {
	System.out.println("Assert 01");
	String loginPageUrl = driver.getCurrentUrl();
	verifyEquals(loginPageUrl, "https://demo.guru99.com/v4/");

	System.out.println("Assert 02");
	String loginPageTitle = driver.getTitle(); 
	verifyEquals(loginPageTitle, "Guru99 Bank Home Page...");
	
	System.out.println("Assert 03");
	verifyEquals(loginPageTitle, "Guru99 Bank Home Page...3");
	
	System.out.println("Assert 04");
	verifyTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
	
}
@AfterClass
public void afterClass() {
	driver.quit();
}
}
