package com.ozayduman.customer.repository;

import com.ozayduman.customer.entity.Customer;
import com.ozayduman.customer.entity.PhoneType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = {"com.ozayduman.customer"})
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DataInitializer initializer;

    final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @BeforeEach
    void setUp() {
       initializer.saveSampleData();
    }

    /**
     * Save a customer with given
     *  name: ozay
     *  surname: duman
     *  email: ozay.duman@gmail.com
     *  Then retrieve customer by email & log it
     */
    @Test
    void shouldFindCustomer(){
        final var customer = new Customer();
        customer.setName("ozay");
        customer.setSurname("duman");
        customer.setEmail("ozay.duman@gmail.com");
        customerRepository.save(customer);

        final Optional<Customer> customerFromDB = customerRepository.findByEmail("ozay.duman@gmail.com");
        assertTrue(customerFromDB.isPresent());
    }

    /**
     * Retrieve customers with given
     *  phoneNumver: 5555
     *  Then log it
     */
    @Test
    void shouldFindCustomersByPhoneNumber(){
        final var customersByPhonesNumber = customerRepository.findCustomersByPhonesNumber("5555");
        assertFalse(customersByPhonesNumber.isEmpty());
    }

    /**
     * Retrieve customers with any PhoneType
     *  sample phone type: business
     *  Then log it
     */
    @Test
    void shouldFindCustomersByPhoneType(){
        final var customersByPhonesPhoneType = customerRepository.findCustomersByPhonesPhoneType(PhoneType.BUSINESS);
        assertTrue(!customersByPhonesPhoneType.isEmpty());
    }

    /**
     * Retrieve customers via a manual query with given
     *  phoneNumber: 5555
     *  Then log it
     */

    @Test
    void shouldFindCustomersByPhoneNumberViaManuelQuery() {

    }

    /**
     * * PROJECTION **
     */

    /**
     * Retrieve customers' only name and surnames for given values
     *  email: od@gmail.com
     *  Then log it
     * hint: use view package
     */
    @Test
    void shouldFindByEmailReturnOnlyNames() {

    }

    /**
     * Retrieve customer's  name, surname and email and also names at the same time for given values
     *  email: od@gmail.com
     *  Then log it
     * hint: use view package
     */

    @Test
    void shouldFindByEmailnWithDifferentViews() {

    }
}
