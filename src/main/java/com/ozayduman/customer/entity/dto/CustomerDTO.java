package com.ozayduman.customer.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;


@Data
public class CustomerDTO {
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
}
/*
@Data
 private String n;
    private String s;
    private LocalDate b;
 */
