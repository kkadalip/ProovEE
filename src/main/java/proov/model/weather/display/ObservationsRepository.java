package proov.model.weather.display;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import proov.model.weather.xml.Observations;

//public interface ObservationsDisplayRepository extends CrudRepository<ObservationsDisplay, Long> {
@RepositoryRestResource(path = "/observations", collectionResourceRel = "app/observations")
public interface ObservationsRepository extends CrudRepository<Observations, Long> {

}
