package proov.model.weather.xml;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
class StationUI {
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String wmoCode;
	private Double longitude;
	private Double latitude;
	private String phenomenon;
	private Double visibility;
	private String visibilityUnit;
	private Double precipitations;
	private Double airPressure;
	private String airPressureUnit;
	private Double relativeHumidity;
	private String relativeHumidityUnit;
	private Double airTemperature;
	private String airTemperatureUnit;
	private Double windDirection;
	private String windDirectionUnit;
	private Double windSpeed;
	private Double windSpeedMax;
	private String windSpeedUnit;
	private Double waterLevel;
	private Double waterLevelEh2000;
	private String waterLevelUnit;
	private Double waterTemperature;
	private String waterTemperatureUnit;
	private Double uvIndex;

	private Double windChillC;
	private Double windChillMaxC;
	private Double windChillF;
	private Double windChillMaxF;
}