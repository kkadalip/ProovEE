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
import proov.model.weather.xml.ConversionUtil;
import proov.model.weather.xml.ObservationsDTO;
import proov.model.weather.xml.ObservationsUI;
import proov.model.weather.xml.StationDTO;

@Slf4j
@Service
public class DownloadService implements DownloadI {
	private final ConfigurationWeather confWeather;

	@Autowired
	public DownloadService(ConfigurationWeather confWeather) {
		this.confWeather = confWeather;
	}

	public ObservationsDTO downloadsObservationsDTO() {
		log.info("starting download");
		ObservationsDTO observations = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ObservationsDTO.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			if (confWeather.isDownloadDevmodeOfflineSample()) {
				String pathToFile = "src/main/resources/static/observations_offline.xml";
				log.info("offline download url is " + pathToFile);
				observations = (ObservationsDTO) jaxbUnmarshaller.unmarshal(new File(pathToFile));
			} else {
				log.info("online download url is " + confWeather.getDownloadURL());
				observations = (ObservationsDTO) jaxbUnmarshaller.unmarshal(new URL(confWeather.getDownloadURL()));
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

	@Override
	public ObservationsUI downloadsObservationsUI() {
		return ConversionUtil.convertDTOtoUI(downloadsObservationsDTO());
	}

	private void debug(ObservationsDTO observations) {
		if (observations != null) {
			List<StationDTO> displayedStations = observations.getStations();
			for (StationDTO station : displayedStations) {
				log.info(String.valueOf(station));
			}
		} else {
			log.error("observations is null");
		}
	}
}
