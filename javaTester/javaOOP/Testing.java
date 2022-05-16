package javaOOP;

public class Testing {

	public static void main(String[] args) {
		Topic_05_Getter_Setter topic = new Topic_05_Getter_Setter();
		
		// Happy case
		topic.setPersonName(" ");
		System.out.println(topic.getPersonName());

	}

}
