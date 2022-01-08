package javaBasic;

public class Topic_04_Casting_Primitive {

	public static void main(String[] args) {
		// Ngầm định = ko mất dữ liệu
		/*
		 * byte bNumber = 126; System.out.println(bNumber);
		 * 
		 * short sNumber = bNumber; System.out.println(sNumber);
		 * 
		 * int iNumber = sNumber; System.out.println(sNumber);
		 * 
		 * long lNumber = iNumber; System.out.println(lNumber);
		 * 
		 * float fNumber = lNumber; System.out.println(fNumber);
		 * 
		 * double dNumber = fNumber; System.out.println(dNumber);
		 */
		// Tường minh (cast)
		
		double dNumber = 9876543210d;
		System.out.println(dNumber);
		
		float fNumber = (float) dNumber;
		System.out.println(fNumber);
		
		long lNumber = (long) fNumber;
		System.out.println(lNumber);
		
		int iNumber = (int) lNumber;
		System.out.println(iNumber);
		
	}
	
}
