package com.genesisconsult.usecase.companycontacts.rest.mapper;

import com.genesisconsult.usecase.companycontacts.core.domain.Address;
import com.genesisconsult.usecase.companycontacts.rest.representations.AddressUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {
    com.genesisconsult.usecase.companycontacts.rest.representations.Address map(Address address);

    void update(AddressUpdate addressUpdate, @MappingTarget Address address);
}