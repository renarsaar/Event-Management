package com.example.EventManagement.participant;

import java.util.stream.Stream;

/**
 * Participants collection.
 */
public interface Participants {
    Participants range(int limit);

    Stream<Participants> stream();
}
