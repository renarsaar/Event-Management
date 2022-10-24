package com.example.EventManagement.event;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * Event Location domain primitive.
 */
@EqualsAndHashCode
@ToString
public final class EventLocation {
    private final @NonNull String location;

    public EventLocation(String location) {
        var locationVar = location.strip();

        if (locationVar.isBlank()) {
            throw new IllegalArgumentException("Location cannot be empty!");
        }

        this.location = locationVar;
    }

    public String value() {
        return location;
    }
}
