package petClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petClinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
