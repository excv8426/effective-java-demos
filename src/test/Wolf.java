package test;

import java.util.Observable;

public class Wolf extends Observable {
	private String name;
	
	public Wolf(String name){
		this.name=name;
	}
	
	public void cry(String state){
		System.out.println(this.name+ " crying ");  
		this.setChanged();
		this.notifyObservers(state);
	}
	
	@Override
	public String toString(){
		return "wolf "+this.name;
	}
}
