package extending;

public class Testextending {
	public static void test() {
		System.out.println("***************创建子类*******************");
		SBclass sBclass=new SBclass();
		System.out.println("***************创建父类*******************");
		SPclass sPclass=new SPclass();
		System.out.println("***************调用子类m1*******************");
		sBclass.m1();
		System.out.println("***************调用子类m2*******************");
		sBclass.m2();
		System.out.println("***************调用父类m1*******************");
		sPclass.m1();
		System.out.println("***************调用父类m2*******************");
		sPclass.m2();
		/*SBclass.m3();
		SBclass.m4();*/
	}
}
