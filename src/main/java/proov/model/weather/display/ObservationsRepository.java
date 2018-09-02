package proov.model.weather.display;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import proov.model.weather.xml.Observations;

@RepositoryRestResource(path = "observations", collectionResourceRel = "observations")
public interface ObservationsRepository extends CrudRepository<Observations, Long> {

}
