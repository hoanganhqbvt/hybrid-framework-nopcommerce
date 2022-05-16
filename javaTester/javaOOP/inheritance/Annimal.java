package javaOOP.inheritance;

public class Annimal {

	public Annimal() {
		System.out.println("Parent's constractor");
	}
	public Annimal(String name) {
		System.out.println("Parent's constractor: " + name);
	}
	public Annimal(String name, int age) {
		System.out.println("Name is: " + name + " " + "And age is: " + age);				
	}
}
