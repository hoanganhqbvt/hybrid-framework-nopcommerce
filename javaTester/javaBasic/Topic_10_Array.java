package javaBasic;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Topic_10_Array {
	 int id, age, score;
	 String name;
	 
	public void Array() {
		int number[] = {12, 5, 7, 15, 50};
		
		int[] student = {1, 9, 30, 65, 89};
		
		System.out.println(student[0]);
		System.out.println(student[4]);
		
		// Cố định: Được define cố định bao nhiêu phần từ khi viết code (Compile)
		String studentName[] = {"Nam", "Long", "An", "Kien"};
		for (int i = 0; i < student.length; i++) {
			System.out.println(studentName[i]);
		}
		
		int b[]	= new int[5];
		b[0] = 10;
		b[4] = 15;
		System.out.println(b[4]);
		
		//Động: Khi chạy code mới add (Runtime)
		ArrayList<String> stdName = new ArrayList<String>();
		for (String std : studentName) {
			stdName.add(std);
			System.out.println(std);
		}
	}
 //@Test
 public void TC_01() {
	 int number[] = {11, 7, 6, 8, 9};
	 int maxNumber = 0;
	 for (int i = 0; i < number.length; i++) {
		
		 if (maxNumber < number[i]) {
			 maxNumber = number[i];
		 } 	 
	 } 
	 System.out.println("The maximum number is " + maxNumber);
 }
 
 //@Test
 public void TC_02()	{
	 int number[] = {2, 7, 6, 8, 9};
	 System.out.println(number[0] + number[number.length-1]);
 }
 
 //@Test
 public void TC_03() {
	 int number[] = {2, 7, 6, 8, 9, 16, 17, 20};
	 for (int i = 0; i < number.length; i++) {
		 if (number[i] % 2 == 0) {
			 System.out.print("Even number are: " + number[i] + " ");
		 }
	 }
 }
 
 //@Test
 public void TC_04() {
	 int number[] = {3, -7, 2, 5, 9, -6, 10, 12};
	 for (int i = 0; i < number.length; i++) {
		 if (number[i] > 0 && number[i] % 2 != 0) {
			 System.out.print("Numbers that are >= 0 and <= 10 " + number[i] + " ");
		 } 
	 }
 }
 
 //@Test
 public void TC_05() {
	 int number[] = {3, -7, 2, 5, 9, -6, 10, 12};
	 for (int i = 0; i < number.length; i++) {
		 if (number[i] >= 0 && number[i] <= 10) {
			 System.out.print(number[i] + " ");
		 }
	 }
 }
 
 //@Test
 public void TC_06() {
	 int number[] = {3, -7, 2, 5, 9, -6, 10, 12};
	 float sum = 0;
	 float tbc;
	 for (int i = 0; i < number.length; i++) {
		 sum = sum + number[i];
	 } 
	 System.out.println("Tổng của dãy số trong mảng là " + sum);
	 tbc = sum / number.length;
	 System.out.println(number.length);
	 System.out.println("TBC của dãy số trong mảng là " + tbc);
	 
 }
 
 
 public Topic_10_Array( String name, int id, int age, int score) {
		 this.name = name;
		 this.age = age;
		 this.id = id;
		 this.score = score;
	 }
	 public void display() {
		 System.out.println("Name: " + name);
		 System.out.println("id: " + id);
		 System.out.println("age: " + age);
		 System.out.println("score: " + score);
	 }
	 public static void main(String[] args) {
		 Topic_10_Array[] students = new Topic_10_Array[3];
		 students[0] = new Topic_10_Array("Anh", 123, 23, 10);
		 students[1] = new Topic_10_Array("Quan", 456, 22, 9);
		 students[2] = new Topic_10_Array("Kha", 678, 23, 8);
		 
		 for (int i = 0; i < 3; i++) {
			 students[i].display();
		 }
		 			 }
 
 
}


