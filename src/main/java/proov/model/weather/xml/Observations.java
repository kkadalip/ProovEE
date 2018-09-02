package proov.model.weather.xml;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "observations")
public class Observations {
	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(targetEntity = Station.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@XmlElement(name = "station")
	private List<Station> stations;
	@XmlAttribute(name = "timestamp")
	private Long timestamp;
}