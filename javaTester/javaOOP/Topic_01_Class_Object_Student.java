package javaOOP;

import java.util.Scanner;

  public class Topic_01_Class_Object_Student {
	private int studentID;
	private String studentName;
	private float theoryPoint;
	private float practicePoint;		
	static Scanner scanner = new Scanner(System.in);
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getTheoryPoint() {
		return theoryPoint;
	}
	public void setTheoryPoint(float theoryPoint) {
		if(theoryPoint >=0) {
			this.theoryPoint = theoryPoint;
		} else { System.out.println("The enter theory point is invalid");
			}
		}
	
	public double getPracticePoint() {
		return practicePoint;
	}
	public void setPracticePoint(float practicePoint) {
		if(practicePoint >=0) {
		this.practicePoint = practicePoint;
	} else { System.out.println("The enter practice point is invalid");
		}
	}
	public float getAveragePoint() {
		 return (this.theoryPoint + this.practicePoint * 2) / 3;
	}
	public void showStudentInfo() {
		System.out.println("Student's ID is: " + getStudentID());
		System.out.println("Student's name is: " + getStudentName());
		System.out.println("Student's theory Point is: " + getTheoryPoint());
		System.out.println("Student's practice Point is: " + getPracticePoint());
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
