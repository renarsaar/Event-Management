package com.example.EventManagement.event;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * Event Name domain primitive.
 */
@EqualsAndHashCode
@ToString
public class Name {
    private final @NonNull String name;

    public Name(@NonNull String name) {
        var nameVar = name.strip();

        if (nameVar.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }

        this.name = nameVar;
    }

    public String value() {
        return name;
    }
}
