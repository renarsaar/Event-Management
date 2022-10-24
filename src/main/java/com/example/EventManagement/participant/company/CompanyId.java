package com.example.EventManagement.participant.company;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * Company ID domain primitive.
 */
@EqualsAndHashCode
@ToString
public final class CompanyId {
    private final @NonNull String id;

    public CompanyId(@NonNull Object id) {
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
