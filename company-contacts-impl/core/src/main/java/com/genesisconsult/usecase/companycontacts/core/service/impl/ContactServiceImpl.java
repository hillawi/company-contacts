package com.genesisconsult.usecase.companycontacts.core.service.impl;

import com.genesisconsult.usecase.companycontacts.core.domain.Contact;
import com.genesisconsult.usecase.companycontacts.core.exception.EntityNotFoundException;
import com.genesisconsult.usecase.companycontacts.core.repo.ContactRepository;
import com.genesisconsult.usecase.companycontacts.core.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
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
}
