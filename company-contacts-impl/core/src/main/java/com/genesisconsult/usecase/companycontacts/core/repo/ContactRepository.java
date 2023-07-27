package com.genesisconsult.usecase.companycontacts.core.repo;

import com.genesisconsult.usecase.companycontacts.core.domain.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Page<Contact> findContactsByCompanies_Id(Long companyId, Pageable pageable);

    long countContactByVatNumberEqualsIgnoreCase(String vatNumber);
}
