package com.genesisconsult.usecase.companycontacts.rest.mapper;

import com.genesisconsult.usecase.companycontacts.core.domain.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = AddressMapper.class)
public interface CompanyMapper {
    com.genesisconsult.usecase.companycontacts.rest.representations.Company map(Company company);

    @Mapping(target = "id", ignore = true)
    Company map(com.genesisconsult.usecase.companycontacts.rest.representations.Company company);
}
