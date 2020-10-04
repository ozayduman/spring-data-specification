package com.ozayduman.customer.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@DataJpaTest
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = {"com.ozayduman.customer"})
class CustomerSpecificationRepositoryTest {

    @Autowired
    DataInitializer initializer;

    final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @BeforeEach
    void setUp() {
        initializer.saveSampleData();
    }

    /**
     * Retrieve customers  that were born before today and combine this with phone & email use the following sample data
     *  phone :5555
     *  email: od@gmail.com
     *  Then log it
     * hint: combine specifications under a utility class
     */
    @Test
    void shouldExecuteSpecification() {

    }
}
