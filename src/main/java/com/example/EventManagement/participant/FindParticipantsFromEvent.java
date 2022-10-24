package com.example.EventManagement.participant;

import com.example.EventManagement.event.EventId;

/**
 * Find Participants from Event use-case.
 */
public interface FindParticipantsFromEvent {
    /**
     * Finds a list of participants by event ID.
     *
     * @param eventId the event ID
     * @return a stream of participants
     */
    Participants byEventId(EventId eventId);
}
