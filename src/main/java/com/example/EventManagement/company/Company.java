package com.example.EventManagement.company;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.event.EventId;
import com.example.EventManagement.common.primitives.ParticipantId;

/**
 * Company entity.
 */
public interface Company {
    ParticipantId participantId();

    EventId eventId();

    LegalName legalName();

    RegistryCode registryCode();

    NumberOfPartakers numberOfPartakers();

    PaymentType paymentType();

    Description description();

    void createCompany();

    // Todo: Different methods to complete

    // void deleteCompany(ParticipantId id);

    // void changeLegalName(LegalName legalName);

    // void changeRegistryCode(RegistryCode registryCode);

    // void changeNumberOfPartakers(NumberOfPartakers numberOfPartakers);

    // void changePaymentType(PaymentType paymentType);

    // void changeDescription(Description description);
}
