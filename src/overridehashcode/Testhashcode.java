package overridehashcode;

public class Testhashcode {

	public static void test(){
		PhoneNumber p1=new PhoneNumber(0335, 123456);
		PhoneNumber p2=new PhoneNumber(0335, 123456);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}
}
