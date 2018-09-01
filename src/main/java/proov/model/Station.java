package proov.model;

import lombok.Data;

@Data
public class Station {
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