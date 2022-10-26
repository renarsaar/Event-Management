package com.example.EventManagement.company;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * Company Legal Name domain primitive.
 */
@EqualsAndHashCode
@ToString
public class LegalName {
    private final @NonNull String legalName;

    public LegalName(@NonNull String firstName) {
        var firstNameVar = firstName.strip();

        if (firstNameVar.isBlank()) {
            throw new IllegalArgumentException("Legal Name cannot be empty!");
        }

        this.legalName = firstName;
    }

    public String value() {
        return legalName;
    }
}
