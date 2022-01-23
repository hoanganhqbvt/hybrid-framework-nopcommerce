package javaBasic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_07_For_Foreach {
WebDriver driver;
	@Test
	public void TC_01_For() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		
		
//		  List<WebElement> links = driver.findElements(By.id(""));
//		  links.size();		 
	
	// Array
	String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};
	
	// For kết hợp if: thỏa mãn điều kiện mới action
	// biến đếm - dùng để filter
	for (int i = 0; i < cityName.length; i++) {
		System.out.println(cityName[i]);
		if (cityName[i].equals("Da Nang")) {
			// action
			System.out.println("Do action");
			break; // tìm thấy dk thì thoát khỏi vòng lặp
		}
	}
}
	@Test
	public void TC_02_ForEach() {
		String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};
		
		// java collection
		// class: ArrayList/ LinkedList/ Vector/...
		// Interface: List/ Set/ Queue
		List<String> cityAddress = new ArrayList<String>();
		System.out.println(cityAddress.size());
		// Compile (Coding)
		cityAddress.add("Dong Hoi");
		cityAddress.add("Dong Ha");
		cityAddress.add("Bien Hoa");
		System.out.println(cityAddress.size());
		
		for (String city :  cityName) {
			cityAddress.add(city);
			
		}
		System.out.println(cityAddress.size());
		for (String cityAdd : cityAddress) {
			System.out.println(cityAdd);
		}
	}
	
}