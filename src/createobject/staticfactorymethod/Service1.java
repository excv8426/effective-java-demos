package createobject.staticfactorymethod;

public class Service1 implements Service {
	public Service1(){
		this.printMyname();
	}
	@Override
	public void printMyname() {
		System.out.println("new Service1");
	}

}
