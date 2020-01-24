package petClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petClinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
