package serialization;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public final class Period implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Date start;
	private final Date end;
	
	public Period(Date start,Date end){
		this.start=new Date(start.getTime());
		this.end=new Date(end.getTime());
		
		if (this.start.compareTo(this.end)>0) {
			throw new IllegalArgumentException(this.start+" after "+this.end);
		}
	}

	public Date getStart() {
		return new Date(start.getTime());
	}

	public Date getEnd() {
		return new Date(end.getTime());
	}
	
	private Object writeReplace(){
		System.out.println("writeReplace");
		return new SerializationProxy(this);
	}
	
	private void readObject(ObjectInputStream inputStream) throws InvalidObjectException{
		System.out.println("readObject");
		throw new InvalidObjectException("Proxy required");
	}
	
	private static class SerializationProxy implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2L;
		private final Date start;
		private final Date end;
		
		SerializationProxy(Period period){
			System.out.println("SerializationProxy construct");
			start=period.start;
			end=period.end;
		}
		
		private Object readResolve(){
			System.out.println("readResolve");
			return new Period(start, end);
		}
	}
}
