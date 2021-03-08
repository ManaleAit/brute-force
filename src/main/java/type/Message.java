package type;

enum MessageEnum {

	MultipleError, incorrectMessage;

}

public class Message {
	private MessageEnum msg;

	public Message(MessageEnum msg) {
		this.msg = msg;
	}
	public Message() {
	}

	public String getMyMessage() {
		switch (msg) {
		case MultipleError:
			return "Multiple erroneous credentials, your account is locked.";
		

		case incorrectMessage:
			return "User or password are incorrect.";
			

		default:
			return "Welcome ";

		}
	}

	public MessageEnum getMsg() {
		return msg;
	}

	public void setMsg(MessageEnum msg) {
		this.msg = msg;
	}
	
	
	
}