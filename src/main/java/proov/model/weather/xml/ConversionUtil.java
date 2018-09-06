package proov.model.weather.xml;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import proov.util.WindChillUtil;

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
		ObservationsUI obsUI = new ObservationsUI();
		obsUI.setTimestamp(o.getTimestamp());
		obsUI.setStations(convertStationDTOtoUI(o.getStations()));
		return obsUI;
	}

	private static List<StationUI> convertStationDTOtoUI(List<StationDTO> stationDTOs) {
		List<StationUI> stationUIs = new ArrayList<>();
		for (StationDTO sDTO : stationDTOs) {
			Double windChillC = WindChillUtil.calcWindChillInC(sDTO.getAirTemperature(), sDTO.getWindSpeed());
			Double windChillF = WindChillUtil.calcWindChillInF(sDTO.getAirTemperature(), sDTO.getWindSpeed());
			Double windChillMaxC = WindChillUtil.calcWindChillInC(sDTO.getAirTemperature(), sDTO.getWindSpeedMax());
			Double windChillMaxF = WindChillUtil.calcWindChillInF(sDTO.getAirTemperature(), sDTO.getWindSpeedMax());

			StationUI sUI = new StationUI();
			sUI.setName(sDTO.getName());
			sUI.setWmoCode(sDTO.getWmoCode());
			sUI.setLongitude(sDTO.getLongitude());
			sUI.setLatitude(sDTO.getLatitude());
			sUI.setPhenomenon(sDTO.getPhenomenon());
			sUI.setVisibility(sDTO.getVisibility());
			sUI.setPrecipitations(sDTO.getVisibility());
			sUI.setAirPressure(sDTO.getAirPressure());
			sUI.setRelativeHumidity(sDTO.getRelativeHumidity());
			sUI.setAirTemperature(sDTO.getAirTemperature());
			sUI.setWindDirection(sDTO.getWindDirection());
			sUI.setWindSpeed(sDTO.getWindSpeed());
			sUI.setWindSpeedMax(sDTO.getWindSpeedMax());
			sUI.setWaterLevel(sDTO.getWaterLevel());
			sUI.setWaterLevelEh2000(sDTO.getWaterLevelEh2000());
			sUI.setWaterTemperature(sDTO.getWaterTemperature());
			sUI.setUvIndex(sDTO.getUvIndex());
			sUI.setWindChillC(windChillC);
			sUI.setWindChillF(windChillF);
			sUI.setWindChillMaxC(windChillMaxC);
			sUI.setWindChillMaxF(windChillMaxF);
			stationUIs.add(sUI);
		}
		return stationUIs;
	}
}