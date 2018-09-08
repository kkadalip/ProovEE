// SERVER SIDE TESTING https://docs.spring.io/spring/docs/current/spring-framework-reference/testing.html
package proov;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;
import proov.model.weather.display.ObservationsRepository;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(StationsController.class)
@ContextConfiguration(classes = {StationsController.class})
//@AutoConfigureWebClient
//@EnableAutoConfiguration
//@EnableSpringDataWebSupport
public class StationsControllerTest {
	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ObservationsRepository observationsRepository;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getAllStationsOK() throws Exception {
		this.mockMvc.perform(getReqStations()).andExpect(status().isOk());
	}

	@Test
	public void getAllStationsUTF8() throws Exception {
		mockMvc.perform(getReqStations().accept(MediaType.APPLICATION_JSON_UTF8));
	}

	private MockHttpServletRequestBuilder getReqStations() {
		return get("/stations"); // /stationsTest
	}

	@Test
	public void getAllStations404() throws Exception {
		this.mockMvc.perform(get("/stations/doesnotexist")).andExpect(status().isNotFound());
	}

	@Test
	public void getAllStationsBody() throws Exception {
		MvcResult result = mockMvc.perform(
				getReqStations()
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print()) // TODO body is empty []?
				//.andExpect(jsonPath("station.name", is("Näidis linn kõigi väärtustega")))
				.andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
		String content = response.getContentAsString();
		log.info("getAllStationsBody content is " + content);
	}
}