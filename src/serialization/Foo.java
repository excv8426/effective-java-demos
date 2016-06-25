package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Foo extends AbstractFoo implements Serializable {
	
	int z;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException{
		System.out.println("readObject");
		stream.defaultReadObject();
		int x=stream.readInt();
		int y=stream.readInt();
		initialize(x, y);			
	}
	
	private void writeObject(ObjectOutputStream stream) throws IOException{
		System.out.println("writeObject");
		stream.defaultWriteObject();
		stream.writeInt(getX());
		stream.writeInt(getY());
	}
	
	public Foo(int x,int y){
		super(x,y);
		this.z=x+y;
	}
	
	@Override
	public String toString(){
		return String.valueOf(getX())+String.valueOf(getY())+String.valueOf(this.z);
	}
}
