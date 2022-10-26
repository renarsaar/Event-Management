package com.example.EventManagement.event.jdbc;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.event.*;

public class UnknownEvent implements Event {
    @Override
    public EventId id() {
        return new EventId(0);
    }

    @Override
    public Name name() {
        return new Name("Unknown event");
    }

    @Override
    public EventTime eventTime() {
        return new EventTime("Unknown event time");
    }

    @Override
    public EventLocation eventLocation() {
        return new EventLocation("Unknown event location");
    }

    @Override
    public Description description() {
        return new Description("Unknows event description", 1000);
    }

    @Override
    public void createEvent() {
        // Do nothing
    }

    @Override
    public void deleteEvent(EventId id) {
        // Do nothing
    }
}
