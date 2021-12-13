package lk.web.linkfirerestservice.exception;


public class LinkFireException extends Exception{

	private static final long serialVersionUID = 1279921095222616454L;
	private final ErrorCode errorCode;

	public LinkFireException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
