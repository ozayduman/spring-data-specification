package com.ozayduman.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Phone {
    @Id
    @GeneratedValue
    private Long id;

    private PhoneType phoneType;
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_customer_id")
    private Customer customer;

    @Override
    public String toString() {
        return "Phone{" +
                "phoneType=" + phoneType +
                ", number='" + number + '\'' +
                ", customer=" + customer +
                '}';
    }
}
