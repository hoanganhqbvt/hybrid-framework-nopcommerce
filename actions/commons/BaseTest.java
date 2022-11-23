package commons;

import java.io.File;
import java.util.Calendar;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());	
		if(browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			// Add extension for Firefox
			FirefoxProfile profile = new FirefoxProfile();
			File adBlock = new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\adblock_for_firefox-5.1.1.xpi");
			profile.addExtension(adBlock);
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			driver = new FirefoxDriver(options);
		}
		else if(browserList == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOpt = new FirefoxOptions();
			firefoxOpt.addArguments("-headless");
			firefoxOpt.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(firefoxOpt);
			
		}	else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			// Add extension for Chrome
			//File adBlock = new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\extension_5_1_2_0.crx");
			ChromeOptions options = new ChromeOptions();
			//options.addExtensions(adBlock);
			options.addArguments("--disable-infobars");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			Map<String, Object> prefs = new HashedMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		}	else if (browserList == BrowserList.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("-headless");
			chromeOpt.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(chromeOpt);
		} else if (browserList == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if(browserList == BrowserList.OPERA) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			
		} else if(browserList == BrowserList.COCCOC) {
			// Cốc cốc browser version trừ đi 5 hoặc 6 version = chromedriver
			WebDriverManager.chromedriver().driverVersion("96.0.4664.45").setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(chromeOpt);
		} 
		else if(browserList == BrowserList.BRAVE) {
			// brave browser version nào dùng chromedriver version đó
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.setBinary("");
			driver = new ChromeDriver(chromeOpt);
		} 
		else {
			throw new RuntimeException("Browser name is invalid.");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appUrl);
		driver.manage().window().maximize();
		return driver;
	}
	private String getEnvironmentUrl(String serverName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		if(environment == EnvironmentList.DEV) {
			envUrl = "https://demo.nopcommerce.com";
		}
		else if(environment == EnvironmentList.TESTING) {
			envUrl = "https://admin-demo.nopcommerce.com";
		}
		else if(environment == EnvironmentList.STAGING){
			envUrl = "https://staging.orangehrmlive.com";				
		}
		else if(environment == EnvironmentList.PRODUCTION){
			envUrl = "https://production.orangehrmlive.com";
		}		
		return envUrl;
	}
	protected WebDriver getBrowserDriver(String browserName) {	
		if(browserName == "firefox") {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			}
		else if(browserName == "headless_firefox") {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOpt = new FirefoxOptions();
			firefoxOpt.addArguments("-headless");
			firefoxOpt.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(firefoxOpt);
			
		}	else if (browserName == "chrome") {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}	else if (browserName == "headless_chrome") {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("-headless");
			chromeOpt.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(chromeOpt);
		} else if (browserName == "edge") {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if(browserName == "opera") {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		 
		} else if(browserName == "coccoc") {
			// Cốc cốc browser version trừ đi 5 hoặc 6 version = chromedriver
			WebDriverManager.chromedriver().driverVersion("96.0.4664.45").setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			
			if (GlobalConstants.OS_NAME.startsWith("Windows")) {							
			chromeOpt.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				chromeOpt.setBinary("...");
			}
			driver = new ChromeDriver(chromeOpt);
		} 
		else if(browserName == "brave") {
			// brave browser version nào dùng chromedriver version đó
			 WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.setBinary("");
			driver = new ChromeDriver(chromeOpt);
		} 
		else {
			throw new RuntimeException("Browser name is invalid.");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(GlobalConstants.TECHPANDA_PORTAL_TESTING_URL);
		driver.manage().window().maximize();
		return driver;
	}
	public WebDriver getDriverInstance() {
		return this.driver;
	}
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
				Assert.assertTrue(condition);
				log.info(" -------------------------- PASSED -------------------------- ");
			
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}	

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {			
				Assert.assertFalse(condition);
				log.info(" -------------------------- PASSED -------------------------- ");		
			
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {			
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	public int generateFakeNumber() {
		Random randomNumber = new Random();
		return randomNumber.nextInt(9999);
	}
	public long getRandomNumberByDateTime() {		
		 return Calendar.getInstance().getTimeInMillis();
	 }
	
}
