package proov.model.weather.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "observations")
public class ObservationsDTO {
	@XmlElement(name = "station")
	private List<StationDTO> stations;

	@XmlAttribute(name = "timestamp")
	private Long timestamp;
}