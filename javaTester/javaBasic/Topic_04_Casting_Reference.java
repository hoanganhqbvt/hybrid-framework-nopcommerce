package javaBasic;

public class Topic_04_Casting_Reference {

	public String studentName;
	
	public String getStudentNam() {
	return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void showStudentName() {
		System.out.println("Student name = " + studentName);
	}
	
	public static void main(String[] args) {
		Topic_04_Casting_Reference firstStudent = new Topic_04_Casting_Reference();
		Topic_04_Casting_Reference secondStudent = new Topic_04_Casting_Reference();
		
		firstStudent.setStudentName("Nguyen Van A");
		secondStudent.setStudentName("Tran Van B");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		// ép kiểu
		firstStudent = secondStudent;
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		secondStudent.setStudentName("Hoang Van A");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
	}
}
