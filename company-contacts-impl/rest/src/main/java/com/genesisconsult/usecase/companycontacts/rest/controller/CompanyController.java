package com.genesisconsult.usecase.companycontacts.rest.controller;

import com.genesisconsult.usecase.companycontacts.core.service.CompanyService;
import com.genesisconsult.usecase.companycontacts.rest.api.CompanyServiceApi;
import com.genesisconsult.usecase.companycontacts.rest.mapper.CompanyMapper;
import com.genesisconsult.usecase.companycontacts.rest.representations.Company;
import com.genesisconsult.usecase.companycontacts.rest.representations.CompanyPage;
import com.genesisconsult.usecase.companycontacts.rest.representations.CompanyUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
public class CompanyController implements CompanyServiceApi {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @Override
    public ResponseEntity<Void> addCompany(@Valid Company company) {
        return null;
    }

    @Override
    public ResponseEntity<Void> addContactToCompany(Long companyId, @NotNull @Valid Long contactId) {
        companyService.addContact(companyId, contactId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CompanyPage> searchCompanies(@Valid String s, @Valid Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<Company> updateCompany(Long id, @Valid CompanyUpdate companyUpdate) {
        return null;
    }
}