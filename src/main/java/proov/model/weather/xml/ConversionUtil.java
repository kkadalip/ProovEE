package proov.model.weather.xml;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import proov.enums.TempEnum;
import proov.enums.UnitEnum;
import proov.model.weather.xml.Statistics.ObservationStats;
import proov.model.weather.xml.Statistics.Stats;
import proov.util.UnitUtil;
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
		List<StationUI> stationUIs = convertStationDTOtoUI(o.getStations());
		obsUI.setStations(stationUIs);
		try {
			obsUI.setStatistics(calculateAndSetAverages(stationUIs));
		} catch (Exception ex) {
			log.error("Calculating and setting averages failed", ex);
		}
		return obsUI;
	}

	private static List<StationUI> convertStationDTOtoUI(List<StationDTO> stationDTOs) {
		List<StationUI> stationUIs = new ArrayList<>();
		for (StationDTO sDTO : stationDTOs) {
			StationUI sUI = new StationUI();
			sUI.setName(sDTO.getName());
			sUI.setWmoCode(sDTO.getWmoCode());
			sUI.setLongitude(sDTO.getLongitude());
			sUI.setLatitude(sDTO.getLatitude());
			sUI.setPhenomenon(sDTO.getPhenomenon());
			sUI.setVisibility(sDTO.getVisibility());
			sUI.setVisibilityUnit(UnitEnum.KM.getSymbol());
			sUI.setPrecipitations(sDTO.getPrecipitations());
			sUI.setAirPressure(sDTO.getAirPressure());
			sUI.setAirPressureUnit(UnitEnum.HPA.getSymbol());
			sUI.setRelativeHumidity(sDTO.getRelativeHumidity());
			sUI.setRelativeHumidityUnit(UnitEnum.PERCENTAGE.getSymbol());
			sUI.setAirTemperature(sDTO.getAirTemperature());
			sUI.setAirTemperatureUnit(TempEnum.C.getSymbol());
			sUI.setWindDirection(sDTO.getWindDirection());
			sUI.setWindDirectionUnit(UnitEnum.ANGLE.getSymbol());
			sUI.setWindSpeed(sDTO.getWindSpeed());
			sUI.setWindSpeedMax(sDTO.getWindSpeedMax());
			sUI.setWindSpeedUnit(UnitEnum.MS.getSymbol());
			sUI.setWaterLevel(sDTO.getWaterLevel());
			sUI.setWaterLevelEh2000(sDTO.getWaterLevelEh2000());
			sUI.setWaterLevelUnit(UnitEnum.MM.getSymbol());
			sUI.setWaterTemperature(sDTO.getWaterTemperature());
			sUI.setWaterTemperatureUnit(TempEnum.C.getSymbol());
			sUI.setUvIndex(sDTO.getUvIndex());
			sUI.setWindChillC(WindChillUtil.calcWindChillInC(sDTO.getAirTemperature(), sDTO.getWindSpeed()));
			sUI.setWindChillF(WindChillUtil.calcWindChillInF(sDTO.getAirTemperature(), sDTO.getWindSpeed()));
			sUI.setWindChillMaxC(WindChillUtil.calcWindChillInC(sDTO.getAirTemperature(), sDTO.getWindSpeedMax()));
			sUI.setWindChillMaxF(WindChillUtil.calcWindChillInF(sDTO.getAirTemperature(), sDTO.getWindSpeedMax()));
			stationUIs.add(sUI);
		}
		return stationUIs;
	}

	private static ObservationStats calculateAndSetAverages(List<StationUI> stationUIs) {
		List<Double> visibilities = new ArrayList<>();
		List<Double> airPressures = new ArrayList<>();
		List<Double> humidities = new ArrayList<>();
		List<Double> airtemps = new ArrayList<>();
		List<Double> windDirections = new ArrayList<>();
		List<Double> windSpeeds = new ArrayList<>();
		List<Double> waterLevels = new ArrayList<>();
		List<Double> windChillCs = new ArrayList<>();
		List<Double> windChillMaxCs = new ArrayList<>();
		List<Double> windChillFs = new ArrayList<>();
		List<Double> windChillMaxFs = new ArrayList<>();
		for (StationUI s : stationUIs) {
			if (s.getVisibility() != null) {
				visibilities.add(s.getVisibility());
			}
			if (s.getAirPressure() != null) {
				airPressures.add(s.getAirPressure());
			}
			if (s.getRelativeHumidity() != null) {
				humidities.add(s.getRelativeHumidity());
			}
			if (s.getAirTemperature() != null) {
				airtemps.add(s.getAirTemperature());
			}
			if (s.getWindDirection() != null) {
				windDirections.add(s.getWindDirection());
			}
			if (s.getWindSpeed() != null) {
				windSpeeds.add(s.getWindSpeed());
			}
			if (s.getWaterLevel() != null) {
				waterLevels.add(s.getWaterLevel());
			}
			if (s.getWindChillC() != null) {
				windChillCs.add(s.getWindChillC());
			}
			if (windChillMaxCs != null) {
				windChillMaxCs.add(s.getWindChillMaxC());
			}
			if (windChillFs != null) {
				windChillFs.add(s.getWindChillF());
			}
			if (windChillMaxFs != null) {
				windChillMaxFs.add(s.getWindChillMaxF());
			}
		}
		return ObservationStats.builder()
				.visibility(getStatsD(visibilities))
				.airPressure(getStatsD(airPressures))
				.humidity(getStatsD(humidities))
				.airTemperature(getStatsD(airtemps))
				.windDirection(getStatsD(windDirections))
				.windSpeed(getStatsD(windSpeeds))
				.waterLevel(getStatsD(waterLevels))
				.windChillC(getStatsD(windChillCs))
				.windChillMaxC(getStatsD(windChillMaxCs))
				.windChillF(getStatsD(windChillFs))
				.windChillMaxF(getStatsD(windChillMaxFs))
				.build();
	}

	private static Stats getStatsD(List<Double> data) {
		return data != null ? convertToStatsD(getSummaryStatsD(data)) : null;
	}

	private static DoubleSummaryStatistics getSummaryStatsD(List<Double> data) {
		try {
			if (data == null) {	
				return null;
			}
			return data.stream().filter(Objects::nonNull).mapToDouble(x -> x).summaryStatistics();
		} catch (NullPointerException ex) {
			log.error("getSummaryStatsD NullPointerException", ex);
		}
		return null;
	}

	private static Stats convertToStatsD(DoubleSummaryStatistics d) {
		return d != null ? Stats.builder().min(d.getMin()).max(d.getMax()).average(UnitUtil.round(d.getAverage())).count(d.getCount()).build() : null;
	}
}