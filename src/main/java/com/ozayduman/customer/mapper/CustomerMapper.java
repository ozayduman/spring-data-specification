package com.ozayduman.customer.mapper;

import com.ozayduman.customer.entity.Customer;
import com.ozayduman.customer.entity.dto.CustomerDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
            @Mapping(target = "name" ,source = "name"),
            @Mapping(target = "lastName", source = "surname"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "birthDate", source = "birthDate")
    })
    CustomerDTO toDTO(Customer customer);

    @InheritInverseConfiguration
    Customer toEntity(CustomerDTO dto);
}

