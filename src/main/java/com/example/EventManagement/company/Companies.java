package com.example.EventManagement.company;

import java.util.stream.Stream;

/**
 * Companies collection.
 */
public interface Companies {
    Companies range(int start, int limit);

    Companies range(int limit);

    Stream<Company> stream();
}
