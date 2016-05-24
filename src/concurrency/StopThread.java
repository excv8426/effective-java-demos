package concurrency;

public class StopThread {
	private volatile static boolean stoped=false;
	
	public static void Test(){
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i=0;
				while (!stoped) {
					i++;
				}
			}
		});
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("stoped=true;");
		stoped=true;
	}
}
