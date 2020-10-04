package com.ozayduman.customer.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;


@Data
public class CustomerDTO {
    private String name;
    private String surname;
    private LocalDate birdDate;
}
/*
@Data
 private String n;
    private String s;
    private LocalDate b;
 */
