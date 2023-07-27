package com.genesisconsult.usecase.companycontacts.core.repo;

import com.genesisconsult.usecase.companycontacts.core.domain.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Page<Company> findCompaniesByVatNumberContainsIgnoreCase(String vatNumber, Pageable pageable);

    List<Company> findCompanyByVatNumberEqualsIgnoreCase(String vatNumber);
}