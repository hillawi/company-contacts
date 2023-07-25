package com.genesisconsult.usecase.companycontacts.core.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.apache.commons.lang3.StringUtils;

@Converter(autoApply = true)
public class ContactTypeConverter implements AttributeConverter<ContactType, String> {
    @Override
    public String convertToDatabaseColumn(ContactType contactType) {
        if (contactType == null) {
            return null;
        }
        return contactType.name();
    }

    @Override
    public ContactType convertToEntityAttribute(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return ContactType.valueOf(value.toUpperCase());
    }
}