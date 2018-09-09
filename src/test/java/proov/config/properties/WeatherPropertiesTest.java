package proov.config.properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {WeatherProperties.class})
@EnableAutoConfiguration
public class WeatherPropertiesTest {

	@Autowired
	private WeatherProperties weatherProperties;

	@Test
	public void downloadUrlExists() {
		Assert.assertNotNull("Download URL must have a value", weatherProperties.getDownloadUrl());
	}

	@Test
	public void downloadUrlValueCorrect() {
		Assert.assertEquals("http://www.ilmateenistus.ee/ilma_andmed/xml/observations.php", weatherProperties.getDownloadUrl());
	}
}