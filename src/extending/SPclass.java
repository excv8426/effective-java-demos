package extending;

public class SPclass {
	public void m1(){
		System.out.println("super m1 called.");
	}
	public void m2(){
		System.out.println("super m2 called.");
		m1();
	}
}
