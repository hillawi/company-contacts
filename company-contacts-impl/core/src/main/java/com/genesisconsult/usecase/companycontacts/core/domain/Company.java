package com.genesisconsult.usecase.companycontacts.core.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {
    @Id
    @GeneratedValue(generator = "COMPANY_SEQ_GENERATOR")
    @SequenceGenerator(name = "COMPANY_SEQ_GENERATOR", sequenceName = "COMPANY_SEQ", initialValue = 100)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String vatNumber;
    @OneToOne
    private Address address;
}