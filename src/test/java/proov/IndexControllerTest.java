package proov;

import java.net.URL;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.CrossOrigin;

import proov.config.properties.WeatherProperties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {IndexController.class, WeatherProperties.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class IndexControllerTest {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}

	@Test
	public void indexOK() {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
	}

	@Test
	public void indexContainsKeywords() {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		Assert.assertThat(response.getBody(), CoreMatchers.containsString("Swagger UI"));
		Assert.assertThat(response.getBody(), CoreMatchers.containsString("Observations"));
	}
}