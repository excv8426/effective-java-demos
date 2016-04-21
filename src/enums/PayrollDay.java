package enums;

public enum PayrollDay {
	MONDAY(PayType.WEEKDAY),
	TUESDAY(PayType.WEEKDAY),
	WEDNESDAY(PayType.WEEKDAY),
	THURSDAY(PayType.WEEKDAY),
	FRIDAY(PayType.WEEKDAY),
	SATURDAY(PayType.WEEKEND),
	SUNDAY(PayType.WEEKEND);
	
	private final PayType payType;
	
	PayrollDay(PayType payType){
		this.payType=payType;
	}
	
	double pay(double hours,double rate){
		return payType.pay(hours, rate);
	}
	
	private enum PayType{
		WEEKDAY{
			double overtimePay(double hours,double rate){
				if (hours<=HOURS_PER_SHIFT) {
					return 0;
				} else {
					return (hours-HOURS_PER_SHIFT)*rate/2;
				}
			}
		},WEEKEND{
			double overtimePay(double hours,double rate){
				return hours*rate/2;
			}
		};
		private static final int HOURS_PER_SHIFT=8;
		
		abstract double overtimePay(double hours,double rate);
		
		double pay(double hours,double rate){
			double basepay=hours*rate;
			return basepay+overtimePay(hours, rate);
		}
	}
}
