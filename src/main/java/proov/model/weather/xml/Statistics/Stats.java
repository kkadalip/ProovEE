package proov.model.weather.xml.Statistics;

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
public class Stats {
	@Id
	@GeneratedValue
	private Long id;

	private Double min;
	private Double max;
	private Double average;
	private Long count;
}