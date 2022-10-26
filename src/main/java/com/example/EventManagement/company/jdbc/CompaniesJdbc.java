package com.example.EventManagement.company.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.event.EventId;
import com.example.EventManagement.company.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * JDBC implementation of Companies collection.
 */
@RequiredArgsConstructor
final class CompaniesJdbc implements Companies {
    private static final int UNLIMITED = 1000;

    private final @NonNull String query;
    private final @NonNull List<Object> queryParams;

    private final @NonNull JdbcTemplate jdbcTemplate;

    private int start = 0;
    private int limit = UNLIMITED;

    public CompaniesJdbc(@NonNull String query, @NonNull Object queryParam, @NonNull JdbcTemplate jdbcTemplate) {
        this(query, List.of(queryParam), jdbcTemplate);
    }

    public CompaniesJdbc(@NonNull String query, @NonNull JdbcTemplate jdbcTemplate) {
        this(query, List.of(), jdbcTemplate);
    }

    @Override
    public Companies range(int start, int limit) {
        if (start < 0 || limit <= 0 || limit - start > UNLIMITED) {
            throw new IllegalArgumentException("Start must be greater than zero, " +
                    "items count must be greater than zero and less or equal than " + UNLIMITED);
        }

        this.start = start;
        this.limit = limit;

        return this;
    }

    @Override
    public Companies range(int limit) {
        return range(0, limit);
    }

    @Override
    public Stream<Company> stream() {
        var params = new ArrayList<>(queryParams);
        params.add(start);
        params.add(limit);

        return jdbcTemplate.queryForList(query.concat(" ORDER BY 1 LIMIT ?,?"), params.toArray())
                .stream()
                .map(this::toCompany);
    }

    private Company toCompany(Map<String, Object> entry) {
        return new CompanyJdbc(
            new ParticipantId(entry.get("id")),
            new EventId(entry.get("event_id")),
            new LegalName((String) entry.get("legal_name")),
            new RegistryCode((String) entry.get("registry_code")),
            new NumberOfPartakers((Integer) entry.get("number_of_partakers")),
            new PaymentType((String) entry.get("payment_type")),
            new Description((String) entry.get("description"), 5000),
            jdbcTemplate
        );
    }
}
