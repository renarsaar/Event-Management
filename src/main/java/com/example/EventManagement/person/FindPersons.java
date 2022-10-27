package com.example.EventManagement.person;

import com.example.EventManagement.common.primitives.ParticipantId;

/**
 * Find persons use-case.
 */
public interface FindPersons {
    /**
     * Finds a person by the person ID.
     *
     * @param id the person ID
     * @return the person
     */
    Person byId(ParticipantId id);
}
