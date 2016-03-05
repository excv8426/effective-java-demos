package staticfactorymethod;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Servicefactory {
	private static Map<String, Provider> Providers=new ConcurrentHashMap<>();
	

	private Servicefactory() throws Exception{
		throw new Exception("can not instanced");
	}
	
	public static void registProvider(String name,Provider provider){
		Providers.put(name, provider);
	}

	public static Service newInstance(String name){
		Provider provider=Providers.get(name);
		return provider.newService();
	}
}
