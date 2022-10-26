package com.example.EventManagement.event.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.event.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
class CreateEventJdbc implements CreateEvent {
    private final @NonNull JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void createEvent(EventId id, Name name, EventTime time, EventLocation location, Description description) {
        new EventJdbc(
                id,
                name,
                time,
                location,
                description,
                jdbcTemplate
        ).createEvent();
    }
}
