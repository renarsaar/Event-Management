package com.example.EventManagement.company.jdbc;

import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.company.Company;
import com.example.EventManagement.company.FindCompanies;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Find Companies use-cases.
 */
@RequiredArgsConstructor
@Slf4j
public class FindCompaniesJdbc implements FindCompanies {
    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public Company byId(ParticipantId id) {
        return new CompaniesJdbc(
                "SELECT id, event_id, legal_name, registry_code, number_of_partakers, payment_type, description FROM company WHERE id = ?",
                id.value(), jdbcTemplate).stream()
                .findFirst()
                .orElseGet(UnknownCompany::new);
    }
}
