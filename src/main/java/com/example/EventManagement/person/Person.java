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

    // Todo: Different methods to complete

    // void changeFirstName(FirstName firstName);

    // void changeLastName(LastName lastName);

    // void changePersonalCode(PersonalCode personalCode);

    // void changePaymentType(PaymentType paymentType);

    // void changeDescription(Description description);
}
