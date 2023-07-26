package com.genesisconsult.usecase.companycontacts.rest.controller;

import com.genesisconsult.usecase.companycontacts.core.service.ContactService;
import com.genesisconsult.usecase.companycontacts.rest.api.ContactServiceApi;
import com.genesisconsult.usecase.companycontacts.rest.mapper.ContactMapper;
import com.genesisconsult.usecase.companycontacts.rest.representations.Contact;
import com.genesisconsult.usecase.companycontacts.rest.representations.ContactUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
public class ContactController implements ContactServiceApi {
    private final ContactService contactService;
    private final ContactMapper contactMapper;

    @Override
    public ResponseEntity<Void> addContact(@Valid Contact contact) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteContact(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Page> findAllContacts(@Valid Pageable pageable) {
        return ResponseEntity.ok(contactService.findAll(pageable));
    }

    @Override
    public ResponseEntity<Contact> findContactById(Long id) {
        return ResponseEntity.ok(contactMapper.map(contactService.findById(id)));
    }

    @Override
    public ResponseEntity<Contact> updateContact(Long id, @Valid ContactUpdate contactUpdate) {
        var contact = contactService.findById(id);
        contactMapper.update(contactUpdate, contact);
        var updatedContact = contactService.update(contact);
        return ResponseEntity.ok(contactMapper.map(updatedContact));
    }
}
