package com.genesisconsult.usecase.companycontacts.core.service;

import com.genesisconsult.usecase.companycontacts.core.domain.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    Company findById(Long id);

    Page<Company> findAll(Pageable pageable);

    Company save(Company company);

    Company update(Company company);

    void deleteById(Long id);

    void addContact(Long companyId, Long contactId);
}
