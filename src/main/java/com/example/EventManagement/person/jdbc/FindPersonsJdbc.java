package com.example.EventManagement.person.jdbc;

import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.person.FindPersons;
import com.example.EventManagement.person.Person;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Find Persons use-cases.
 */
@RequiredArgsConstructor
@Slf4j
public class FindPersonsJdbc implements FindPersons {
    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public Person byId(ParticipantId id) {
        return new PersonsJdbc(
                "SELECT id, event_id, first_name, last_name, personal_code, payment_type, description FROM person WHERE id = ?",
                id.value(), jdbcTemplate).stream()
                .findFirst()
                .orElseGet(UnknownPerson::new);
    }
}
