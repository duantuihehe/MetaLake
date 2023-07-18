package com.metalake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.core.JdbcTemplate;

//import javax.sql.DataSource;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Application {

//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
