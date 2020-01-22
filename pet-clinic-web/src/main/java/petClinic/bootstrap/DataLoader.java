package petClinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import petClinic.model.Owner;
import petClinic.model.PetType;
import petClinic.model.Vet;
import petClinic.services.OwnerService;
import petClinic.services.PetTypeService;
import petClinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jacek");
        owner1.setLastName("Malysiak");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mojsze");
        owner2.setLastName("Izrael");

        ownerService.save(owner2);

        System.out.println("Loading owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Marta");
        vet1.setLastName("Mazurek");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Kasia");
        vet2.setLastName("Mila");

        vetService.save(vet2);

        System.out.println("Loading vets");
    }
}
