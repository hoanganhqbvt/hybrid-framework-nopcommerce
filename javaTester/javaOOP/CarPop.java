package javaOOP;

public class CarPop {
	
	// Nested class
	public class Head{
		
	}
	public interface ICar{
		
	}
	enum BrowerList{
		
	}
	static String carCompany;
	static String carType;
	static String fuelType;
	static Float mileAge;
	static Double carPrice;
	
	public static void main(String[] args) {
		carCompany = "Honda";
		carType = "City";
		mileAge = 200f;
		fuelType = "Petrol";
		carPrice = 50000d; 
		System.out.println("Car company = " + carCompany);
		System.out.println("Car type = " + carType);
		System.out.println("Car fuel = " + fuelType);
		System.out.println("Car mile age = " + mileAge);
		System.out.println("Car price = " + carPrice);
					
	}
}
