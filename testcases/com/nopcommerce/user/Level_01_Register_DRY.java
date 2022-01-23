package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Register_DRY {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	By registerButton = By.id("register-button");
	By genderMale = By.xpath("//input[@id='gender-male']");
	By firstNameBox = By.xpath("//input[@id='FirstName']");
	By lastNameBox = By.xpath("//input[@id='LastName']");
	By emailBox = By.xpath("//input[@id='Email']");
	By passwordBox = By.xpath("//input[@id='Password']");
	By confirmPasswordBox = By.xpath("//input[@id='ConfirmPassword']");
	
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  
	  emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
  }

  @Test
  public void TC_01_Register_Empty_Data() {
	  driver.findElement( By.cssSelector("a.ico-register")).click();
	  driver.findElement(registerButton).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText(), "First name is required.");
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id='LastName-error']")).getText(), "Last name is required.");
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Email is required.");
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']")).getText(), "Password is required.");
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "Password is required.");
	  
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  driver.findElement( By.cssSelector("a.ico-register")).click();
	  driver.findElement(genderMale).click();
	  driver.findElement(firstNameBox).sendKeys("John");
	  driver.findElement(lastNameBox).sendKeys("Smith");
	  driver.findElement(emailBox).sendKeys("abc#123.123");
	  driver.findElement(passwordBox).sendKeys("Abc@12345678");
	  driver.findElement(confirmPasswordBox).sendKeys("Abc@12345678");
	  driver.findElement(registerButton).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Wrong email");
	  
  }
  @Test
  public void TC_03_Register_Success() {
	  driver.findElement( By.cssSelector("a.ico-register")).click();
	  driver.findElement(genderMale).click();
	  driver.findElement(firstNameBox).sendKeys("John");
	  driver.findElement(lastNameBox).sendKeys("Smith");
	  driver.findElement(emailBox).sendKeys(emailAddress);
	  driver.findElement(passwordBox).sendKeys("Abc@12345678");
	  driver.findElement(confirmPasswordBox).sendKeys("Abc@12345678");
	  driver.findElement(registerButton).click();
	  Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
	  driver.findElement(By.cssSelector("a.ico-logout")).click();
  }
  @Test
  public void TC_04_Register_Existing_Email() {
	  driver.findElement( By.cssSelector("a.ico-register")).click();
	  driver.findElement(genderMale).click();
	  driver.findElement(firstNameBox).sendKeys("John");
	  driver.findElement(lastNameBox).sendKeys("Smith");
	  
	  driver.findElement(emailBox).sendKeys(emailAddress);
	  driver.findElement(passwordBox).sendKeys("Abc@12345678");
	  driver.findElement(confirmPasswordBox).sendKeys("Abc@12345678");
	  driver.findElement(registerButton).click();
	  Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error li")).getText(), "The specified email already exists");
	  
  }
  @Test
  public void TC_05_Register_Password_Less_Than_6_Chars() {
	  driver.findElement( By.cssSelector("a.ico-register")).click();
	  driver.findElement(genderMale).click();
	  driver.findElement(firstNameBox).sendKeys("John");
	  driver.findElement(lastNameBox).sendKeys("Smith");
	  emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
	  driver.findElement(emailBox).sendKeys(emailAddress);
	  driver.findElement(passwordBox).sendKeys("Abc@1");
	  driver.findElement(confirmPasswordBox).sendKeys("Abc@1");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),"Password must meet the following rules:\n"
	  		+ "must have at least 6 characters");

  }
  @Test
  public void TC_06_Register_Invalid_Confirm_Password() {
	  driver.findElement( By.cssSelector("a.ico-register")).click();
	  driver.findElement(genderMale).click();
	  driver.findElement(firstNameBox).sendKeys("John");
	  driver.findElement(lastNameBox).sendKeys("Smith");
	  driver.findElement(emailBox).sendKeys(emailAddress);
	  driver.findElement(passwordBox).sendKeys("Abc@123");
	  driver.findElement(confirmPasswordBox).sendKeys("Abc@132");
	  driver.findElement(registerButton).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "The password and confirmation password do not match.");
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
