package lk.web.linkfirerestservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkFireResponse {

	private String message;
	private boolean status;

	public LinkFireResponse() {
	}

	public LinkFireResponse( String message) {
		this.message = message;
	}

	public LinkFireResponse(boolean status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
