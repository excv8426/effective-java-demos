package overload;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestOverload {
	public static void testboxing(){
		Set<Integer> set=new HashSet<>();
		List<Integer> list=new ArrayList<>();
		for (int i = -3; i < 3; i++) {
			set.add(i);
			list.add(i);
		}
		for (int i = 0; i < 3; i++) {
			set.remove(i);
			//list.remove(i);
			list.remove(Integer.valueOf(i));
		}
		
		System.out.println(set);
		System.out.println(list);
	}
}
