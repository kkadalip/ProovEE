package proov.model.weather.display;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import proov.model.weather.xml.Observations;

@RepositoryRestResource(path = "observations", collectionResourceRel = "observations")
// JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository.
public interface ObservationsRepository extends JpaRepository<Observations, Long> {

}
