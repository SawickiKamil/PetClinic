package petClinic.services.map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import petClinic.model.Owner;
import petClinic.model.Pet;
import petClinic.services.OwnerService;
import petClinic.services.PetService;
import petClinic.services.PetTypeService;


import java.util.Set;

@Service
@Primary
public class OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    if (pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(object);

        } else return null;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByName(String lastName) {
        return null;
    }
}
