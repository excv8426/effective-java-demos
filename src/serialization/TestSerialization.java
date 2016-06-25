package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerialization {
	
	public static void testSerializableMessage() {
		Foo foo1=new Foo(7, 11);
		SerializableMessage m1=new SerializableMessage();
		m1.setSender("ss");
		m1.setReceiver("rr");
		m1.setContent("cc");
		
		FileOutputStream outputStream=null;
		ObjectOutputStream objectOutputStream=null;
		try {
			outputStream=new FileOutputStream("message.data");
			objectOutputStream=new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(m1);
			objectOutputStream.writeObject(foo1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.flush();
				objectOutputStream.close();
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		FileInputStream inputStream=null;
		ObjectInputStream objectInputStream=null;
		SerializableMessage m2=null;
		Foo foo2=null;
		try {
			inputStream=new FileInputStream("message.data");
			objectInputStream=new ObjectInputStream(inputStream);
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
		} finally {
			try {
				objectInputStream.close();
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println(m2);
		System.out.println(foo2);
	}
}
