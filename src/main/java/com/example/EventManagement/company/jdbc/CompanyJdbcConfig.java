package com.example.EventManagement.company.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Configuration for JDBC implementation for Company service.
 */
@Configuration
class CompanyJdbcConfig {
    @Bean
    FindCompaniesFromEventJdbc findCompaniesFromEventJdbc(JdbcTemplate jdbcTemplate) {
        return new FindCompaniesFromEventJdbc(jdbcTemplate);
    }

    @Bean
    FindCompaniesJdbc findCompanies(JdbcTemplate jdbcTemplate) {
        return new FindCompaniesJdbc(jdbcTemplate);
    }

    @Bean
    CreateCompanyJdbc createCompanyJdbc(JdbcTemplate jdbcTemplate) {
        return new CreateCompanyJdbc(jdbcTemplate);
    }
}
