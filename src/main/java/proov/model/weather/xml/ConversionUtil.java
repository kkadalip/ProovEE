package proov.model.weather.xml;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConversionUtil {
	private ConversionUtil() {
		throw new IllegalStateException("Utility class!");
	}

	public static ObservationsUI convertDTOtoUI(ObservationsDTO o) {
		if (o == null) {
			log.error("convertDTOtoUI observationsDTO o is null!");
			return null;
		}
		return ObservationsUI.builder()
				.stations(convertStationDTOtoUI(o.getStations()))
				.timestamp(o.getTimestamp())
				.build();
	}

	private static List<StationUI> convertStationDTOtoUI(List<StationDTO> stationDTOs) {
		List<StationUI> stationUIs = new ArrayList<>();
		for (StationDTO sDTO : stationDTOs) {
			StationUI stationUI = StationUI.builder()
					.name(sDTO.getName())
					.wmoCode(sDTO.getWmocode())
					.longitude(sDTO.getLongitude())
					.latitude(sDTO.getLatitude())
					.phenomenon(sDTO.getPhenomenon())
					.visibility(sDTO.getVisibility())
					.precipitations(sDTO.getPrecipitations())
					.airPressure(sDTO.getAirpressure())
					.relativeHumidity(sDTO.getRelativehumidity())
					.airTemperature(sDTO.getAirtemperature())
					.windDirection(sDTO.getWinddirection())
					.windSpeed(sDTO.getWindspeed())
					.windSpeedMax(sDTO.getWindspeedmax())
					.waterLevel(sDTO.getWaterlevel())
					.waterLevelEh2000(sDTO.getWaterlevel_eh2000())
					.waterTemperature(sDTO.getWatertemperature())
					.uvIndex(sDTO.getUvindex())
					.build();
			stationUIs.add(stationUI);
		}
		return stationUIs;
	}
}
