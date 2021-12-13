package lk.web.linkfirerestservice.api;

import lk.web.linkfirerestservice.dto.LinkFireResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.*;

public class NumberControllerTest extends LinkfireRestServiceApplicationTests {

	@Before
	@Override
	public void setUp() {
		super.setUp();
	}

	@Test
	public void checkIsOddTest() throws Exception {
		String uri = "/api/v1/number/is-odd/13";

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		LinkFireResponse response = super.mapFromJson(mvcResult.getResponse().getContentAsString(), LinkFireResponse.class);
		assertEquals("Success", response.getMessage());
		assertTrue(response.isStatus());
	}

	@Test
	public void checkIsEvenTest() throws Exception {
		String uri = "/api/v1/number/is-odd/12";

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		LinkFireResponse response = super.mapFromJson(mvcResult.getResponse().getContentAsString(), LinkFireResponse.class);
		assertEquals("Success", response.getMessage());
		assertFalse(response.isStatus());
	}

	@Test
	public void checkInvalidInputTest() throws Exception {
		String uri = "/api/v1/number/is-odd/test12";

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);

		LinkFireResponse response = super.mapFromJson(mvcResult.getResponse().getContentAsString(), LinkFireResponse.class);
		assertEquals("Input is not numeric value", response.getMessage());
	}
}
