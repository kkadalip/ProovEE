package proov.model.weather.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "station")
@XmlAccessorType(XmlAccessType.FIELD)
public class StationDTO {
	@XmlElement
	private String name;
	@XmlElement(name = "wmocode")
	private String wmoCode;
	@XmlElement
	private Double longitude;
	@XmlElement
	private Double latitude;
	@XmlElement
	private String phenomenon;
	@XmlElement
	private Double visibility;
	@XmlElement
	private Double precipitations;
	@XmlElement(name = "airpressure")
	private Double airPressure;
	@XmlElement(name = "relativehumidity")
	private Double relativeHumidity;
	@XmlElement(name = "airtemperature")
	private Double airTemperature;
	@XmlElement(name = "winddirection")
	private Long windDirection;
	@XmlElement(name = "windspeed")
	private Double windSpeed;
	@XmlElement(name = "windspeedmax")
	private Double windSpeedMax;
	@XmlElement(name = "waterlevel")
	private Long waterLevel;
	@XmlElement(name = "waterlevel_eh2000")
	private Long waterLevelEh2000;
	@XmlElement(name = "watertemperature")
	private Double waterTemperature;
	@XmlElement(name = "uvindex")
	private Double uvIndex;
}