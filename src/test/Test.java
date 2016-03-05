package test;

import java.util.Arrays;

import builder.Message;
import builder.Message.Builder;
import singleton.SingleMessage;
import staticfactorymethod.Teststaticfactorymethod;

public class Test {

	public static void main(String[] args) {

		//Teststaticfactorymethod.newService1();
		
		/*Builder messagebuilder=new Message.Builder("ssss", "rrrrr");
		messagebuilder.content("c");
		Message message=messagebuilder.build();
		System.out.println(message.getSender()+message.getReceiver()+message.getContent());*/
		
		SingleMessage message1=SingleMessage.INSTANCE;
		message1.setContent("message1");
		SingleMessage message2=SingleMessage.INSTANCE;
		System.out.println(message1.getContent()+message2.getContent());
		System.out.println(message1);
		System.out.println(message2);
	}

}
