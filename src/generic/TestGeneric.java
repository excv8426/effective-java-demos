package generic;

import java.util.ArrayList;
import java.util.HashSet;
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
	
	/**
	 *1 T实现了Comparable接口
	 *2 T的父类实现了Comparable接口
	 * */
	public static <T extends Comparable<? super T>> T max(List<? extends T> list){
		Iterator<? extends T> iterator=list.iterator();
		T r=iterator.next();
		while (iterator.hasNext()) {
			T t = iterator.next();
			if (t.compareTo(r)>0) {
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
	
	public static void testStack(){
		Stack<Number> stack=new Stack<>();
		stack.push(1);
		stack.push(1.5);
		stack.push(new Long("1666666"));
		List<Long> pushlist=new ArrayList<>();
		pushlist.add(new Long("266666666666"));
		pushlist.add(new Long("366666666666"));
		pushlist.add(new Long("466666666666"));
		stack.pushAll(pushlist);
		List<Number> poplist=new ArrayList<>();
		stack.popAll(poplist);
		for (int i = 0; i < poplist.size(); i++) {
			System.out.println(poplist.get(i));
		}
	}
	
	public static <E> Set<E> union(Set<? extends E> s1,Set<? extends E> s2){
		Set<E> r=new HashSet<>();
		r.addAll(s1);
		r.addAll(s2);
		return r;
	}
	
	public static void testUnion(){
		Set<Integer> integers=new HashSet<>();
		integers.add(1);
		integers.add(2);
		Set<Float> floats=new HashSet<>();
		floats.add((float) 1.5);
		floats.add((float) 2.5);
		Set<Number> numbers=new HashSet<>();
		numbers=TestGeneric.<Number>union(integers, floats);
		Iterator<Number> iterator=numbers.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
	}
}
