package com.example.EventManagement.person;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.event.EventId;

/**
 * Create Person use-case.
 */
public interface CreatePerson {
    /**
     * Create a new person.
     *
     * @param id participant id
     * @param eventId event id
     * @param firstName person first name
     * @param lastName person last name
     * @param personalCode person personal code
     * @param paymentType person payment type
     * @param description event description
     */
    void createPerson(ParticipantId id, EventId eventId, FirstName firstName, LastName lastName, PersonalCode personalCode, PaymentType paymentType, Description description);
}
