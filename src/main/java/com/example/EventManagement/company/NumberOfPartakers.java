package com.example.EventManagement.company;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Company Number of Partakers domain primitive.
 */
@EqualsAndHashCode
public final class NumberOfPartakers {
    private final @NonNull Integer numberOfPartakers;

    public NumberOfPartakers(Integer numberOfPartakers) {
        if (numberOfPartakers < 0) {
            throw new IllegalArgumentException("Invalid amount of partakers");
        }

        this.numberOfPartakers = numberOfPartakers;
    }

    public int value() {
        return numberOfPartakers;
    }
}
