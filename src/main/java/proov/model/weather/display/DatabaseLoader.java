package proov.model.weather.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import proov.interfaces.DownloadI;
import proov.model.weather.xml.ObservationsUI;

@Component
@Slf4j
public class DatabaseLoader implements CommandLineRunner {

	private final DownloadI downloadI;
	private final ObservationsRepository repository;

	@Autowired
	public DatabaseLoader(ObservationsRepository repository, DownloadI downloadI) {
		this.repository = repository;
		this.downloadI = downloadI;
	}

	@Override
	public void run(String... strings) throws Exception {
		ObservationsUI obsUI = downloadI.downloadObservationsUI();
		this.repository.save(obsUI);
	}
}
