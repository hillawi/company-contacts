package com.genesisconsult.usecase.companycontacts.core.service;

import com.genesisconsult.usecase.companycontacts.core.domain.Company;
import com.genesisconsult.usecase.companycontacts.core.domain.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    Company findById(Long id);

    Page<Company> search(String vatNumber, Pageable pageable);

    Company save(Company company);

    Company update(Company company);

    void addContact(Long companyId, Long contactId);

    Page<Contact> findAllContacts(Long id, Pageable pageable);
}
