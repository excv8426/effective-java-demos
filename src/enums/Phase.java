package enums;

import java.util.EnumMap;
import java.util.Map;

public enum Phase {
	SOLID,LIQUID,GAS;
	
	public enum Transition{
		MELT(SOLID,LIQUID),
		FREEZE(LIQUID,SOLID),
		BOIL(LIQUID,GAS),
		CONDENSE(GAS,LIQUID),
		SUBLIME(SOLID,GAS),
		DEPOSIT(GAS,SOLID);
		
		private final Phase src;
		private final Phase dst;
		
		Transition(Phase src,Phase dst){
			this.src=src;
			this.dst=dst;
		}
		
		private static final Map<Phase, Map<Phase, Transition>> MAP=new EnumMap<>(Phase.class);
		
		static{
			for (int i = 0; i < Phase.values().length; i++) {
				//System.out.println(Phase.values()[i]);
				MAP.put(Phase.values()[i], new EnumMap<Phase, Transition>(Phase.class));
			}
			for (int j = 0; j < Transition.values().length; j++) {
				//System.out.println(Transition.values()[j].src);
				MAP.get(Transition.values()[j].src).put(Transition.values()[j].dst, Transition.values()[j]);
			}
		}
		
		public static Transition from(Phase src,Phase dst){
			return MAP.get(src).get(dst);
		}
	}
}
