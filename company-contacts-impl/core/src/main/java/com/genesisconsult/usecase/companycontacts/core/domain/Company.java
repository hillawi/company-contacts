package com.genesisconsult.usecase.companycontacts.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {
    @Id
    @GeneratedValue(generator = "COMPANY_SEQ_GENERATOR")
    @SequenceGenerator(name = "COMPANY_SEQ_GENERATOR", sequenceName = "COMPANY_SEQ", initialValue = 100)
    private Long id;
    private String name;
    private String vatNumber;
    @OneToOne
    private Address address;
}