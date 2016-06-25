package extending;

public class SBclass extends SPclass {
	
	public SBclass(){
		System.out.println("sub constructor called.");
	}
	
	@Override
	public void m1(){
		System.out.println("sub m1 called.");
		super.m1();
	}
	
	@Override
	public void m2(){
		System.out.println("sub m2 called.");
		super.m2();
	}
	

	public static void m3(){
		System.out.println("sub m3 called.");

	}
	

	public static void m4(){
		System.out.println("sub m4 called.");

	}
}
