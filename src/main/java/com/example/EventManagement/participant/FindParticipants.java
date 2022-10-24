package com.example.EventManagement.participant;

/**
 * Find Event Participants use-case.
 */
public interface FindParticipants {
    /**
     * Finds a product by ID.
     *
     * @param id the product ID
     * @return the found product
     */
    Participant byId(Participant id);
}
