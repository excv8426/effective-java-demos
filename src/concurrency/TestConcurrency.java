package concurrency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
	
	public static void testWatch(){
		ExecutorService executorService=Executors.newFixedThreadPool(10);
		long time=ExcutorWatch.time(executorService, 10, new Runs());
		executorService.shutdown();
		System.out.println(time/1000);
	}
	
	public static void testList(){
		List<Integer> i1=new ArrayList<>();
		List<Integer> i2=new Vector<>();
		ExecutorService executorService=Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10000; i++) {
			executorService.execute(new ListAdd(i1, i2));
		}
		executorService.shutdown();
		try {
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i1.size());
		System.out.println(i2.size());
	}
}
