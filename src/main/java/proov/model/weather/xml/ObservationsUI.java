package proov.model.weather.xml;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class ObservationsUI {
	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(targetEntity = StationUI.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<StationUI> stations;
	private Long timestamp;
}