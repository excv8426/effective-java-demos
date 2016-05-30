package concurrency;

public class Runs implements Runnable {

	@Override
	public void run() {
		System.out.println(this.hashCode());
	}

}
