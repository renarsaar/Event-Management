package com.example.EventManagement.event;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Event Time & Date domain primitive.
 */
@EqualsAndHashCode
@ToString
public class EventTime {
    private final @NonNull String startDateTime;

    public EventTime(String startDateTime) {
/*        if (startDateTime == null) {
            throw new IllegalArgumentException("Start Date and Time cannot be empty");
        }

        if (startDateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Start Date and Time cannot be in past");
        }*/

        this.startDateTime = startDateTime;
    }

    public String value() {
        return startDateTime;
    }
}
