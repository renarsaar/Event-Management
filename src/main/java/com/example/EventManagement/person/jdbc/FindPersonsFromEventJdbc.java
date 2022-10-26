package com.example.EventManagement.person.jdbc;

import com.example.EventManagement.event.EventId;
import com.example.EventManagement.person.FindPersonsFromEvent;
import com.example.EventManagement.person.Persons;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Find Persons from Events use-cases.
 */
@RequiredArgsConstructor
@Slf4j
final class FindPersonsFromEventJdbc implements FindPersonsFromEvent {
    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public Persons byEventId(@NonNull EventId eventId) {
        return new PersonsJdbc(
            "SELECT " +
                    "p.first_name, p.last_name, p.personal_code " +
                    "FROM person p " +
                    "WHERE p.event_id = ?",
                eventId.value(), jdbcTemplate);
    }
}
