package extending;

public class SBclass extends SPclass {
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
}
