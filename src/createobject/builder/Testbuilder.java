package createobject.builder;

import createobject.builder.Message.Builder;

public class Testbuilder {
	public static void test(){
		Builder messagebuilder=new Message.Builder("ssss", "rrrrr");
		messagebuilder.content("c");
		Message message=messagebuilder.build();
		System.out.println(message.getSender()+message.getReceiver()+message.getContent());
	}
}
