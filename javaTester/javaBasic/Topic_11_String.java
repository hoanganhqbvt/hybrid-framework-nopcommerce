package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_11_String {
	Scanner scanner = new Scanner(System.in);

	//@Test
	public void TC_01() {
		String inputString = scanner.nextLine();
		int numberOfUpperCase = 0;

		for (int i = 0; i < inputString.length(); i++) {
			if (Character.isUpperCase(inputString.charAt(i))) {
				numberOfUpperCase++;
			}

		}
		System.out.println("Number of uppercase character in the string is " + numberOfUpperCase);
	}

	//@Test
	public void TC_02() {
		String test = "Automation Testing 345 Tutorials Online 789";

		int countA = 0;
		int countNumber = 0;
		for (int i = 0; i < test.length(); i++) {

			if (test.charAt(i) == 'a' || test.charAt(i) == 'A') {
				countA++;
			}
		}
		System.out.println("The number of 'a' character in the string is " + countA);

		System.out.println(test.contains("Testing"));
		System.out.println(test.startsWith("Automation"));
		System.out.println(test.endsWith("Online"));
		System.out.println(test.indexOf("Tutorials"));
		test = test.replace("Online", "Offline");
		System.out.println(test);

		for (int i = 0; i < test.length(); i++) {

			if (Character.isDigit(test.charAt(i))) {
				countNumber++;
			}
		}
		System.out.println("Digit in the string is " + countNumber);

	}


 // @Test 
  public void TC_03_Way_01() { 
	  String inputString = scanner.nextLine(); 
	  
	  // getBytes() method to convert string into bytes[]
	  byte[] strAsByArray = inputString.getBytes();
	  
	  byte[] result = new byte[strAsByArray.length];
	  
	  // Store result in reverse order into the result byte[]
	  for (int i = 0; i < strAsByArray.length; i++) {
		  result[i]	= strAsByArray[strAsByArray.length - i - 1];
		 	  
	  }
	  System.out.println(new String(result));
  }
 // @Test 
  public void TC_03_Way_02() { 
	  String inputString = scanner.nextLine();
	  StringBuilder inputString1 = new StringBuilder();
	  
      // append a string into StringBuilder input1
	  inputString1.append(inputString);

      // reverse StringBuilder input1
	  inputString1.reverse();

      // print reversed String
      System.out.println(inputString1);
  } 
  @Test 
  public void TC_03_Way_03() { 
	  String inputString = scanner.nextLine();
	  String result ="";
	  // convert String to character array
      // by using toCharArray
      char[] try1 = inputString.toCharArray();

      for (int i = try1.length - 1; i >= 0; i--) {
        
       result = result + try1[i];
      } System.out.println(result);
}
}