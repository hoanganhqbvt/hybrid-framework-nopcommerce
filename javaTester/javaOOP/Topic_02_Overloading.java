package javaOOP;

public abstract class Topic_02_Overloading{
	static int plusMethod(int x, int y) {
		return x + y;
	}
	static double plusMethod(double x, double y) {
		return x + y;
	}

	static long plusMethod(long x, long y) {
		return x + y;
		
	}
	public abstract void test(String browserName);
	
	public static void main(String[] args) {
		double myNumber1 = plusMethod(8.5, 9.6);
		
		System.out.println(myNumber1);
	
	
	Topic_01_Class_Object_Student student = new Topic_01_Class_Object_Student();
	student.setStudentID(12345);
	student.setStudentName("HTA");
	student.setPracticePoint(-1);
	student.setTheoryPoint(9);
	
	student.showStudentInfo();
	student.main(args);
	}

}