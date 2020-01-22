package petClinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import petClinic.model.*;
import petClinic.services.OwnerService;
import petClinic.services.PetTypeService;
import petClinic.services.SpecialtyService;
import petClinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistrySpecialty = specialtyService.save(dentistry);

        Specialty surgery = new Specialty();
        dentistry.setDescription("Surgery");
        Specialty savedSurgerySpecialty = specialtyService.save(surgery);

        Specialty radiology = new Specialty();
        dentistry.setDescription("Radiology");
        Specialty savedRadiologySpecialty = specialtyService.save(radiology);


        Owner owner1 = new Owner();
        owner1.setFirstName("Jacek");
        owner1.setLastName("Malysiak");
        owner1.setAddress("Polad");
        owner1.setCity("Wroclaw");
        owner1.setTelephoneNumber("345345");

        Pet jaceksPet = new Pet();
        jaceksPet.setPetType(saveDogPetType);
        jaceksPet.setOwner(owner1);
        jaceksPet.setBirthDate(LocalDate.now().minusMonths(20));
        jaceksPet.setName("Fluffy");
        owner1.getPets().add(jaceksPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mojsze");
        owner2.setLastName("Izrael");
        owner2.setAddress("Israel");
        owner2.setCity("A'viv");
        owner2.setTelephoneNumber("2333555");

        Pet mojszesPet = new Pet();
        mojszesPet.setPetType(saveCatPetType);
        mojszesPet.setOwner(owner2);
        mojszesPet.setBirthDate(LocalDate.now().minusDays(300));
        mojszesPet.setName("Miriam");
        owner2.getPets().add(mojszesPet);

        ownerService.save(owner2);

        System.out.println("Loading owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Marta");
        vet1.setLastName("Mazurek");
        vet1.getSpecialities().add(savedRadiologySpecialty);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Kasia");
        vet2.setLastName("Mila");
        vet2.getSpecialities().add(savedSurgerySpecialty);

        vetService.save(vet2);

        System.out.println("Loading vets");
    }
}
