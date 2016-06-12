package concurrency;

import java.util.List;
import java.util.Random;

public class ListAdd implements Runnable {
	List<Integer> i1;
	List<Integer> i2;
	
	public ListAdd(List<Integer> i1,List<Integer> i2){
		this.i1=i1;
		this.i2=i2;
	}
	
	@Override
	public void run() {
		Random random=new Random();
		this.i1.add(random.nextInt());
		this.i2.add(random.nextInt());
	}

}
