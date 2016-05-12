package immutable;

import java.util.Date;

public final class Complex {
	private final int i;
	private final Integer integer;
	private final String s;
	private final Date date;
	
	public Complex(int i,Integer integer,String s,Date date){
		this.i=i;
		this.integer=integer;
		this.s=s;
		this.date=new Date(date.getTime());
	}
	
	@Override
	public String toString(){
		return String.valueOf(this.i)+String.valueOf(this.integer)+this.s+date.toString();
	}
}
