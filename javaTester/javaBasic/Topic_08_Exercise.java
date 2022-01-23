package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_Exercise {
	Scanner scanner = new Scanner(System.in);
	
	//@Test
	public void TC_01() {
		int n = scanner.nextInt();
		
			while ( n <= 100) {
				if (n % 2 == 0) {
				System.out.print(n + " ");
				n++;
			} else {
				n++;
			}
			}
	}
				
			
	//@Test
	public void TC_02( ) {
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		while (a <= b) {
			if (a % 3 == 0 && a % 5 == 0) {
				System.out.println(a + " ");
				
			} a++;
		}
		}
	
	//@Test
	public void TC_03() {
		int n = scanner.nextInt();
		int i = 0, sum = 0;
		while (i <= n) {
			if(i % 2 != 0) {
				sum = sum + i;
			} 
			i++;
			
		} 
		System.out.println("Sum of odd number in range 0 - " + n + " is " + sum);
	}
	
	//@Test
	public void TC_04() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		while (a < b) {
			if (a % 3 == 0) {
				System.out.print(a + " ");
				
			} 
			a++;
		}
	}
	@Test
	public void TC_05() {
		int n = scanner.nextInt();
		int i = 1;
		while (n > 0) {
			i *= n;
			n--;
		} System.out.println("Giai thua cua n la " +i);
	}
	
	//@Test
	public void TC_06()	{
	int a = 1;
	int sumEven = 0;
	while (a <= 10) {
		if (a % 2 == 0) {
		sumEven = sumEven + a;
		
	} a++;
	} 
	System.out.println("Sum of even number in range 1 - 10 is " + sumEven);
}
}


