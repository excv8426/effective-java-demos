package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class ExcutorWatch {
	public static long time(Executor executor,int concurrency,final Runnable action){
		final CountDownLatch ready=new CountDownLatch(concurrency);
		final CountDownLatch start=new CountDownLatch(1);
		final CountDownLatch done=new CountDownLatch(concurrency);
		
		for (int i = 0; i < concurrency; i++) {
			executor.execute(new Runnable() {
				
				@Override
				public void run() {
					ready.countDown();
					try {
						start.await();
						action.run();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						done.countDown();
					}
					
				}
			});
		}
		long starttime=0;
		try {
			ready.await();
			starttime=System.nanoTime();
			start.countDown();
			done.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return System.nanoTime()-starttime;
	}
}
