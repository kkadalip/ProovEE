package proov.service;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import proov.configuration.ConfigurationWeather;
import proov.interfaces.DownloadI;
import proov.model.weather.xml.Observations;
import proov.model.weather.xml.Station;

@Slf4j
@Service
//@EnableConfigurationProperties(ConfigurationWeather.class)
public class DownloadService implements DownloadI {
	private final ConfigurationWeather confWeather;

	//private ConfigurationWeather confWeather = new ConfigurationWeather(); // TODO injecting eg Autowired
        
	private List<Station> displayedStations = null;

	@Autowired
	public DownloadService(ConfigurationWeather confWeather) {
		this.confWeather = confWeather;
	}

	public Observations downloadStuff() {
		log.info("starting download");
		Observations observations = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Observations.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			if (confWeather.isDownloadDevmodeOfflineSample()) {
				String pathToFile = "src/main/resources/static/observations_offline.xml";
				log.info("offline download url is " + pathToFile);
				observations = (Observations) jaxbUnmarshaller.unmarshal(new File(pathToFile));
			} else {
				log.info("online download url is " + confWeather.getDownloadURL());
				observations = (Observations) jaxbUnmarshaller.unmarshal(new URL(confWeather.getDownloadURL()));
			}
		} catch (JAXBException e) {
			log.error("jaxb failed", e);
		} catch (MalformedURLException e) {
			log.error("downloadURL failed", e);
		}
		log.info("download finished");
		debug(observations);
		return observations;
	}

	private void debug(Observations observations) {
		if (observations != null) {
			log.info("Observations timestamp: " + observations.getTimestamp());
			displayedStations = observations.getStations();
			for (Station station : displayedStations) {
				log.info(String.valueOf(station));
			}
		} else {
			log.error("observations is null");
		}
	}
}
