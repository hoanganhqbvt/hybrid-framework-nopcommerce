package javaOOP;

public class Topic_02_Overloading {
	static int plusMethod(int x, int y) {
		return x + y;
	}
	static double plusMethod(double x, double y) {
		return x + y;
	}
	public static void main(String[] args) {
		double myNumber1 = plusMethod(8.5, 9.6);
		
		System.out.println(myNumber1);
	}
	
}
