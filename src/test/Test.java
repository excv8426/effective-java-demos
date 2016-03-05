package test;

import builder.Message;
import staticfactorymethod.Teststaticfactorymethod;

public class Test {

	public static void main(String[] args) {
		//Teststaticfactorymethod.newService1();
		Message message=new Message.Builder("ssss", "rrrrr").content("cccc").build();
		System.out.println(message.getSender()+message.getReceiver()+message.getContent());
	}

}
