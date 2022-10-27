package com.example.EventManagement.company;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.event.EventId;

/**
 * Create Company use-case.
 */
public interface CreateCompany {
    /**
     * Create a new company.
     *
     * @param id participant id
     * @param eventId event id
     * @param legalName company legal name
     * @param registryCode company registry code
     * @param numberOfPartakers amount of participants
     * @param paymentType person payment type
     * @param description event description
     */
    void createCompany(ParticipantId id, EventId eventId, LegalName legalName, RegistryCode registryCode, NumberOfPartakers numberOfPartakers, PaymentType paymentType, Description description);
}
