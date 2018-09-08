package proov;

import java.net.URL;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void index() {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		Assert.assertThat(response.getBody(), CoreMatchers.containsString("weather stations"));
		Assert.assertThat(response.getBody(), CoreMatchers.containsString("API"));
	}
}