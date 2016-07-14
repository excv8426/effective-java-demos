package test;

import serialization.TestSerialization;

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
		
		System.out.println(subStringcounter("asdweffgabhfs","asw"));
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

}
