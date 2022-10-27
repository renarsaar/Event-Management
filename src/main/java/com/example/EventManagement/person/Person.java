package com.example.EventManagement.person;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.event.EventId;
import com.example.EventManagement.common.primitives.ParticipantId;

/**
 * Person Entity.
 */
public interface Person {
    ParticipantId participantId();

    EventId eventId();

    FirstName firstName();

    LastName lastName();

    PersonalCode personalCode();

    PaymentType paymentType();

    Description description();

    void createPerson();

    void deletePerson(ParticipantId id);

    void editPerson(ParticipantId id, FirstName firstName, LastName lastName, PersonalCode personalCode, PaymentType paymentType, Description description);
}
