package proov.model.weather.display;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import proov.interfaces.DownloadI;
import proov.model.weather.xml.Observations;
import proov.model.weather.xml.Station;

@Component
@Slf4j
public class DatabaseLoader implements CommandLineRunner {
	
	@Autowired
	DownloadI downloadI;

	//private final ObservationsDisplayRepository repository;
	private final ObservationsRepository repository;

	@Autowired
	//public DatabaseLoader(ObservationsDisplayRepository repository) {
	public DatabaseLoader(ObservationsRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		//ObservationsDisplay example = ObservationsDisplay.builder().name("lalala").build();
		//this.repository.save(example);


		Observations downloadedObservations = downloadI.downloadStuff();
		
		
		//this.repository.save(convertObservationsToDisplay(downloadedObservations));
		this.repository.save(downloadedObservations); // TODO save transient before flushing
	}
	
//	private ObservationsDisplay convertObservationsToDisplay(Observations observations){
//		if(observations == null){
//			log.error("convertObservationsToDisplay observations is null!, cannot convert");
//		}
//		ObservationsDisplay observationsDisplay = ObservationsDisplay.builder()
//				.stations()
//				.timestamp(observations.getTimestamp())
//				.build();
//
//		
//		List<Station> stations = observations.getStations();
//		List<StationDisplay> stationDisplays = new ArrayList<>();
//		stations.forEach(station -> stationDisplays.add(
//				StationDisplay.builder()
//						.
//		.build));
//		
//		for(Station s : stations){
//			stationDisplays.add()
//		}
//		
//		
//		return
//	}
}
