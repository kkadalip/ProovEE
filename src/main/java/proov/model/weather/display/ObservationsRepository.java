package proov.model.weather.display;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import proov.model.weather.xml.ObservationsUI;

@CrossOrigin
@Repository
@RepositoryRestResource(path = "observations", collectionResourceRel = "observations")
public interface ObservationsRepository extends JpaRepository<ObservationsUI, Long> {

}
