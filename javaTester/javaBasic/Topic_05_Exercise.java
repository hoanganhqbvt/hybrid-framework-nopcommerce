package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_05_Exercise {
	Scanner scanner = new Scanner(System.in);
	//@Test
 public void TC_01() {
		int n = scanner.nextInt();
	 if (n%2 == 0) {
		 System.out.println("Số" + n +" là số chẵn");
	 } else { 
	 System.out.println("Số" + n +" là số lẻ");
 }
}
	//@Test
	public void TC_02() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		if (a >= b) {
			System.out.println(a + " lớn hơn hoặc bằng" + b);
		} else {
			System.out.println(a + " nhỏ hơn" + b);
		}
	}
	//@Test
	public void TC_03() {
		String name01 = scanner.next();
		String name02 = scanner.next();
		if (name01.equalsIgnoreCase(name02)) {
			System.out.println(" Hai người trùng tên");
		} else {
			System.out.println(" Hai người khác tên");
		}
	}
	//@Test
	public void TC_04() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		if (a > b && a > c) {
			System.out.println("Số lớn nhất là: " + a);
		} else if (a < b && b > c) {
			System.out.println("Số lớn nhất là: " + b);
		} else if (a < c && b < c) {
			System.out.println("Số lớn nhất là: " + c);
		} else {
			System.out.println("Những trường hợp còn lại");
		}
	} 
	//@Test 
	public void TC_05() {
		int a = scanner.nextInt();
		if (a >= 10 && a <= 100) {
			System.out.println(a + " nằm trong khoảng [10, 100]");
		} else {
			System.out.println(a + "không nằm trong khoảng [10, 100]");
		}
	}
	@Test
	public void TC_06() {
		float a = scanner.nextFloat();
		if(a >= 0 && a < 5) {
			System.out.println(a + ": Điểm D");
		} else if(a >= 5 && a < 7.5) {
			System.out.println(a + ": Điểm C");
		} else if(a >= 7.5 && a < 8.5) {
			System.out.println(a + ": Điểm B");
		} else if(a >= 8.5 && a <= 10) {
			System.out.println(a + ": Điểm  A");
		} else {
			System.out.println("Vui lòng nhập lại điểm");
		}
	}
	

	@Test
	public void TC_07() {
		int month = scanner.nextInt();
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ) {
			System.out.println("Tháng" + month + "có 31 ngày");
			
		} else if(month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("Tháng" + month + "có 30 ngày");
			
	} else if(month == 2) {
		System.out.println("Tháng" + month + "có 28 hoặc 29 ngày");
	} else {
		System.out.println("Invalid value");
	}
	}
}
