package test.observer;

import java.util.Observable;
import java.util.Observer;

public class Sheep implements Observer {
	private String name;
	
	public Sheep(String name) {
		this.name=name;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Wolf wolf=(Wolf) o;
		System.out.println(" wolf:"+wolf.toString()+" arg:"+arg.toString()+" name:"+this.name);
	}

}
