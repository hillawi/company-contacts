package com.genesisconsult.usecase.companycontacts.core.service.impl;

import com.genesisconsult.usecase.companycontacts.core.domain.Contact;
import com.genesisconsult.usecase.companycontacts.core.exception.EntityNotFoundException;
import com.genesisconsult.usecase.companycontacts.core.repo.ContactRepository;
import com.genesisconsult.usecase.companycontacts.core.service.ContactService;
import lombok.RequiredArgsConstructor;
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
        // TODO find contact by vatNumber and throw an exception if found
        return contactRepository.save(contact.validate());
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact.validate());
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.delete(findById(id));
    }
}
