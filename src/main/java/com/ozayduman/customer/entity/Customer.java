package com.ozayduman.customer.entity;

import lombok.*;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.entity.AbstractEntity;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.entity.AbstractVersionedEntity;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.entity.AuditableEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer extends AuditableEntity {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String email;
    @NonNull
    private LocalDate birdDate;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

    public void addPhone(Phone phone){
        phone.setCustomer(this);
        phones.add(phone);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birtDate=" + birdDate +
                '}';
    }

}
