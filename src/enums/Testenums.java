package enums;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import enums.Herb.Type;

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
	
	public static void testEnumSet(){
		Set<PayrollDay> enumSet=EnumSet.of(PayrollDay.FRIDAY,PayrollDay.MONDAY);
		Iterator<PayrollDay> iterator=enumSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
	}
	
	public static void testEnumMap(){
		Herb[] garden=new Herb[3];
		garden[0]=new Herb("one", Type.ANNUAL);
		garden[1]=new Herb("one", Type.BIENNIAL);
		garden[2]=new Herb("one", Type.PERENNIAL);
		Map<Herb.Type, Set<Herb>> herbs=new EnumMap<>(Herb.Type.class);
		
		for (int i = 0; i < Herb.Type.values().length; i++) {
			herbs.put(Herb.Type.values()[i], new HashSet<Herb>());
		}
		
		for (int i = 0; i < garden.length; i++) {
			herbs.get(garden[i].type).add(garden[i]);
		}
		
		System.out.println(herbs);
	}
}
