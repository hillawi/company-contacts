package com.genesisconsult.usecase.companycontacts.core.service.impl;

import com.genesisconsult.usecase.companycontacts.core.domain.Company;
import com.genesisconsult.usecase.companycontacts.core.domain.Contact;
import com.genesisconsult.usecase.companycontacts.core.exception.EntityAlreadyExistsException;
import com.genesisconsult.usecase.companycontacts.core.exception.EntityNotFoundException;
import com.genesisconsult.usecase.companycontacts.core.repo.CompanyRepository;
import com.genesisconsult.usecase.companycontacts.core.service.CompanyService;
import com.genesisconsult.usecase.companycontacts.core.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final ContactService contactService;

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Company with ID %d not found", id)));
    }

    @Override
    public Page<Company> search(String vatNumber, Pageable pageable) {
        if (StringUtils.isBlank(vatNumber)) {
            return companyRepository.findAll(pageable);
        }
        return companyRepository.findCompaniesByVatNumberContainsIgnoreCase(vatNumber, pageable);
    }

    @Override
    public Company save(Company company) {
        // TODO search for a company with the same VAT number, throw an exception if found
        return companyRepository.save(company);
    }

    @Override
    public Company update(Company company) {
        // TODO avoid same name? vatNumber?
        return companyRepository.save(company);
    }

    @Override
    public void addContact(Long companyId, Long contactId) {
        var company = findById(companyId);
        var contact = contactService.findById(contactId);

        if (company.getContacts().stream().anyMatch(c -> c.getId().equals(contact.getId()))) {
            throw new EntityAlreadyExistsException(
                    String.format("Contact with ID %d has already been added to Company with ID %d",
                            contactId, companyId));
        }

        company.getContacts().add(contact);
        companyRepository.save(company);
    }

    @Override
    public Page<Contact> findAllContacts(Long id, Pageable pageable) {
        return contactService.findContactsByCompany(findById(id), pageable);
    }
}
