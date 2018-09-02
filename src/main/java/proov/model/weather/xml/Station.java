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
public class Station { //StationDisplay {
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String wmocode;
	private Float longitude;
	private Float latitude;
	private String phenomenon;
	private Float visibility;
	private Float precipitations;
	private Float airpressure;
	private Float relativehumidity;
	private Float airtemperature;
	private Long winddirection;
	private Float windspeed;
	private Float windspeedmax;
	private Long waterlevel;
	private Long waterlevel_eh2000;
	private Float watertemperature;
	private Float uvindex;
}