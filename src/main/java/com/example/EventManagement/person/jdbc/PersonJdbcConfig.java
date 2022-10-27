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

    @Bean
    FindPersonsJdbc findPersonsJdbc(JdbcTemplate jdbcTemplate) {
        return new FindPersonsJdbc(jdbcTemplate);
    }

    @Bean
    CreatePersonJdbc createPersonJdbc(JdbcTemplate jdbcTemplate) {
        return new CreatePersonJdbc(jdbcTemplate);
    }
}
