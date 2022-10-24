package com.example.EventManagement.common.primitives;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * Event / Participant Description domain primitive.
 */
@EqualsAndHashCode
@ToString
public class Description {
    private final @NonNull String description;
    private final @NonNull Integer allowedLength;

    public Description(@NonNull String description, @NonNull Integer allowedLength) {
        var descriptionVar = description.strip();

        if (descriptionVar.isBlank()) {
            throw new IllegalArgumentException("Description cannot be empty!");
        }

        if (descriptionVar.length() > allowedLength) {
            throw new IllegalArgumentException("Description cannot exceed 1000 characters!");
        }

        this.description = descriptionVar;
        this.allowedLength = allowedLength;
    }

    public String value() {
        return description;
    }
}
