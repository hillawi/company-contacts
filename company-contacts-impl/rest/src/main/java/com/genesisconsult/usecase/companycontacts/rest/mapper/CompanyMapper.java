package com.genesisconsult.usecase.companycontacts.rest.mapper;

import com.genesisconsult.usecase.companycontacts.core.domain.Company;
import com.genesisconsult.usecase.companycontacts.rest.representations.CompanyUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = AddressMapper.class)
public interface CompanyMapper {
    com.genesisconsult.usecase.companycontacts.rest.representations.Company map(Company company);

    @Mapping(target = "id", ignore = true)
    Company map(com.genesisconsult.usecase.companycontacts.rest.representations.Company company);

    void update(CompanyUpdate companyUpdate, @MappingTarget Company company);
}
