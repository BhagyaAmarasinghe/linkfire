package lk.web.linkfirerestservice.exception;

import lk.web.linkfirerestservice.dto.LinkFireResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = LinkFireException.class)
	public ResponseEntity<LinkFireResponse> handleGlobleException(LinkFireException lfException) {

		String message;
		message = lfException.getErrorCode().getMessage();
		return ResponseEntity.status(400).body(new LinkFireResponse(message));
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<LinkFireResponse> handleGlobleException(RuntimeException e) {
		LOGGER.error(e.getMessage(), e);
		return ResponseEntity.status(500).body(new LinkFireResponse(e.getMessage()));
	}

}
