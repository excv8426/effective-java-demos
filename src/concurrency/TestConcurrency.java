package concurrency;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestConcurrency {
	public static void testObserver(){
		ObservableSet<Integer> set=new ObservableSet<>(new HashSet<Integer>());
		set.addObserver(new SetObserver<Integer>() {
			
			@Override
			public void added(ObservableSet<Integer> set, Integer element) {
				System.out.println(element);
				if (element==23) {
					set.removeObserver(this);
				}
				
			}
		});
		
		for (int i = 0; i < 100; i++) {
			set.add(i);
		}
	}
	
	public static void testExcutor(){
		ExecutorService singleexecutor=Executors.newSingleThreadExecutor();
		singleexecutor.execute(new Runs());
		singleexecutor.shutdown();
		ExecutorService poolexecutor=Executors.newFixedThreadPool(3);
		poolexecutor.execute(new Runs());
		poolexecutor.execute(new Runs());
		poolexecutor.execute(new Runs());
		poolexecutor.execute(new Runs());
		poolexecutor.shutdown();
	}
}
