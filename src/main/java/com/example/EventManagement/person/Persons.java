package com.example.EventManagement.person;

import java.util.stream.Stream;

/**
 * Persons collection.
 */
public interface Persons {
    Persons range(int start, int limit);

    Persons range(int limit);

    Stream<Person> stream();
}
