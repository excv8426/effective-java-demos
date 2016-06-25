package extending;

public class Testextending {
	public static void test() {
		SBclass sBclass=new SBclass();
		System.out.println("**********************************");
		SPclass sPclass=new SPclass();
		System.out.println("**********************************");
		sBclass.m1();
		System.out.println("**********************************");
		sBclass.m2();
		System.out.println("**********************************");
		sPclass.m1();
		System.out.println("**********************************");
		sPclass.m2();
		/*SBclass.m3();
		SBclass.m4();*/
	}
}
