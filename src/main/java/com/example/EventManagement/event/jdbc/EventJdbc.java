package com.example.EventManagement.event.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.event.*;
import com.example.EventManagement.participant.Participant;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * JDBC implementation for Event entity.
 */
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name", "eventLocation", "description"})
final class EventJdbc implements Event {
    private final @NonNull EventId id;
    private @NonNull Name name;
    private @NonNull EventTime eventTime;
    private @NonNull EventLocation eventLocation;
    private @NonNull Description description;
    private @NonNull List<Participant> participants;

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
    public List<Participant> participants() {
        return participants;
    }

    @Override
    public void createEvent() {
           jdbcTemplate.update("INSERT INTO events VALUES(?, ?, ?, ?, ?)",
                   id.value(), name.value(), eventTime.value(), eventLocation.value(), description.value());
    }
}
