package com.genesisconsult.usecase.companycontacts.core.domain;

import com.genesisconsult.usecase.companycontacts.core.exception.InvalidEntityException;
import jakarta.persistence.*;
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
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private ContactType contactType;
    private String vatNumber;
    @ManyToOne
    private Address address;

    public void validate() {
        if (ContactType.FREELANCE.equals(contactType) && StringUtils.isBlank(vatNumber)) {
            throw new InvalidEntityException(String.format("Contacts of type %s should have a VAT number",
                    ContactType.FREELANCE));
        }
    }
}
