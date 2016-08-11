package test;

/**
 * @author Yuki
 *
 */
public class Test {

	public static void main(String[] args) {
		//Teststaticfactorymethod.newService1();
		//Testbuilder.test();
		//Testsingleton.test();
		//Utility.test();
		//Testhashcode.test();
		//Testclone.test();
		//Testextending.test();
		//TestGeneric.testreduce();
		//TestGeneric.testmax();
		//TestGeneric.testStack();
		//TestGeneric.testUnion();
		//TestGeneric.testSwap();
		//Testenums.testPlanet();
		//Testenums.testOperation();
		//Testenums.testPay();
		//Testenums.testEnumSet();
		//Testenums.testEnumMap();
		//Testenums.testphase();
		//TestAnnotation.test();
		//TestImmutable.testInteger();
		//TestOverload.testboxing();
		//TestReflect.test();
		//StopThread.Test();
		//TestConcurrency.testObserver();
		//TestConcurrency.testExcutor();
		//TestConcurrency.testWatch();
		//TestConcurrency.testList();
		//TestSerialization.testSerializableMessage();
		//TestSerialization.testSerializableSingleton();
		//TestSerialization.testSerializableProxy();
		//System.out.println(subStringcounter("asdweffgabhfs","asw"));
		//TestObserver.testObserver();
		float[] repayment={1000,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f,543.2f};
		creditcardDiscount(0.10f,repayment);
	}
	
	public static int subStringcounter(String full,String sub){
		StringBuilder fullStr=new StringBuilder(full);
		int count=0;
		int index=0;
		if ("".equals(sub)) {
			return 0;
		} else {
			while (true) {
				index=fullStr.indexOf(sub);
				System.out.println(index);
				if (index>-1) {
					count++;
					fullStr.delete(0, index+sub.length());
				} else if (index==-1) {
					break;
				} else {
					throw new UnknownError("Unknown java.lang.String.indexOf return");
				}
				
			}
			return count;
		}
		
	}
	
	
	public static void creditcardDiscount(float rate,float[] repayment){
		float sum=0;
		for (int i = 1; i <= repayment.length; i++) {
			if (i==1) {
				sum=(repayment[i-1])/(1+(rate/12)*i);
			} else {
				sum=sum+repayment[i-1]/(1+(rate/12)*i);
			}
		}
		
		System.out.println(sum);
	}

}
