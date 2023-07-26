package com.genesisconsult.usecase.companycontacts.core.domain;

import com.genesisconsult.usecase.companycontacts.core.exception.InvalidEntityException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact implements Serializable {
    @Id
    @GeneratedValue(generator = "CONTACT_SEQ_GENERATOR")
    @SequenceGenerator(name = "CONTACT_SEQ_GENERATOR", sequenceName = "CONTACT_SEQ", initialValue = 100)
    @Setter(AccessLevel.NONE)
    private Long id;
    @NotBlank(message = "The contact first name is required")
    private String firstName;
    @NotBlank(message = "The contact last name is required")
    private String lastName;
    @NotNull(message = "The contact type is required")
    private ContactType contactType;
    private String vatNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "The contact address is required")
    private Address address;

    public Contact validate() {
        if (ContactType.FREELANCE.equals(contactType) && StringUtils.isBlank(vatNumber)) {
            throw new InvalidEntityException(String.format("Contacts of type %s should have a VAT number",
                    ContactType.FREELANCE));
        }
        return this;
    }
}
