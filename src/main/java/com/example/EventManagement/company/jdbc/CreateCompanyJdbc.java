package com.example.EventManagement.company.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.company.CreateCompany;
import com.example.EventManagement.company.LegalName;
import com.example.EventManagement.company.NumberOfPartakers;
import com.example.EventManagement.company.RegistryCode;
import com.example.EventManagement.event.EventId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
public class CreateCompanyJdbc implements CreateCompany {
    private final @NonNull JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void createCompany(ParticipantId id, EventId eventId, LegalName legalName, RegistryCode registryCode, NumberOfPartakers numberOfPartakers, PaymentType paymentType, Description description) {
        new CompanyJdbc(
                id,
                eventId,
                legalName,
                registryCode,
                numberOfPartakers,
                paymentType,
                description,
                jdbcTemplate
        ).createCompany();
    }
}
