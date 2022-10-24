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

/**
 *
 * spring.jpa.hibernate.ddl-auto=update
 * spring.datasource.url=jdbc:mysql://localhost:3306/nullam
 * spring.datasource.username=root
 * spring.datasource.password=qwerty
 * spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLInnoDBDialect
 * logging.level.org.hibernate.SQL=DEBUG
 * logging.level.org.hibernate.type=TRACE
 *
 */