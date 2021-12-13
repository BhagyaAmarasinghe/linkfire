package lk.web.linkfirerestservice.api;

import lk.web.linkfirerestservice.dto.LinkFireResponse;
import lk.web.linkfirerestservice.exception.ErrorCode;
import lk.web.linkfirerestservice.exception.LinkFireException;
import lk.web.linkfirerestservice.service.NumberService;
import lk.web.linkfirerestservice.util.LinkFireUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/number")
public class NumberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(NumberController.class);

	@Autowired
	private NumberService numberService;

	@GetMapping(value = "/is-odd/{number}")
	public ResponseEntity<LinkFireResponse> isOdd(@PathVariable String number) throws LinkFireException{

		LOGGER.info("isOddRequest");
		if (!LinkFireUtil.isNumeric(number)) {
			LOGGER.error("isOddResponse : input is not numeric");
			throw new LinkFireException(ErrorCode.INVALID_INPUT);
		}

		boolean isOdd = numberService.isOdd(Integer.parseInt(number));

		LOGGER.info("isOddResponse");
		return ResponseEntity.ok().body(new LinkFireResponse(isOdd, "Success"));
	}
}
