package com.genesisconsult.usecase.companycontacts.core.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
    @NotBlank(message = "The company name is required")
    private String name;
    @NotBlank(message = "The company VAT number is required")
    private String vatNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "The company address is required")
    private Address address;
    @ManyToMany
    @JoinTable(
            name = "COMPANY_CONTACT",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private Set<Contact> contacts = new HashSet<>();
}