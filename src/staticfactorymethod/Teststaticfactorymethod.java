package staticfactorymethod;

public class Teststaticfactorymethod {
	public static void newService1(){
		Servicefactory.registProvider("provider1", new Provider1());
		 Service service=Servicefactory.newInstance("provider1");
		 System.out.println(service.getClass().getName());
	}
}
