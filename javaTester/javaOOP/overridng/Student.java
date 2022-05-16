package javaOOP.overridng;

public class Student extends Person implements IWork{

	
	public void eat() {
		System.out.println("Suat com 15.000 VND");
	}
	
	@Override
	public void sleep() {
		System.out.println("Ngu 8 tieng/ ngay");
	}
	@Override
	public void workingTime() {
		System.out.println("Lam viec 4 tieng/ ngay");
	}
}
