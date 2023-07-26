package com.genesisconsult.usecase.companycontacts.rest.mapper;

import com.genesisconsult.usecase.companycontacts.core.domain.Contact;
import com.genesisconsult.usecase.companycontacts.rest.representations.ContactUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = AddressMapper.class)
public interface ContactMapper {
    com.genesisconsult.usecase.companycontacts.rest.representations.Contact map(Contact contact);

    @Mapping(target = "address", ignore = true)
    void update(ContactUpdate contactUpdate, @MappingTarget Contact contact);
}