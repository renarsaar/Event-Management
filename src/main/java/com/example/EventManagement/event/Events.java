package com.example.EventManagement.event;

import java.util.stream.Stream;

/**
 * Events collection.
 */
public interface Events {

    Events range(int start, int limit);

    Events range(int limit);

    Stream<Event> stream();
}
