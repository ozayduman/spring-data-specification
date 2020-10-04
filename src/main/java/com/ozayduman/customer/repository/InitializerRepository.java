package com.ozayduman.customer.repository;

import com.ozayduman.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InitializerRepository extends PagingAndSortingRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

}
