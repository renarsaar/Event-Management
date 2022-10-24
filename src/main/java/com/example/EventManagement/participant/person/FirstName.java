package com.example.EventManagement.participant.person;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * Participant First Name domain primitive.
 */
@EqualsAndHashCode
@ToString
public final class FirstName {
    private final @NonNull String firstName;

    public FirstName(@NonNull String firstName) {
        var firstNameVar = firstName.strip();

        if (firstNameVar.isBlank()) {
            throw new IllegalArgumentException("First Name cannot be empty!");
        }

        this.firstName = firstName;
    }

    public String value() {
        return firstName;
    }
}
