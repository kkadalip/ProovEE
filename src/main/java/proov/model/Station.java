package proov.model;

import lombok.Data;

@Data
public class Station {
	private String name;
	private String wmoCode;
	private Float longitude;
	private Float latitude;
	private String phenomenon;
	private Float visibility;
	private Float precipitations;
	private Float airPressure;
	private Float relativeHumidity;
	private Float airTemperature;
	private Long windDirection;
	private Float windSpeed;
	private Float windSpeedMax;
	private Long waterLevel;
	private Long waterlevelEh2000;
	private Float waterTemperature;
	private Float uvIndex;
}
