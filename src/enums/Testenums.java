package enums;

public class Testenums {
	public static void testPlanet(){
		Planet.values();
		for (int i = 0; i < Planet.values().length; i++) {
			System.out.println(Planet.values()[i].name());
		}
		System.out.println(Planet.EARTH.mass());
		System.out.println(Planet.EARTH.name());
		System.out.println(Planet.EARTH.ordinal());
		System.out.println(Planet.EARTH.radius());
		System.out.println(Planet.EARTH.surfaceGravity());
		System.out.println(Planet.EARTH.surfaceWeigth(1));
		System.out.println(Planet.EARTH.toString());
	}
	
	public static void testOperation(){
		for (int i = 0; i < Operation.values().length; i++) {
			System.out.println(Operation.values()[i].apply(2, 4));
		}
	}
	
	public static void testPay(){
		for (int i = 0; i < PayrollDay.values().length; i++) {
			System.out.println(PayrollDay.values()[i].name());
			System.out.println(PayrollDay.values()[i].pay(9, 10));
		}
	}
}
