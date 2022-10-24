package com.example.EventManagement.participant.person;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * Participant Last Name domain primitive.
 */
@EqualsAndHashCode
@ToString
public final class LastName {
    private final @NonNull String lastName;

    public LastName(@NonNull String lastName) {
        var lastNameVar = lastName.strip();

        if (lastNameVar.isBlank()) {
            throw new IllegalArgumentException("Last Name cannot be empty!");
        }

        this.lastName = lastNameVar;
    }

    public String value() {
        return lastName;
    }
}
