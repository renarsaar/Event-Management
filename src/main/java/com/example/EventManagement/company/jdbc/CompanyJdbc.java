package com.example.EventManagement.company.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.event.EventId;
import com.example.EventManagement.company.Company;
import com.example.EventManagement.company.LegalName;
import com.example.EventManagement.company.NumberOfPartakers;
import com.example.EventManagement.company.RegistryCode;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBC implementation for Company entity.
 */
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "eventId", "legalName", "registryCode", "paymentType", "description"})
@Slf4j
final class CompanyJdbc implements Company {
    private final @NonNull ParticipantId id;
    private final @NonNull EventId eventId;
    private @NonNull LegalName legalName;
    private @NonNull RegistryCode registryCode;
    private @NonNull NumberOfPartakers numberOfPartakers;
    private @NonNull PaymentType paymentType;
    private @NonNull Description description;

    private final @NonNull JdbcTemplate jdbcTemplate;

    @Override
    public ParticipantId participantId() {
        return id;
    }

    @Override
    public EventId eventId() {
        return eventId;
    }

    @Override
    public LegalName legalName() {
        return legalName;
    }

    @Override
    public RegistryCode registryCode() {
        return registryCode;
    }

    @Override
    public NumberOfPartakers numberOfPartakers() {
        return numberOfPartakers;
    }

    @Override
    public PaymentType paymentType() {
        return paymentType;
    }

    @Override
    public Description description() {
        return description;
    }

    @Override
    public void createCompany() {
        jdbcTemplate.update("INSERT INTO company VALUES(?, ?, ?, ?, ?, ?, ?)",
                id.value(),
                eventId.value(),
                legalName.value(),
                registryCode.value(),
                numberOfPartakers.value(),
                paymentType.value(),
                description.value()
        );

        log.info("Company created");
    }

    @Override
    public void deleteCompany(ParticipantId id) {
        jdbcTemplate.update("DELETE FROM company WHERE id = ?", id.value());

        log.info("Company deleted");
    }

    @Override
    public void editCompany(ParticipantId id, LegalName legalName, RegistryCode registryCode, NumberOfPartakers numberOfPartakers, PaymentType paymentType, Description description) {
        jdbcTemplate.update(
                "UPDATE company " +
                        "SET legal_name = ?, " +
                        "registry_code = ?, " +
                        "number_of_partakers = ?, " +
                        "payment_type = ?, " +
                        "description = ? WHERE id = ?",
                legalName.value(),
                registryCode.value(),
                numberOfPartakers.value(),
                paymentType.value(),
                description.value(),
                participantId().value()
        );

        log.info("Company edited");
    }
}
