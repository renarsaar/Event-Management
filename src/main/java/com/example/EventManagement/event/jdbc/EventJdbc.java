package com.example.EventManagement.event.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.event.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Event entity.
 */
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name", "eventLocation", "description"})
@Slf4j
final class EventJdbc implements Event {
    private final @NonNull EventId id;
    private @NonNull Name name;
    private @NonNull EventTime eventTime;
    private @NonNull EventLocation eventLocation;
    private @NonNull Description description;

    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public EventId id() {
        return id;
    }

    @Override
    public Name name() {
        return name;
    }

    @Override
    public EventTime eventTime() {
        return eventTime;
    }

    @Override
    public EventLocation eventLocation() {
        return eventLocation;
    }

    @Override
    public Description description() {
        return description;
    }

    @Override
    public void createEvent() {
           jdbcTemplate.update("INSERT INTO event VALUES(?, ?, ?, ?, ?)",
                   id.value(), name.value(), eventTime.value(), eventLocation.value(), description.value());

           log.info("Event Created");
    }

    @Override
    public void deleteEvent(EventId eventId) {
        jdbcTemplate.update("DELETE FROM event WHERE id = ?", eventId.value());

        log.info("Event deleted");
    }
}
