package proov.model.weather.xml;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import proov.util.WindChillUtil;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Station {
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String wmocode;
	private Double longitude;
	private Double latitude;
	private String phenomenon;
	private Double visibility;
	private Double precipitations;
	private Double airpressure;
	private Double relativehumidity;
	private Double airtemperature;
	private Long winddirection;
	private Double windspeed;
	private Double windspeedmax;
	private Long waterlevel;
	private Long waterlevel_eh2000;
	private Double watertemperature;
	private Double uvindex;

	private Double windChillC;
	private Double windChillMaxC;
	private Double windChillF;
	private Double windChillMaxF;

	public Double getWindchillC() {
		return WindChillUtil.calculateWindChillInCelsius(airtemperature, windspeed);
	}

	public Double getWindchillMaxC() {
		return WindChillUtil.calculateWindChillInCelsius(airtemperature, windspeedmax);
	}

	public Double getWindchillF() {
		return WindChillUtil.calculateWindChillInFahrenheit(airtemperature, windspeed);
	}

	public Double getWindchillMaxF() {
		return WindChillUtil.calculateWindChillInFahrenheit(airtemperature, windspeedmax);
	}
}