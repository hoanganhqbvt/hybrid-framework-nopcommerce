package javaBasic;


import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_Exercise {
	
	Scanner scanner = new Scanner(System.in);
	
	//@Test
	public void TC_01() {
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++ ) {
			System.out.print(i + " ");
		}
	}
	
	//@Test
	public void TC_02() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		if (a < b) {
			for (int i = a; i <=b; i++) {
				System.out.print(i + " ");
			} 
		} else if (a > b) {
			for (int i = b; i <=a; i++) {
				System.out.print(i + " ");
			} 
		} else {
			System.out.println(" Please input 2 different numbers");			
		}		
	}
	
	//@Test
	public void TC_03() {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int sumEven = 0, sumOdd = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				sumEven = sumEven + number;
			} else {
				sumOdd = sumOdd + number;
			}
		} 
		System.out.println(" Sum of even number in range 1 - 10 is " + sumEven);
		  System.out.println(" Sum of odd number in range 1 - 10 is " + sumOdd);
	}

	//@Test
	public void TC_04() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int sum = 0;
		if (a < b) {
			for (int i = a; i <= b; i++) {
			sum = sum +i;
			} System.out.println(sum);
		} else if (a > b) {
			for (int i = b; i <= a; i++) {
				sum = sum +i;
						} System.out.println(sum);
} else {
	System.out.println(sum = a + b);
}
}
	//@Test
	public void TC_05() {
		int n = scanner.nextInt();
		int sumOdd = 0;
		for(int i = 1; i <= n; i++) {
			if (i %2 > 0) {
				sumOdd = sumOdd + i;
			}
		} System.out.println("Sum of odd number in range 1 - " +n + " is " + sumOdd);
	}
	
	//@Test
	public void TC_06( ) {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int count = 0;
		if (a < b) {
			for (int i = a; i <= b; i++) {
				if (i % 3 == 0) {
					System.out.print(i + " ");
					count++;
				} 
				} if (count == 0) {
					System.out.print("khong co so chia het cho 3 trong khoang " + a + " - " + b);
				}
			} else if (a > b) {
				for (int i = b; i <= a; i++) {
					if (i % 3 == 0) {
						System.out.print(i + " ");
						count++;
					} 
					} if (count == 0) {
						System.out.print("khong co so chia het cho 3 trong khoang " + a + " - " + b);
					}
		} else { if (a % 3 == 0) {
			System.out.print(a);
		} else {
			System.out.print("khong co so chia het cho 3");
		}
	}
	}
	@Test
	public void TC_07() {
		int n = scanner.nextInt();
		int giaithua = 1;
		for (int i = 1; i <= n; i++) {
			 giaithua = giaithua * i;
		} System.out.println(giaithua);
	
	}
}

	

