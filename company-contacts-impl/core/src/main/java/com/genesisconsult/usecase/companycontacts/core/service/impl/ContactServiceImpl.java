package com.genesisconsult.usecase.companycontacts.core.service.impl;

import com.genesisconsult.usecase.companycontacts.core.domain.Company;
import com.genesisconsult.usecase.companycontacts.core.domain.Contact;
import com.genesisconsult.usecase.companycontacts.core.exception.EntityNotFoundException;
import com.genesisconsult.usecase.companycontacts.core.exception.InvalidEntityException;
import com.genesisconsult.usecase.companycontacts.core.repo.ContactRepository;
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
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Contact with ID %d not found", id)));
    }

    @Override
    public Page<Contact> findAll(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }

    @Override
    public Contact save(Contact contact) {
        var vatNumber = contact.getVatNumber();
        if (StringUtils.isNotBlank(vatNumber) &&
                contactRepository.countContactByVatNumberEqualsIgnoreCase(vatNumber) > 0) {
            throw new InvalidEntityException(
                    String.format("VAT number (%s) is already defined for another contact", vatNumber));
        }
        return contactRepository.save(contact.validate());
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact.validate());
    }

    @Override
    public void deleteById(Long id) {
        var contact = findById(id);
        contact.getCompanies().forEach(c -> c.getContacts().remove(contact));
        contactRepository.delete(contact);
    }

    @Override
    public Page<Contact> findContactsByCompany(Company company, Pageable pageable) {
        return contactRepository.findContactsByCompanies_Id(company.getId(), pageable);
    }
}
