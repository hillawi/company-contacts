package com.genesisconsult.usecase.companycontacts.core.repo;

import com.genesisconsult.usecase.companycontacts.core.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
