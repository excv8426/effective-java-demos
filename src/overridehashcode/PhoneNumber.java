package overridehashcode;

public class PhoneNumber implements Comparable<PhoneNumber> {
	private int areaCode;
	private int lineNumber;
	public PhoneNumber(int areaCode,int lineNumber){
		this.areaCode=areaCode;
		this.lineNumber=lineNumber;
	}
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	@Override
	public int hashCode(){
		int result=17;
		result=result*31+this.areaCode;
		result=result*31+this.lineNumber;
		System.out.println("hashcode:"+result);
		return result;
	}
	
	@Override
	public boolean equals(Object object){
		if (object==this) {
			return true;
		} else {
			if (object instanceof PhoneNumber) {
				PhoneNumber phoneNumber=(PhoneNumber) object;
				return (phoneNumber.areaCode==this.areaCode)&&(phoneNumber.lineNumber==this.lineNumber);
			} else {
				return false;
			}
		}
	}
	
	@Override
	public String toString(){
		StringBuilder result=new StringBuilder();
		result.append(this.areaCode);
		result.append('-');
		result.append(this.lineNumber);
		return result.toString();
	}
	@Override
	public int compareTo(PhoneNumber o) {
		if (this.areaCode!=o.areaCode) {
			return this.areaCode-o.areaCode;
		} else if (this.lineNumber!=o.lineNumber) {
			return this.lineNumber-o.lineNumber;
		}else {
			return 0;
		}
	}
}
