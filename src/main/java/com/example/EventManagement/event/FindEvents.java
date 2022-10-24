package com.example.EventManagement.event;

/**
 * Find Events use-case.
 */
public interface FindEvents {
    /**
     * List all events
     *ˇ
     * @return all events
     */
    Events all();

    /**
     * Finds an event by the event ID.
     *
     * @param id the company ID
     * @return the event
     */
    Event byId(EventId id);
}
