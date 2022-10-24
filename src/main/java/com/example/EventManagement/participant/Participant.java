package com.example.EventManagement.participant;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.PaymentType;

public interface Participant {
    ParticipantId participantId();

    PaymentType paymentType();

    Description description();
}
