//package proov.model.weather.display;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//public class ObservationsDisplay {
//	@Id
//	@GeneratedValue
//	private Long id;
//
//	@OneToMany(targetEntity = StationDisplay.class, fetch = FetchType.EAGER)
//	private List<StationDisplay> stations;
//	private Long timestamp;
//
//	// EXTRA
//	//private Date lastUpdated;
//	private String name;
//}
