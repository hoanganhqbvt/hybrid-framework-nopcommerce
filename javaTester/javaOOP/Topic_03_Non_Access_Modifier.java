package javaOOP;

public class Topic_03_Non_Access_Modifier extends Topic_02_Overloading{
	
	// static: varial/ method
	// dùng cho tất cả các instance/ object
	// phạm vi cho toàn bô system sử dụng nó
	// có thể override được
	static String browserName =  "Chrome";
	
	// Non static
	String serverName = "Testing";
	
	// hằng số constant
	final String colorCar = "Red";
	
	final static String REGISTER_BUTTON = "";
	
	public static void main(String[] args) {
		System.out.println(browserName);
		browserName = "Firefox";
		Topic_03_Non_Access_Modifier topic = new Topic_03_Non_Access_Modifier();
		System.out.println(topic.serverName);
		
		// không được phép gán lại giá trị cho final variable
		System.out.println(topic.colorCar);
		
	}
	static double plusMethod(double x, double y) {
		System.out.println("overriding");
		return x + y;
	}
	
	@Override
	public void test(String browserName) {
		this.browserName = browserName;
	} 

}
