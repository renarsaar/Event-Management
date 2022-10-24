package com.example.EventManagement.event;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * Event ID domain primitive.
 */
@EqualsAndHashCode
@ToString
public final class EventId {
    private final @NonNull String id;

    public EventId(@NonNull Object id) {
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
