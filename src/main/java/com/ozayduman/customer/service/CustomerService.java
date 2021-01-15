package com.ozayduman.customer.service;

import com.github.ozayduman.specificationbuilder.SpecificationMappings.SpecificationBuilder;
import com.github.ozayduman.specificationbuilder.dto.PageRequestDTO;
import com.ozayduman.customer.entity.Customer;
import com.ozayduman.customer.entity.Customer_;
import com.ozayduman.customer.entity.Phone_;
import com.ozayduman.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Page<Customer> query(PageRequestDTO pageRequestDTO) {
        final Specification<Customer> specification = createSpecification(pageRequestDTO);
        final PageRequest pageRequest = createPageRequest(pageRequestDTO);
        return customerRepository.findAll(specification, pageRequest);
    }

    private Specification<Customer> createSpecification(PageRequestDTO pageRequestDTO) {
        return SpecificationBuilder.<Customer>of(pageRequestDTO)
                .bind("name", Customer_.name)
                .bind("lastName", Customer_.surname)
                .bind("email", Customer_.email)
                .bindJoin("phoneNumber", Customer_.phones, Phone_.number)
                .build();
    }

    private PageRequest createPageRequest(PageRequestDTO pageRequestDTO) {
        return PageRequestDTO.PageRequestBuilder.of(pageRequestDTO)
                .bindSort("name", Customer_.name)
                .bindSort("lastName", Customer_.surname)
                .bindSort("email", Customer_.email)
                .build();
    }
}
