package com.example.EventManagement.person.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.event.EventId;
import com.example.EventManagement.person.*;
import com.example.EventManagement.common.primitives.ParticipantId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Person entity.
 */
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "eventId", "firstName", "lastName", "personalCode", "paymentType", "description"})
@Slf4j
final class PersonJdbc implements Person {
    private final @NonNull ParticipantId id;
    private final @NonNull EventId eventId;
    private @NonNull FirstName firstName;
    private @NonNull LastName lastName;
    private @NonNull PersonalCode personalCode;
    private @NonNull PaymentType paymentType;
    private @NonNull Description description;

    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public ParticipantId participantId() {
        return id;
    }

    @Override
    public EventId eventId() {
        return eventId;
    }

    @Override
    public FirstName firstName() {
        return firstName;
    }

    @Override
    public LastName lastName() {
        return lastName;
    }

    @Override
    public PersonalCode personalCode() {
        return personalCode;
    }

    @Override
    public PaymentType paymentType() {
        return paymentType;
    }

    @Override
    public Description description() {
        return description;
    }

    @Override
    public void createPerson() {
        jdbcTemplate.update("INSERT INTO person VALUES(?, ?, ?, ?, ?, ?, ?)",
                id.value(),
                eventId.value(),
                firstName.value(),
                lastName.value(),
                personalCode.value(),
                paymentType.value(),
                description.value()
        );

        log.info("Person created");
    }

    @Override
    public void deletePerson(ParticipantId id) {
        jdbcTemplate.update("DELETE FROM person WHERE id = ?", id.value());

        log.info("Person deleted");
    }

    @Override
    public void editPerson(ParticipantId id, FirstName firstName, LastName lastName, PersonalCode personalCode, PaymentType paymentType, Description description) {
        jdbcTemplate.update(
                "UPDATE person " +
                        "SET first_name = ?, " +
                        "last_name = ?, " +
                        "personal_code = ?, " +
                        "payment_type = ?, " +
                        "description = ? WHERE id = ?",
                firstName.value(),
                lastName.value(),
                personalCode.value(),
                paymentType.value(),
                description.value(),
                participantId().value()
        );

        log.info("Person updated");
    }
}
