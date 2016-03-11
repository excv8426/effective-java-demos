package overridehashcode;

public class PhoneNumber {
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
		return 42;
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
}
