package javaAccModFirst;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Dog {
	WebDriver driver;
	Animal animal = new Animal(); // instance/ object
	Cat cat = new Cat();
	
	
	@Test
	public void showProperty() {
		System.out.println(animal.weight);
	}
}
