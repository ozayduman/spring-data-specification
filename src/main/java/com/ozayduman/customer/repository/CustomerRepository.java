package com.ozayduman.customer.repository;

import com.ozayduman.customer.entity.Customer;
import com.ozayduman.customer.entity.PhoneType;
import com.ozayduman.customer.entity.view.NamesOnly;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    Optional<Customer> findByEmail(String email);
    List<Customer> findCustomersByPhonesNumber(String number);
    List<Customer> findCustomersByPhonesPhoneType(PhoneType type);

    @Query("select c from Customer c left join fetch c.phones p where p.number = ?1")
    List<Customer> findCustomersByManuelQueryByPhoneNumber(String number);
    Optional<NamesOnly> findCustomerByEmail(String email);
    <T> T queryByEmail(String email, Class<T> type);

}
