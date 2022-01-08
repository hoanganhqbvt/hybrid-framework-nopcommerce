package javaBasic;

import org.testng.Assert;

public class Topic_03_Operator {
 public static void main(String[] args) {
	 int number = 10;
	 
	 System.out.println(number++);
	 // In number ra trước: 10
	 //++ = tăng number lên 1 = 11
	 
	 
	 System.out.println(number++);
	 // == trước: tăng number lên 1 = 12
	 // In number ra: 12
	 
	 for (int i = 0; i < 3; i++) {
	 System.out.println(i);
 }
	 Assert.assertTrue(5<6);
	 String address = "Ho Chi Minh";
	 
	 if (!(address == "Ha Noi")) {
		 System.out.println("Address is not the same");
		 
		 boolean status = (address == "Ha Noi") ? true : false;
		 System.out.println(status);
	 }
 }
 
}
