package javaOOP.overridng;

public class Employee extends Person implements IWork{
	
	@Override
	public void eat() {
		System.out.println("Suat com 25.000 VND");
	}
	
	@Override
	public void sleep() {
		System.out.println("Ngu 6 tieng/ ngay");
	}
	@Override
	public void workingTime() {
		System.out.println("Lam viec 8 tieng/ ngay");
	}

	public void dating() {
		System.out.println("di choi");
}
}
