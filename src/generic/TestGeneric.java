package generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class TestGeneric {
	public static int setContain(Set<?> s1,Set<?> s2){
		int r=0;
		Iterator<?> iterator=s1.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			if (s2.contains(object)) {
				r++;
			}
		}
		return r;
	}
	
	public static <E> E reduce(List<E> list,Function<E> f,E initval){
		List<E> snapshot;
		synchronized (list) {
			snapshot=new ArrayList<>(list);
		}
		E result=initval;
		Iterator<E> iterator=snapshot.iterator();
		while (iterator.hasNext()) {
			E e = iterator.next();
			result=f.apply(result, e);
		}
		return result;
	}
	
	public static void testreduce(){
		List<String> list=new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(UUID.randomUUID().toString());
		}
		String ss=reduce(list, new StringJoin(), "##");
		System.out.println(ss);
	}
}
