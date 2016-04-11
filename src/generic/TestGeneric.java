package generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import overridehashcode.PhoneNumber;

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
	
	public static <T extends Comparable<T>> T max(List<T> list){
		Iterator<T> iterator=list.iterator();
		T r=list.get(0);
		while (iterator.hasNext()) {
			T t = iterator.next();
			if (r.compareTo(t)<0) {
				r=t;
			}
		}
		return r;
	}
	
	public static void testmax(){
		List<PhoneNumber> list=new ArrayList<>();
		list.add(new PhoneNumber(335, 6010867));
		list.add(new PhoneNumber(311, 6010863));
		list.add(new PhoneNumber(336, 6010866));
		list.add(new PhoneNumber(336, 6010864));
		System.out.println(max(list));
	}
}
