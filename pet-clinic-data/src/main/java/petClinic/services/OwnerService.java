package petClinic.services;

import petClinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
