package com.example.EventManagement.participant.company;

import com.example.EventManagement.participant.Participant;

/**
 * Company entity.
 */
public interface Company extends Participant {
    // CompanyId companyId();

    LegalName legalName();

    RegistryCode registryCode();

    NumberOfPartakers numberOfPartakers();

    // PaymentType paymentType();

    // Description description();
}
