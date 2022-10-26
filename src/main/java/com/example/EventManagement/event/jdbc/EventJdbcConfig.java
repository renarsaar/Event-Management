package com.example.EventManagement.event.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Configuration for JDBC implementation for Event service.
 */
@Configuration
class EventJdbcConfig {
    @Bean
    FindEventsJdbc findEventsJdbc(JdbcTemplate jdbcTemplate) {
        return new FindEventsJdbc(jdbcTemplate);
    }
}
