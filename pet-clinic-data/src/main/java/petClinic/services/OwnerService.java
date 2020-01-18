package petClinic.services;

import petClinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByName(String lastName);

}
