package com.example.EventManagement.person.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.event.EventId;
import com.example.EventManagement.person.FirstName;
import com.example.EventManagement.person.LastName;
import com.example.EventManagement.person.Person;
import com.example.EventManagement.person.PersonalCode;

public class UnknownPerson implements Person {
    @Override
    public ParticipantId participantId() {
        return new ParticipantId(0);
    }

    @Override
    public EventId eventId() {
        return new EventId(0);
    }

    @Override
    public FirstName firstName() {
        return new FirstName("Person not found");
    }

    @Override
    public LastName lastName() {
        return new LastName("Person not found");
    }

    @Override
    public PersonalCode personalCode() {
        return new PersonalCode("Person not found");
    }

    @Override
    public PaymentType paymentType() {
        return new PaymentType("Person not found");
    }

    @Override
    public Description description() {
        return new Description("Person not found", 1500);
    }

    @Override
    public void createPerson() {
        // Do Nothing
    }

    @Override
    public void deletePerson(ParticipantId id) {
        // Do Nothing
    }
}
