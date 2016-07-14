package createobject.builder;

public final class Message {
	private String sender;
	private String receiver;
	private String content;
		
	public String getSender() {
		return sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public String getContent() {
		return content;
	}

	public static class Builder{
		private String sender;
		private String receiver;
		private String content="";
		
		public Builder(String s,String r){
			this.sender=s;
			this.receiver=r;
		}
		public Builder content(String c){
			this.content=c;
			return this;
		}
		public Message build(){
			return new Message(this);
		}
	}
	
	private Message(Builder builder){
		sender=builder.sender;
		receiver=builder.receiver;
		content=builder.content;
	}
	
}
