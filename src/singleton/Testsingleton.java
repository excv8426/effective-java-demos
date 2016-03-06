package singleton;

public class Testsingleton {
	public static void test(){
		SingleMessage message1=SingleMessage.INSTANCE;
		message1.setContent("message1");
		SingleMessage message2=SingleMessage.INSTANCE;
		System.out.println(message1.getContent()+message2.getContent());
		System.out.println(message1);
		System.out.println(message2);
	}
}
