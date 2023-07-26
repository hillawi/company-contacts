package com.genesisconsult.usecase.companycontacts.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
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
public class Address implements Serializable {
    @Id
    @GeneratedValue(generator = "ADDRESS_SEQ_GENERATOR")
    @SequenceGenerator(name = "ADDRESS_SEQ_GENERATOR", sequenceName = "ADDRESS_SEQ", initialValue = 100)
    private Long id;
    @NotBlank(message = "The address city is required")
    private String city;
    @NotBlank(message = "The address municipality is required")
    private String municipality;
    @NotBlank(message = "The address street name is required")
    private String streetName;
    @NotBlank(message = "The address street number is required")
    private String streetNumber;
}
