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
import proov.config.properties.WeatherProperties;
import proov.interfaces.DownloadI;
import proov.model.weather.xml.ConversionUtil;
import proov.model.weather.xml.ObservationsDTO;
import proov.model.weather.xml.ObservationsUI;
import proov.model.weather.xml.StationDTO;

@Slf4j
@Service
public class DownloadService implements DownloadI {
	private final WeatherProperties weatherProperties;

	@Autowired
	public DownloadService(WeatherProperties weatherProperties) {
		this.weatherProperties = weatherProperties;
	}

	public ObservationsDTO downloadObservationsDTO() {
		log.info("starting download");
		ObservationsDTO observations = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ObservationsDTO.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			if (weatherProperties.isDownloadDevmodeOfflineSample()) {
				String pathToFile = "src/main/resources/static/observations_offline.xml";
				log.info("offline download url is " + pathToFile);
				observations = (ObservationsDTO) jaxbUnmarshaller.unmarshal(new File(pathToFile));
			} else {
				log.info("online download url is " + weatherProperties.getDownloadUrl());
				// TODO only download if time since last download is >1 minutes. (After first download start 1 hour intervals and only retry if didn't get a newer result). 
				
				observations = (ObservationsDTO) jaxbUnmarshaller.unmarshal(new URL(weatherProperties.getDownloadUrl()));
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
	public ObservationsUI downloadObservationsUI() {
		return ConversionUtil.convertDTOtoUI(downloadObservationsDTO());
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
