package com.ozayduman.customer.repository;

import com.ozayduman.customer.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = {"com.ozayduman.customer"})
class CustomerRepositoryQueryDslTest {

    @Autowired
    DataInitializer initializer;

    final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @BeforeEach
    void setUp() {
        initializer.saveSampleData();
    }

    @Test
    void shouldFindCustomer(){

    }
}
