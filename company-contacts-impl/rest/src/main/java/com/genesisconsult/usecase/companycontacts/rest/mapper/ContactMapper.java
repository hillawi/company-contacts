package com.genesisconsult.usecase.companycontacts.rest.mapper;

import com.genesisconsult.usecase.companycontacts.rest.representations.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ContactMapper {
    Contact map(com.genesisconsult.usecase.companycontacts.core.domain.Contact contact);
}