package proov.model.weather.xml;

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
public class StationDTO {
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
}