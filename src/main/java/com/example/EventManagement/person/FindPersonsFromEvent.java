package com.example.EventManagement.person;

import com.example.EventManagement.event.EventId;

/**
 * Find Persons from Event use-case.
 */
public interface FindPersonsFromEvent {
    /**
     * Finds a list of persons by event ID.
     *
     * @param eventId the event ID
     * @return a stream of persons
     */
    Persons byEventId(EventId eventId);
}
