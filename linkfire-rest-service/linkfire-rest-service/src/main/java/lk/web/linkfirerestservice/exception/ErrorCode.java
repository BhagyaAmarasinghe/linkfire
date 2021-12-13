package lk.web.linkfirerestservice.exception;

public enum ErrorCode {

	INVALID_INPUT( "Input is not numeric value");

	private String message;

	private ErrorCode(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
