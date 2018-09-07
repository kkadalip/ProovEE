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
@ContextConfiguration(classes = {SecurityProperties.class})
@EnableAutoConfiguration
public class SecurityPropertiesTest {

	@Autowired
	private SecurityProperties securityProperties;

	@Test
	public void getTestValue() {
		Assert.assertEquals("123", securityProperties.getTestvalue());
	}

	@Test
	public void getClientId() {
		Assert.assertEquals("proovEE", securityProperties.getOAuth2().getClient().getClientId());
	}
}