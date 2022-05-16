package javaOOP;

public class CarOOP {
	// thuộc tính
	private String carCompany;
	private String carType;
	private String fuelType;
	private Float mileAge;
	private Double carPrice;
	

	protected String getCarCompany() {
		return carCompany;
	}


	protected void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	
	protected String getCarType() {
		return carType;
	}

	
	protected void setCarType(String carType) {
		this.carType = carType;
	}

	
	protected String getFuelType() {
		return fuelType;
	}

	
	protected void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	
	protected Float getMileAge() {
		return mileAge;
	}

	
	protected void setMileAge(Float mileAge) {
		this.mileAge = mileAge;
	}

	
	protected Double getCarPrice() {
		return carPrice;
	}

	
	protected void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}

	protected void showCarInfo() {
		System.out.println("Car company = " + getCarCompany());
		System.out.println("Car type = " + getCarType());
		System.out.println("Car fuel = " + getFuelType());
		System.out.println("Car mile age = " + getMileAge());
		System.out.println("Car price = " + getCarPrice());
	}
	public static void main(String[] args) {
		// Honda
		CarOOP honda = new CarOOP();
		honda.setCarCompany("Honda");
		honda.setCarType("City");
		honda.setFuelType("Petrol");
		honda.setMileAge(150f);
		honda.setCarPrice(50000d);
		honda.showCarInfo();
		
		// Toyota		
		CarOOP toyota = new CarOOP();
		toyota.setCarCompany("Toyota");
		toyota.setCarType("Camry");
		toyota.setFuelType("Petrol");
		toyota.setMileAge(180f);
		toyota.setCarPrice(1500000d);
		toyota.showCarInfo();		
	}
}
