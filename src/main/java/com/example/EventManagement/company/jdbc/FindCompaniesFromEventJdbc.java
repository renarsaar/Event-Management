package com.example.EventManagement.company.jdbc;

import com.example.EventManagement.event.EventId;
import com.example.EventManagement.company.Companies;
import com.example.EventManagement.company.FindCompaniesFromEvent;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Find Companies from Events use-cases.
 */
@RequiredArgsConstructor
@Slf4j
final class FindCompaniesFromEventJdbc implements FindCompaniesFromEvent {
    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public Companies byEventId(@NonNull EventId eventId) {
        return new CompaniesJdbc(
            "SELECT " +
                    "c.legal_name, c.registry_code " +
                    "FROM company c " +
                    "WHERE c.event_id = ?",
                eventId.value(), jdbcTemplate);
    }
}
