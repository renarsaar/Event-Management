package com.example.EventManagement.event.jdbc;

import com.example.EventManagement.event.Event;
import com.example.EventManagement.event.EventId;
import com.example.EventManagement.event.Events;
import com.example.EventManagement.event.FindEvents;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Find Events use-cases.
 */
@RequiredArgsConstructor
@Slf4j
final class FindEventsJdbc implements FindEvents {
    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public Events all() {
        return new EventsJdbc(
                "SELECT id, name, event_time, event_location, description FROM event",
                jdbcTemplate
        );
    }

    // Todo
    @Override
    public Event byId(EventId id) {
        return null;
    }
}
