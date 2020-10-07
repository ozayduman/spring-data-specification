package com.ozayduman.customer.repository;

import com.ozayduman.customer.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.Optional;

import static com.ozayduman.customer.entity.CustomerSpecifications.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = {"com.ozayduman.customer"})
class CustomerSpecificationRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DataInitializer initializer;

    final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);

   /* @BeforeEach
    void setUp() {
        initializer.saveSampleData();
    }
  */

    /**
     * Retrieve customers  that were born before today and combine this with phone & email use the following sample data
     * phone :5555
     * email: od@gmail.com
     * Then log it
     * hint: combine specifications under a utility class
     */
    @Test
    void shouldExecuteSpecification() {
        final Optional<Customer> customer = customerRepository.findOne(notBornToday()
                .and(byEmail("od@gmail.com"))
                .and(byPhoneNumber("5555"))
        );

        Assertions.assertTrue(customer.isPresent());
    }

    @Test
    void shouldExecuteSpecificationWithWhenClause() {
        final Optional<Customer> customer = customerRepository.findOne(Specification.where(notBornToday()
                .and(byEmail("od@gmail.com"))
                .and(byPhoneNumber("5555"))
        ));

        Assertions.assertTrue(customer.isPresent());
    }
}
