package petClinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import petClinic.model.Owner;
import petClinic.model.Vet;
import petClinic.services.OwnerService;
import petClinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Jacek");
        owner.setLastName("Malysiak");

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner.setId(2L);
        owner.setFirstName("Mojsze");
        owner.setLastName("Izrael");

        ownerService.save(owner2);

        System.out.println("Loading owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Marta");
        vet1.setLastName("Mazurek");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Kasia");
        vet2.setLastName("Mila");

        vetService.save(vet2);

        System.out.println("Loading vets");
    }
}
