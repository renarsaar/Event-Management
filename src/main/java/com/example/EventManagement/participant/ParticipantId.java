package com.example.EventManagement.participant;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class ParticipantId {
    private final @NonNull String id;

    public ParticipantId(@NonNull Object id) {
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
