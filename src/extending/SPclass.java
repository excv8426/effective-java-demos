package extending;

public class SPclass {
	
	public SPclass(){
		System.out.println("super constructor called.");
		this.m1();
	}
	
	public void m1(){
		System.out.println("super m1 called.");
	}
	public void m2(){
		System.out.println("super m2 called.");
		m1();
	}
	
	public static void m3(){
		System.out.println("super m3 called.");
	}
	
	public static void m4(){
		System.out.println("super m4 called.");
		m3();
	}
}
