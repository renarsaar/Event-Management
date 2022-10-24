package com.example.EventManagement.participant.person;

import com.example.EventManagement.participant.Participant;

/**
 * Person Entity.
 */
public interface Person extends Participant {
    // PersonId personId();

    FirstName firstName();

    LastName lastName();

    PersonalCode PersonalCode();

    // PaymentType paymentType();

    // Description description();
}
