package com.example.Dota2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class HeroPickerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroPickerApplication.class, args);
        System.out.println("***** Welcome to the Dota2 Hero Picker App *****");
        System.out.println("-------------------------------------------------------------------------------------");
    }

        private static DataSource createDataSource () {
            // Create a DataSource with database connection details.
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl("jdbc:postgresql://localhost:5432/dota2Heroes");
            dataSource.setUsername("postgres");
            dataSource.setPassword("postgres1");
            return dataSource;
        }
    }
