package generic;

import java.util.Arrays;
import java.util.Collection;

public class Stack<E> {
	private E[] element;
	private int size=0;
	private final int DEFAULT_INITIAL_CAPACITY=16;
	
	@SuppressWarnings("unchecked")
	public Stack(){
		element=(E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(E e){
		checkCapacity();
		element[size++]=e;
	}
	
	public E pop(){
		if (size==0) {
			return null;
		} else {
			E r=element[--size];
			element[size]=null;
			return r;
		}
	}
	
	private void checkCapacity(){
		if (element.length==size) {
			element=Arrays.copyOf(element, size*2+1);
		}
	}
	
	public void pushAll(Iterable<? extends E> src){		
		for (E e : src) {
			push(e);
		}
	}
	
	public void popAll(Collection<? super E> dst){
		while (!isEmpty()) {
			dst.add(pop());
		}
	}
	
	public boolean isEmpty(){
		if (size==0) {
			return true;
		} else {
			return false;
		}
	}
}
