package com.example.EventManagement.company;

import com.example.EventManagement.common.primitives.ParticipantId;

/**
 * Find Companies use-case.
 */
public interface FindCompanies {
    /**
     * Finds a company by the company ID.
     *
     * @param id the company ID
     * @return the company
     */
    Company byId(ParticipantId id);
}
