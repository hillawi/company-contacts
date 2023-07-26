package com.genesisconsult.usecase.companycontacts.rest.mapper;

import com.genesisconsult.usecase.companycontacts.core.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {
    com.genesisconsult.usecase.companycontacts.rest.representations.Address map(Address address);
}