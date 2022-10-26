package com.example.EventManagement.person.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Configuration for JDBC implementation for Person service.
 */
@Configuration
class PersonJdbcConfig {
    @Bean
    FindPersonsFromEventJdbc findPersonsFromEventJdbc(JdbcTemplate jdbcTemplate) {
        return new FindPersonsFromEventJdbc(jdbcTemplate);
    }
}
