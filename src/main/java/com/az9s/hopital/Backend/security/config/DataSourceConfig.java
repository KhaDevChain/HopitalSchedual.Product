package com.az9s.hopital.Backend.security.config;

import org.springframework.context.annotation.Configuration;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PreDestroy;

@Configuration
public class DataSourceConfig {
    private final HikariDataSource dataSource;

    public DataSourceConfig(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PreDestroy
    public void shutdown() {
        if (dataSource != null) {
            dataSource.close();
            System.out.println(">> HikariDataSource has been closed.");
        }
    }
}
