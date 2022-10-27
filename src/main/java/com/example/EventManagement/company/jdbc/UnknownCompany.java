package com.example.EventManagement.company.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.company.Company;
import com.example.EventManagement.company.LegalName;
import com.example.EventManagement.company.NumberOfPartakers;
import com.example.EventManagement.company.RegistryCode;
import com.example.EventManagement.event.EventId;

public class UnknownCompany implements Company {
    @Override
    public ParticipantId participantId() {
        return new ParticipantId(0);
    }

    @Override
    public EventId eventId() {
        return new EventId(0);
    }

    @Override
    public LegalName legalName() {
        return new LegalName("Unknown Company");
    }

    @Override
    public RegistryCode registryCode() {
        return new RegistryCode("Unknown Company");
    }

    @Override
    public NumberOfPartakers numberOfPartakers() {
        return new NumberOfPartakers(0);
    }

    @Override
    public PaymentType paymentType() {
        return new PaymentType("Unknown Company");
    }

    @Override
    public Description description() {
        return new Description("Unknown Company", 5000);
    }

    @Override
    public void createCompany() {
        // Do nothing
    }

    @Override
    public void deleteCompany(ParticipantId id) {
        // Do nothing
    }

    @Override
    public void editCompany(ParticipantId id, LegalName legalName, RegistryCode registryCode, NumberOfPartakers numberOfPartakers, PaymentType paymentType, Description description) {
        // Do nothing
    }
}
