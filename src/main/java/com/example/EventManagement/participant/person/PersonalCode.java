package com.example.EventManagement.participant.person;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.util.regex.Pattern;

/**
 * Participant Personal Code domain primitive.
 */
@EqualsAndHashCode
@ToString
public final class PersonalCode {
    private static final String PATTERN = "" +
            "^" +
            "([1-6])" + // Gender / Year
            "([0-9]|[1-9][0-9])" + // Year
            "(0[1-9]|1[0-2])" + // Month
            "(0[1-9]|[12][0-9]|3[01])" + // Day
            "([0-9][0-9][0-9])" + // Queue number
            "([0-9])" + // Control number
            "$";

    private final String personalCode;

    public PersonalCode(@NonNull String personalCode) {
        var personalCodeVar = personalCode.strip();

        if (personalCodeVar.isBlank()) {
            throw new IllegalArgumentException("Personal code cannot be empty!");
        }

        if (!Pattern.matches(PATTERN, personalCodeVar)) {
            throw new IllegalArgumentException("Invalid Personal code!");
        }

        this.personalCode = personalCodeVar;
    }
}
