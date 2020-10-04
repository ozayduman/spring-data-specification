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
class CustomerSpecificationBuilderTest {

    @Autowired
    DataInitializer initializer;

    final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @BeforeEach
    void setUp() {
        initializer.saveSampleData();
    }


    /**
     * Customers can be retrieved by name, surname, and birddate
     *  birdDate between  :1990, Month.JANUARY,1   - NOW
     */
    @Test
    void shouldExecuteSpeficationBuilderWithCriteriaDTO() {

    }

    /**
     * Customers can be retrieved by name, surname, and birddate
     *  birdDate between  :1990, Month.JANUARY,1   - NOW
     *  page: 0
     *  page size:10
     *  sort: name, surname
     */
    @Test
    void shouldExecuteSpeficationBuilderWithPageRequestDTO() {

    }

    /**
     * Return the previous test with PageResultDTO
     */
    @Test
    void shouldReturnResultsWithPageResultDTO() {

    }


    /**
     * Return the previous test with PageResultDTO by using MapStruct library
     */
    @Test
    void shouldReturnResultsWithPageResultDTOMapStruct() {

    }
}
