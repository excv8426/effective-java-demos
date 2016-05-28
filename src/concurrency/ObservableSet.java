package concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import composition.ForwardingSet;

public class ObservableSet<E> extends ForwardingSet<E> {

	public ObservableSet(Set<E> s) {
		super(s);
	}

	private final List<SetObserver<E>> observers=new ArrayList<>();
	
	public void addObserver(SetObserver<E> observer){
		synchronized (observers) {
			observers.add(observer);
		}
	}
	
	public boolean removeObserver(SetObserver<E> observer){
		synchronized (observers) {
			return observers.remove(observer);
		}
	}
	
	private void notifyElementAdded(E element){
		List<SetObserver<E>> tem=new ArrayList<>();
		//System.out.println(tem.size());
		//System.out.println(observers.size());
		synchronized (observers) {
			tem=new ArrayList<>(observers);
		}
		for (SetObserver<E> observer : tem) {
			observer.added(this, element);
		}
	}
	
	public boolean add(E element){
		boolean added=super.add(element);
		if (added) {
			notifyElementAdded(element);
		}
		return added;
	}
	
	public boolean addAll(Collection<? extends E> collection){
		boolean r=false;
		for (E e : collection) {
			r|=add(e);
		}
		return r;
	}
}
