package com.genesisconsult.usecase.companycontacts.core.service;

import com.genesisconsult.usecase.companycontacts.core.domain.Company;
import com.genesisconsult.usecase.companycontacts.core.domain.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {
    Contact findById(Long id);

    Page<Contact> findAll(Pageable pageable);

    Contact save(Contact contact);

    Contact update(Contact contact);

    void deleteById(Long id);

    Page<Contact> findContactsByCompany(Company company, Pageable pageable);
}
