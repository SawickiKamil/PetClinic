package petClinic.model;

import lombok.*;
import petClinic.repositories.OwnerRepository;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person{

    @Builder
    public Owner(Long id, String firstName, String lastName, String address,
                 String city, String telephoneNumber, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.telephoneNumber = telephoneNumber;
        this.pets = pets;
        this.city = city;
        this.address = address;

    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

}

