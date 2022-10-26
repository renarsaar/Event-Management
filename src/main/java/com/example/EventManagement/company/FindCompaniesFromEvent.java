package com.example.EventManagement.company;

import com.example.EventManagement.event.EventId;

/**
 * Find Companies from Event use-case.
 */
public interface FindCompaniesFromEvent {
    /**
     * Finds a list of companies by event ID.
     *
     * @param eventId the event ID
     * @return a stream of companies
     */
    Companies byEventId(EventId eventId);
}
