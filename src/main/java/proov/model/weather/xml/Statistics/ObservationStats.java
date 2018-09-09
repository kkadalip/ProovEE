package proov.model.weather.xml.Statistics;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ObservationStats {
	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(targetEntity = Stats.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Stats statsVisibility;
	@OneToOne(targetEntity = Stats.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Stats statsAirPressure;
	@OneToOne(targetEntity = Stats.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Stats statsHumidity;
	@OneToOne(targetEntity = Stats.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Stats statsAirTemperature;
	@OneToOne(targetEntity = Stats.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Stats statsWindDirection;
	@OneToOne(targetEntity = Stats.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Stats statsWindSpeed;
	@OneToOne(targetEntity = Stats.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Stats statsWaterLevel;
	@OneToOne(targetEntity = Stats.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Stats statsWindChillC;
	@OneToOne(targetEntity = Stats.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Stats statsWindChillMaxC;
	@OneToOne(targetEntity = Stats.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Stats statsWindChillF;
	@OneToOne(targetEntity = Stats.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Stats statsWindChillMaxF;
}
