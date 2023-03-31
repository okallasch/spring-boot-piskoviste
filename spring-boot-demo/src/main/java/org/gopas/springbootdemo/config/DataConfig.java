package org.gopas.springbootdemo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataConfig {

//    @Bean
//    public DataSource dataSource() {
//        HikariDataSource hikariDataSource = new HikariDataSource();
//        hikariDataSource.setUsername("postgres");
//        hikariDataSource.setPassword("postgres");
//        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/db-training");
//        return hikariDataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }

}
