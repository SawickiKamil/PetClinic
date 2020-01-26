package petClinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petClinic.model.Owner;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;


class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long ownerId = 1L;
    final String lastName = "Brown";

    @BeforeEach
    void setUp() {

        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());

        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(ownerId, owners.size());
    }


    @Test
    void saveExcisingId() {
        Owner owner2 = Owner.builder().id(2L).build();
        Owner savedOwner = ownerServiceMap.save(owner2);

        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void savedNoId() {
        Owner owner3 = ownerServiceMap.save(Owner.builder().build());

        assertNotNull(owner3);
        assertNotNull(owner3.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByName() {
        Owner brown = ownerServiceMap.findByName(lastName);

        assertNotNull(brown);
        assertEquals(ownerId, brown.getId());
    }

    @Test
    void findByNameNotFound() {
        Owner brown = ownerServiceMap.findByName("foo");

        assertNull(brown);
    }
}