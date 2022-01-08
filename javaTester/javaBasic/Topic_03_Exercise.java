package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_03_Exercise {
	@Test
	public void TC_01() {
int Age = 30;
String Name = "Anh";
Age = Age + 15;
System.out.println("After 15 years, age of " + Name + " " + "will be " + Age);
}
	@Test
	public void TC_02( ) {
		int a = 7, b = 9;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After swapping then a = " + a + ", b = " + b);
	}
	@Test
	public void TC_03() {
		
		// Nhập hai số từ bàn phím
		Scanner scanner = new Scanner(System.in);
		int a, b;
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		// Hiển thị true nếu a > b, nếu a < b, hiển thị false
		if (a > b ) {
			System.out.print("True");
		} else {System.out.print("False");
		}
		
	}
}