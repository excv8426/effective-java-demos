package generic;

import java.util.Iterator;
import java.util.Set;

public class TestGeneric {
	public static int setContain(Set<?> s1,Set<?> s2){
		int r=0;
		Iterator<?> iterator=s1.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			if (s2.contains(object)) {
				r++;
			}
		}
		return r;
	}
}
