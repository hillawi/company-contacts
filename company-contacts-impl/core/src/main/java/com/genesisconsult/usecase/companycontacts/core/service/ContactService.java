package com.genesisconsult.usecase.companycontacts.core.service;

import com.genesisconsult.usecase.companycontacts.core.domain.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {
    Contact findById(Long id);

    Page<Contact> findAll(Pageable pageable);
}
