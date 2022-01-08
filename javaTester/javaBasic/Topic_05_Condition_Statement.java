package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Topic_05_Condition_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	public static void main(String[] args) {
		boolean status = 5 < 3;
		System.out.println(status);
		
		// Hàm if sẽ nhận vào 1 điều kiện đúng
		// kiêm tra duy nhât 1 dk
		// nếu dk này đúng thì sẽ thực thi action trong phần thân
		if (status) {
			// đúng thì vào phần thân của if
			// sai thì bỏ qua
			System.out.println("Go to if");
			
			// Gán (assign)
			int studentNumber = 10;
			
			// == So sánh
			status = (studentNumber == 10);
			System.out.println(status);
			
		}
		WebDriver driver = new FirefoxDriver();
		// Element luôn có trong DOM dù popup hiển thị hay ko
		
		WebElement salePopup = driver.findElement(By.id(""));
		if (salePopup.isDisplayed()) {
			
		}
		
		// Element k có trong DOM khi popup ko hiển thị
		List<WebElement> salePopups = driver.findElements(By.id(""));
		
		// Check element k hiển thị
		if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {
			
		}
		
		// Uncheck to checkbox
		WebElement languagesCheckbox = driver.findElement(By.id(""));
		if (!languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}
	}
	public void TC_01_If () {
		
	}
		
		@Test (enabled = false)
		public void TC_02_If_Else() {
			// if - else có 2 đk: nếu như đúng thì vào if, sai thì vào else
			
			// Nếu driver start vs browser như Chrome, firefox, edge, safari thì dùng hàm click thông thường (builtin) của Selenium Webdriver
			
			// Nếu driver là IE thì dùng hàm click của JavascriptExcutor
			
			
			System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers//chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(driver.toString());
			
//			System.setProperty("webdriver.ie.driver", projectPath + "//browserDrivers//IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
			
			if(driver.toString().contains("internet explorer")) {
				System.out.println("Click by JavascriptExecutor");
				
			} else {
				System.out.println("Click by Selenium WebDriver");
			}
		}
		@Parameters("browser")
		@Test
		public void TC_03_If_Else_If_Else(String browserName) {
			if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers//chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers//geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", projectPath + "//browserDrivers//msedgedriver.exe");
				driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "//browserDrivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else { // safari/ opera/ cococ/ ....)
			throw new RuntimeException("Please input correct the browser name!");
		}
			System.out.println(driver.toString() + browserName);
			driver.quit();
		}
		@Test
		public void TC_04_If_Else_If_Else() {
			// Page Object
			// Dynamic page
			
			String pageName = "Login";
			if (pageName.equals("Login")) {
				// LoginPage loginPage = new LoginPage();
				// return loginPage;
			} else if (pageName.equals("Register")) {
				// RegisterPage registerPage = new RegisterPage();
				// return registerPage;
			} else if (pageName.equals("New Customer")) {
				// CustomerPage customerPage = new CustomerPage();
				// return customerPage;
		} else {
			// HomePage homePage = new HomePage();
			// return homePage;
		}
		}
}
