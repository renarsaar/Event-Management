package com.example.EventManagement.person.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.event.EventId;
import com.example.EventManagement.person.CreatePerson;
import com.example.EventManagement.person.FirstName;
import com.example.EventManagement.person.LastName;
import com.example.EventManagement.person.PersonalCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
class CreatePersonJdbc implements CreatePerson {
    private final @NonNull JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void createPerson(ParticipantId id, EventId eventId, FirstName firstName, LastName lastName, PersonalCode personalCode, PaymentType paymentType, Description description) {
        new PersonJdbc(
                id, eventId, firstName, lastName, personalCode, paymentType, description, jdbcTemplate
        ).createPerson();
    }
}
