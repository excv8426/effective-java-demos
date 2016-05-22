package reflection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class TestReflect {
	@SuppressWarnings("unchecked")
	public static void variableSet(String classname,Collection<? extends String> c){
		Class<?> cl=null;
		try {
			cl=Class.forName(classname);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Set<String> set=null;
		
		try {
			set=(Set<String>) cl.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		set.addAll(c);
		System.out.println(set);
	}
	
	public static void test(){
		variableSet("java.util.HashSet",Arrays.asList("f","m","v","t","b"));
		variableSet("java.util.TreeSet",Arrays.asList("f","m","v","t","b"));
	}
}
