package reflection;

import java.lang.reflect.Method;

public class TestAnnotation {
	
	@ExceptionTest(ArithmeticException.class)
	public static void m1(){
		System.out.println("m1");
		int i=0;
		i=1/i;
	}
	
	@ExceptionTest(IllegalAccessException.class)
	public static void m2(){
		System.out.println("m2");
		int i=0;
		i=1/i;
	}
	public static void m3(){
		System.out.println("m3");
	}
	public static void m4(){
		System.out.println("m4");
	}
	
	public static void test(){
		Method[] methods=TestAnnotation.class.getDeclaredMethods();
		//System.out.println(methods.length);
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].isAnnotationPresent(ExceptionTest.class)) {
				try {
					methods[i].invoke(null);
				} catch (Exception e) {
					Class<? extends Exception> exceClass=methods[i].getAnnotation(ExceptionTest.class).value();
					if (exceClass.isInstance(e.getCause())) {
						System.out.println("expected exception");
					}
				}
			}
		}
	}
}
