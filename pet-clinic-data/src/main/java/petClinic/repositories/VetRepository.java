package petClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petClinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
