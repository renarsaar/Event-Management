package com.example.EventManagement.event;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.participant.Participant;

import java.util.List;

/**
 * Event entity
 */
public interface Event {
    EventId id();

    Name name();

    EventTime eventTime();

    EventLocation eventLocation();

    Description description();

    // List of Persons or Companies
    List<Participant> participants();

    void createEvent();
}
