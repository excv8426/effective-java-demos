package createobject.immutable;

import java.util.Date;

public class TestImmutable {
	@SuppressWarnings("deprecation")
	public static void Test(){
		int i1=12700;
		Integer integer1=12700;
		String s1="aaaaaa";
		Date date=new Date();
		Complex complex=new Complex(i1, integer1, s1,date);
		System.out.println(complex);
		i1=i1-1;
		integer1=integer1-1;
		s1="ccccc";
		date.setYear(2015);
		System.out.println(complex);
	}
	
	public static void testInteger(){
		Integer a = 128, b = 128;  
		System.out.println(a == b);
		Integer c = 127, d = 127;  
		System.out.println(c == d);

		int a1 = 1000, b1 = 1000;  
		System.out.println(a1 == b1);
		int c1 = 100, d1 = 100;  
		System.out.println(c1 == d1);
	}
}
