package com.circus.configuration;

import com.circus.repository.api.CircusNewsRepositoryApi;
import com.circus.repository.api.TagNewsRepositoryApi;
import com.circus.repository.implementation.CircusNewsImpl;
import com.circus.repository.implementation.TagNewsRepository;
import com.circus.service.api.CircusNewsServiceApi;
import com.circus.service.api.TagNewsServiceApi;
import com.circus.service.implementation.CircusNewsServiceImpl;
import com.circus.service.implementation.TagNewsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/circus");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTeamplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(8);
    }

}
