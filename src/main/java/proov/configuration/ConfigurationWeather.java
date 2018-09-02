package proov.configuration;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Configuration //  for Spring to be able to find this bean and make it a candidate for injection.
@PropertySource("classpath:weather.properties")
@ConfigurationProperties //(prefix = "weather")
public class ConfigurationWeather {

	@NotNull
	@Value("${download.url}")
	private String downloadURL;

	@Value("${download.devmode.offline-sample}")
	private boolean downloadOfflineSampleInstead;

	public boolean isDownloadDevmodeOfflineSample() {
		if (downloadOfflineSampleInstead) {
			log.warn("DEV MODE ON! USING OFFLINE WEATHER XML SAMPLE INSTEAD");
		}
		return downloadOfflineSampleInstead;
	}
}
