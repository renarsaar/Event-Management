package com.example.EventManagement.person.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.event.EventId;
import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.person.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * JDBC implementation of Persons collection.
 */
@RequiredArgsConstructor
final class PersonsJdbc implements Persons {
    private static final int UNLIMITED = 1000;

    private final @NonNull String query;
    private final @NonNull List<Object> queryParams;

    private final @NonNull JdbcTemplate jdbcTemplate;

    private int start = 0;
    private int limit = UNLIMITED;

    public PersonsJdbc(@NonNull String query, @NonNull Object queryParam, @NonNull JdbcTemplate jdbcTemplate) {
        this(query, List.of(queryParam), jdbcTemplate);
    }

    public PersonsJdbc(@NonNull String query, @NonNull JdbcTemplate jdbcTemplate) {
        this(query, List.of(), jdbcTemplate);
    }

    @Override
    public Persons range(int start, int limit) {
        if (start < 0 || limit <= 0 || limit - start > UNLIMITED) {
            throw new IllegalArgumentException("Start must be greater than zero, " +
                    "items count must be greater than zero and less or equal than " + UNLIMITED);
        }

        this.start = start;
        this.limit = limit;

        return this;
    }

    @Override
    public Persons range(int limit) {
        return range(0, limit);
    }

    @Override
    public Stream<Person> stream() {
        var params = new ArrayList<>(queryParams);
        params.add(start);
        params.add(limit);

        return jdbcTemplate.queryForList(query.concat(" ORDER BY 1 LIMIT ?,?"), params.toArray())
                .stream()
                .map(this::toPerson);
    }

    private Person toPerson(Map<String, Object> entry) {
        return new PersonJdbc(
                new ParticipantId(entry.get("id")),
                new EventId(entry.get("event_id")),
                new FirstName((String) entry.get("first_name")),
                new LastName((String) entry.get("last_name")),
                new PersonalCode((String) entry.get("personal_code")),
                new PaymentType((String) entry.get("payment_type")),
                new Description((String) entry.get("description"), 1500),
                jdbcTemplate
        );
    }
}
