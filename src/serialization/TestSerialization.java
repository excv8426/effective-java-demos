package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import createobject.singleton.SingleMessage;

public class TestSerialization {
	
	public static void testSerializableMessage() {
		Foo foo1=new Foo(7, 11);
		SerializableMessage m1=new SerializableMessage();
		m1.setSender("ss");
		m1.setReceiver("rr");
		m1.setContent("cc");

		try(FileOutputStream outputStream=new FileOutputStream("message.data");
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);) {
			objectOutputStream.writeObject(m1);
			objectOutputStream.writeObject(foo1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SerializableMessage m2=null;
		Foo foo2=null;
		try(FileInputStream inputStream=new FileInputStream("message.data");
			ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);) {
			m2=(SerializableMessage) objectInputStream.readObject();
			foo2=(Foo) objectInputStream.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(m2);
		System.out.println(foo2);
	}
	
	public static void testSerializableSingleton() {
		SingleMessage message1=SingleMessage.INSTANCE;
		message1.setContent("message1");

		try(FileOutputStream outputStream=new FileOutputStream("message.data");
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);) {
			objectOutputStream.writeObject(message1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SingleMessage message2=null;
		try(FileInputStream inputStream=new FileInputStream("message.data");
			ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);) {
			message2=(SingleMessage) objectInputStream.readObject();
			message2.setContent("message2");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("message1:"+message1.getContent());
		System.out.println("message2:"+message2.getContent());
	}
	
	public static void testSerializableProxy() {
		Period period=new Period(new Date(0), new Date());

		try(FileOutputStream outputStream=new FileOutputStream("message.data");
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);) {
			objectOutputStream.writeObject(period);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Period readperiod=null;
		try(FileInputStream inputStream=new FileInputStream("message.data");
			ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);) {
			readperiod=(Period) objectInputStream.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("start:"+readperiod.getStart());
		System.out.println("end:"+readperiod.getEnd());
	}
}
