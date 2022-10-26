package com.example.EventManagement.event;

import com.example.EventManagement.common.primitives.Description;

/**
 * Create Order use-case.
 */
public interface CreateEvent {
    /**
     * Create a new event.
     *
     * @param id event id
     * @param name event name
     * @param time event time
     * @param location event location
     * @param description event description
     */
    void createEvent(EventId id, Name name, EventTime time, EventLocation location, Description description);
}
