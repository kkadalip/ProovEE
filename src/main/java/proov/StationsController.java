package proov;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proov.model.weather.display.ObservationsRepository;
import proov.model.weather.xml.ObservationsUI;

@RestController
public class StationsController {
	private final ObservationsRepository observationsRepository;

	@Autowired
	public StationsController(ObservationsRepository observationsRepository) {
		this.observationsRepository = observationsRepository;
	}

	@CrossOrigin
	@GetMapping("/stations")
	public List<ObservationsUI> getAllStations() {
		return new ArrayList<>(observationsRepository.findAll());
	}
}