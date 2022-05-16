package javaOOP;

public class Topic_04_This_Supper {
	private int firstNumber;
	private int secondNumber;
	
	public Topic_04_This_Supper(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	public void sumNumber() {
		System.out.println(firstNumber + secondNumber);
	}
		public void showNumver() {
			this.sumNumber();
		}
	public static void main(String[] args) {
		Topic_04_This_Supper topic = new Topic_04_This_Supper(15, 7);
		topic.sumNumber();
	}

}
