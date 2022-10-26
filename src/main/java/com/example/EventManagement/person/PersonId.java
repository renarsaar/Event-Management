package com.example.EventManagement.person;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * Person ID domain primitive.
 */
@EqualsAndHashCode
@ToString
public final class PersonId {
    private final @NonNull String id;

    public PersonId(@NonNull Object id) {
        var idVal = id.toString().strip();

        if (idVal.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty!");
        }

        this.id = idVal;
    }

    public String value() {
        return id;
    }
}
