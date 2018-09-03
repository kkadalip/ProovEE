package proov.interfaces;

import proov.model.weather.xml.ObservationsDTO;
import proov.model.weather.xml.ObservationsUI;

public interface DownloadI {
	ObservationsDTO downloadsObservationsDTO();

	ObservationsUI downloadsObservationsUI();
}
