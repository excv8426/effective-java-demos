package createobject.staticfactorymethod;

public class Provider1 implements Provider {

	@Override
	public Service newService() {
		return new Service1();
	}

}
