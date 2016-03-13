package overridehashcode;

import java.util.HashMap;
import java.util.Map;

public class Testhashcode {

	public static void test(){
		
		PhoneNumber p1=new PhoneNumber(0335, 123456);
		PhoneNumber p2=new PhoneNumber(0335, 1234567);
		PhoneNumber p3=new PhoneNumber(0335, 123456);
		/*System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());*/
		
		Map<PhoneNumber, String> map=new HashMap<>();
		map.put(p1, "p1");
		System.out.println(map.get(p1));
		System.out.println(map.get(p2));
		System.out.println(map.get(p3));
		System.out.println(map.get(new PhoneNumber(0335, 123456)));
	}
}
