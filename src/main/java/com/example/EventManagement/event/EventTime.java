package com.example.EventManagement.event;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * Event Time & Date domain primitive.
 */
@EqualsAndHashCode
@ToString
public class EventTime {
    private final @NonNull String startDateTime;

    public EventTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String value() {
        return startDateTime;
    }
}
