package generic;

public class StringJoin implements Function<String> {

	@Override
	public String apply(String e1, String e2) {
		return e1+e2;
	}

}
