package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_01_Data_Type {
// Primitive type/ value type: dữ liệu nguyên thủy
	byte bNumber = 6;
	short sNumber = 1500;
	int iNumber = 65000;
	long lNumber = 70000;
	float fNumber = 15.57f;
	double dNumber = 15.57d;
	char cChar = '1';
	boolean bStatus = false;
	
// Reference type: dữ liệu tham chiếu (non-primitive)
	
	// String
	String address = "Ho Chi Minh";
	
	// Array 
	String[] studentAddress = {address, "Ha Noi", "Da Nang"};
	Integer[] studentNumber = {5, 10, 15};
	
	// Class
	Topic_01_Data_Type topic;
	
	// Interface
	WebDriver driver;
	
	// Object
	Object aObject;
	
	// Collection: List/ Set/ Queue/ Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	public void clickToElement() {
		studentAddress.clone();
		driver.get(address);
		aObject.toString();
		homePageLinks.size();
		allWindows.clear();
		topic.toString();
		
	}
	
	public static void main(String[] args) {
		int a, b;
		a = 6;
		b = 2;
		//Exercise 1
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		
		//Exercise 2
		float width = 3.8f;
		float lengh = 7.5f;
		float area = width * lengh;
		System.out.println(area);
		
		//Exercise 3
		String name = "Automation Testing";
		System.out.println(name);
	}
	
}
