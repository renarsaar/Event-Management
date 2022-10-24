package com.example.EventManagement.participant.company;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * Company Registry Code domain primitive.
 */
@EqualsAndHashCode
@ToString
public final class RegistryCode {
    private final @NonNull String registryCode;

    public RegistryCode(String location) {
        var registryCodeVal = location.strip();

        if (registryCodeVal.isBlank()) {
            throw new IllegalArgumentException("Company registry code cannot be empty!");
        }

        this.registryCode = registryCodeVal;
    }

    public String value() {
        return registryCode;
    }
}
