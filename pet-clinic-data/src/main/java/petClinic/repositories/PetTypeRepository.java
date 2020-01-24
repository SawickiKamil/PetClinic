package petClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petClinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
