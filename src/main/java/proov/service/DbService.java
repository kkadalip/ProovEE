package proov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import proov.interfaces.DbI;
import proov.interfaces.DownloadI;
import proov.model.weather.display.ObservationsRepository;
import proov.model.weather.xml.ObservationsUI;

@Slf4j
@Service
public class DbService implements DbI {
	private final DownloadI downloadI;
	private final ObservationsRepository repository;

	@Autowired
	public DbService(ObservationsRepository repository, DownloadI downloadI) {
		this.repository = repository;
		this.downloadI = downloadI;
	}

	@Override
	public void updateObservations() {
		updateObservations(null);
	}

	public void updateObservations(String fileName) {
		log.info("starting updateObservations");
		ObservationsUI obsUI = downloadI.downloadObservationsUI(fileName);
		if (obsUI == null) {
			log.error("downloader observations UI is null, can not save");
			return;
		}
		// TODO instead of persisting with only save or deleting and saving only one, create a separate statistics endpoint and modify the following:
		this.repository.deleteAll();
		this.repository.save(obsUI);
		log.info("finished updateObservations");
	}
}
