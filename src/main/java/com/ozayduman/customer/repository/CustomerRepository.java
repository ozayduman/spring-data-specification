package com.ozayduman.customer.repository;

import com.ozayduman.customer.entity.Customer;
import com.ozayduman.customer.entity.PhoneType;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
    List<Customer> findCustomersByPhonesNumber(String number);
    List<Customer> findCustomersByPhonesPhoneType(PhoneType type);
}
