package createobject.noinstance;

public class Utility {
	private Utility(){
		throw new AssertionError("no instance");
	}
	
	public static void test(){
		Utility utility=new Utility();
	}
}
