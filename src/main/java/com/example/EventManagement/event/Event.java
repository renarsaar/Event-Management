package com.example.EventManagement.event;

import com.example.EventManagement.common.primitives.Description;

/**
 * Event entity
 */
public interface Event {
    EventId id();

    Name name();

    EventTime eventTime();

    EventLocation eventLocation();

    Description description();

    void createEvent();
}
