package generic;

import java.util.Arrays;

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
	
	public E pop() throws Exception{
		if (size==0) {
			throw new Exception();
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
}
