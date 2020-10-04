package com.ozayduman.customer.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@Transactional
public class CustomerController {

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
