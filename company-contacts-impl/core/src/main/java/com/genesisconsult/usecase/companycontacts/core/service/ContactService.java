package com.genesisconsult.usecase.companycontacts.core.service;

import com.genesisconsult.usecase.companycontacts.core.domain.Contact;

public interface ContactService {
    Contact findById(Long id);
}
