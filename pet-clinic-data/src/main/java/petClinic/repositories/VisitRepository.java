package petClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petClinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
