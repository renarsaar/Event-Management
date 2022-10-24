package com.example.EventManagement.event.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.event.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * JDBC implementation of Events collection.
 */
@RequiredArgsConstructor
final class EventsJdbc implements Events {
    private static final int UNLIMITED = 1000;

    private final @NonNull String query;
    private final @NonNull List<Object> queryParams;

    private final @NonNull JdbcTemplate jdbcTemplate;

    private int start = 0;
    private int limit = UNLIMITED;

    public EventsJdbc(@NonNull String query, @NonNull Object queryParam, @NonNull JdbcTemplate jdbcTemplate) {
        this(query, List.of(queryParam), jdbcTemplate);
    }

    public EventsJdbc(@NonNull String query, @NonNull JdbcTemplate jdbcTemplate) {
        this(query, List.of(), jdbcTemplate);
    }

    @Override
    public Events range(int start, int limit) {
        if (start < 0 || limit <= 0 || limit - start > UNLIMITED) {
            throw new IllegalArgumentException("Start must be greater than zero, " +
                    "items count must be greater than zero and less or equal than " + UNLIMITED);
        }

        this.start = start;
        this.limit = limit;

        return this;
    }

    @Override
    public Events range(int limit) {
        return range(0, limit);
    }

    @Override
    public Stream<Event> stream() {
        var params = new ArrayList<>(queryParams);
        params.add(start);
        params.add(limit);

        return jdbcTemplate.queryForList(query.concat(" ORDER BY 1 LIMIT ?,?"), params.toArray())
                .stream()
                .map(this::toEvent);
    }

    private Event toEvent(Map<String, Object> entry) {
        return new EventJdbc(
                new EventId(entry.get("id")),
                new Name((String) entry.get("name")),
                new EventTime((String) entry.get("eventTime")),
                new EventLocation((String) entry.get("eventLocation")),
                new Description((String) entry.get("description"), 1000),
                new ArrayList<>(),
                jdbcTemplate
        );
    }
}
