package com.example.EventManagement.event;

/**
 * Delete Event use-case.
 */
public interface DeleteEvent {
    /**
     * Delete Event.
     *
     * @param eventId event id
     */
    void deleteEvent(EventId eventId);
}
