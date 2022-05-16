package javaOOP;

import java.util.Scanner;

public class Topic_01_Class_Object_Student {
	private int studentID;
	private String studentName;
	private float theoryPoint;
	private float practicePoint;		
	static Scanner scanner = new Scanner(System.in);
	
	private int getStudentID() {
		return studentID;
	}
	private void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	private String getStudentName() {
		return studentName;
	}
	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	private double getTheoryPoint() {
		return theoryPoint;
	}
	protected void setTheoryPoint(float theoryPoint) {
		this.theoryPoint = theoryPoint;
	}
	private double getPracticePoint() {
		return practicePoint;
	}
	private void setPracticePoint(float practicePoint) {
		this.practicePoint = practicePoint;
	}
	private float getAveragePoint() {
		 return (this.theoryPoint + this.practicePoint * 2) / 3;
	}
	private void showStudentInfo() {
		System.out.println("Student's ID is: " + getStudentID());
		System.out.println("Student's name is: " + getStudentName());
		System.out.println("Student's name is: " + getTheoryPoint());
		System.out.println("Student's name is: " + getPracticePoint());
		System.out.println("Student's average point is: " + getAveragePoint());
	}
	public static void main(String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		System.out.println("Input student ID");
		int studentID1 = scanner.nextInt();
		System.out.println("Input student name");
		String studentName1 = scanner.next();
		System.out.println("Input student theory point");
		float studentTheoryPoint1 = scanner.nextFloat();
		System.out.println("Input student practice point");
		float studentPracticePoint1 = scanner.nextFloat();
		firstStudent.setStudentID(studentID1);		
		firstStudent.setStudentName(studentName1);		
		firstStudent.setTheoryPoint(studentTheoryPoint1);
		firstStudent.setPracticePoint(studentPracticePoint1);
		firstStudent.getAveragePoint();
		firstStudent.showStudentInfo();
}
}
