package composition;

import java.util.Collection;
import java.util.Set;

public class InstrumentSet<E> extends ForwardingSet<E> {
	private int count;
	
	public InstrumentSet(Set<E> s) {
		super(s);
	}
	
	@Override
	public boolean add(E e){
		count++;
		return super.add(e);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c){
		count=count+c.size();
		return super.addAll(c);
	}
	
	public int getCount(){
		return count;
	}
}
