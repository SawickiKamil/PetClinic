package petClinic.services;

import petClinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByName(String lastName);

}
