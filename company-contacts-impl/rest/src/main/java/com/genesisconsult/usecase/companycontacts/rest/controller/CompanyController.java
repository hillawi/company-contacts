package com.genesisconsult.usecase.companycontacts.rest.controller;

import com.genesisconsult.usecase.companycontacts.core.service.CompanyService;
import com.genesisconsult.usecase.companycontacts.rest.api.CompanyServiceApi;
import com.genesisconsult.usecase.companycontacts.rest.mapper.CompanyMapper;
import com.genesisconsult.usecase.companycontacts.rest.mapper.ContactMapper;
import com.genesisconsult.usecase.companycontacts.rest.representations.Company;
import com.genesisconsult.usecase.companycontacts.rest.representations.CompanyUpdate;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Validated
@RestController
@RequiredArgsConstructor
public class CompanyController implements CompanyServiceApi {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;
    private final ContactMapper contactMapper;
    private final ServletContext servletContext;

    @Override
    public ResponseEntity<Void> addCompany(@Valid Company company) {
        var savedCompany = companyService.save(companyMapper.map(company));
        var uri = servletContext.getContextPath() + "/companies/" + savedCompany.getId();
        return ResponseEntity.created(URI.create(uri)).build();
    }

    @Override
    public ResponseEntity<Void> addContactToCompany(Long companyId, @NotNull @Valid Long contactId) {
        companyService.addContact(companyId, contactId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Company> findCompanyById(Long id) {
        return ResponseEntity.ok(companyMapper.map(companyService.findById(id)));
    }

    @Override
    public ResponseEntity<Page> findCompanyContactsById(Long id, @Valid Pageable pageable) {
        return ResponseEntity.ok(companyService.findAllContacts(id, pageable).map(contactMapper::map));
    }

    @Override
    public ResponseEntity<Page> searchCompanies(@Valid String vatNumber, @Valid Pageable pageable) {
        return ResponseEntity.ok(companyService.search(vatNumber, pageable).map(companyMapper::map));
    }

    @Override
    public ResponseEntity<Company> updateCompany(Long id, @Valid CompanyUpdate companyUpdate) {
        var company = companyService.findById(id);
        companyMapper.update(companyUpdate, company);
        var updatedCompany = companyService.update(company);
        return ResponseEntity.ok(companyMapper.map(updatedCompany));
    }
}