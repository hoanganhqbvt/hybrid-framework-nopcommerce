package javaBasic;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class Topic_06_Switch_Case {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	String projectPath = System.getProperty("user.dir");
	
	//@Parameters("browser")
	//@Test
	public void TC_01_Browsers(String browserName) {
		driver = getBrowserDriver(browserName);
		System.out.println(browserName);
		
		driver.quit();
	}
	public WebDriver getBrowserDriver(String browserName) {
		
	switch (browserName) {
	case "chrome":
		System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers//chromedriver.exe");
		driver = new ChromeDriver();
		break;
	case "firefox":
		System.setProperty("webdriver.gecko.driver", projectPath + "//browserDrivers//geckodriver.exe");
		driver = new FirefoxDriver();
		break;
	case "edge":
		System.setProperty("webdriver.edge.driver", projectPath + "//browserDrivers//msedgedriver.exe");
		driver = new EdgeDriver();
		break;
	case "ie":
		System.setProperty("webdriver.ie.driver", projectPath + "//browserDrivers//IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		break;
	default:
		new RuntimeException("Please input correct the browser name!");
		break;
	}
	return driver;

}
	//@Test
	public void TC_02_Months() {
		
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng " + month + " có 31 ngày");
			break;
		case 2:
			System.out.println("Tháng " + month + " có 28/ 29 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:	
			System.out.println("Tháng " + month + " có 30 ngày");
			break;
		default:
			System.out.println("Vui lòng nhập giá trị trong khoảng 1 - 12");
		}
	}
	
	//@Test
	public void TC_03_Exercise_1() {
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;
		default:
			System.out.println("Please input a number in range 1 - 10");
		}
	}

	@Test
	public void TC_04_Exercise_2() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String operator = scanner.next();
		switch (operator) {
		case "+":
			System.out.println(a + b);
			break;
		case "-":
			System.out.println(a - b);
			break;
		case "*":
			System.out.println(a * b);
			break;
		case "/":
			System.out.println(a / b);
			break;
		case "%":
			System.out.println(a % b);
			break;
		default:
			System.out.println("Please input one of the following operator +, -, *, /, %");
}
	}
}