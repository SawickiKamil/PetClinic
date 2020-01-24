package petClinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petClinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
