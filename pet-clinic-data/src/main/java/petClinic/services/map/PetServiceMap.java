package petClinic.services.map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import petClinic.model.Pet;
import petClinic.services.PetService;

import java.util.Set;

@Service
@Primary
public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
