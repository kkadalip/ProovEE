package proov.model.weather.display;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import proov.model.weather.xml.ObservationsUI;

@CrossOrigin //(origins = "http://localhost:3000")
@RepositoryRestResource(path = "observations", collectionResourceRel = "observations")
// JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository.
public interface ObservationsRepository extends JpaRepository<ObservationsUI, Long> {

}
