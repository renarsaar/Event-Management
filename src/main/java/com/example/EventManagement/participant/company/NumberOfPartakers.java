package com.example.EventManagement.participant.company;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Company number of partakers domain primitive.
 */
@EqualsAndHashCode
// @ToString
public final class NumberOfPartakers {
    private final @NonNull int numberOfPartakers;

    public NumberOfPartakers(int numberOfPartakers) {
        if (numberOfPartakers < 0) {
            throw new IllegalArgumentException("Invalid amount of partakers");
        }

        this.numberOfPartakers = numberOfPartakers;
    }

    public int value() {
        return numberOfPartakers;
    }
}
