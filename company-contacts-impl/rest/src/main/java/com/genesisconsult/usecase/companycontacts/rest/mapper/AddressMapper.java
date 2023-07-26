package com.genesisconsult.usecase.companycontacts.rest.mapper;

import com.genesisconsult.usecase.companycontacts.rest.representations.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address map(com.genesisconsult.usecase.companycontacts.core.domain.Address address);
}