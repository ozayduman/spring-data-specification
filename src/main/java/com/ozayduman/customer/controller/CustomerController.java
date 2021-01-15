package com.ozayduman.customer.controller;

import com.github.ozayduman.specificationbuilder.dto.*;
import com.github.ozayduman.specificationbuilder.dto.PageRequestDTO.SortDTO;
import com.github.ozayduman.specificationbuilder.dto.operation.*;
import com.ozayduman.customer.mapper.CustomerMapper;
import com.ozayduman.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Transactional
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/query")
    public PageResultDTO query(@RequestBody PageRequestDTO pageRequestDTO){
        return PageResultDTO.from(customerService.query(pageRequestDTO), CustomerMapper.INSTANCE::toDTO);
    }

    @GetMapping("/ping")
    public String ping(){
        return "OK";
    }


    /**
     * update the customer given by email
     * email: od@gmail.com
     * set surname to 'xxxxx'
     */


    /**
     * update the customer given by email
     * email: od@gmail.com
     * set surname to 'xxxxx'
     * Then throw a checked exception
     * Then throw unchecked exception
     * Then throw a checked exception but prevent rollback
     */

}
