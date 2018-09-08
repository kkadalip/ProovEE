package proov.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Configuration
@PropertySource("classpath:config/application.yml")
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
	private String testvalue;
	private OAuth2 oAuth2;

	@Data
	public static class OAuth2 {
		private Client client;
		private Resource resource;
		
		@Data
		static class Client {
			private String clientId;
			private String clientSecret;
		}

		@Data
		static class Resource {
			private String tokenInfoUri;
			private String userInfoUri;
			private String token;
		}
	}
}
