package com.example.Dota2;

import dao.JdbcHeroDao;
import model.Hero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.client.RestTemplate;
import service.HeroApiService;


import javax.sql.DataSource;
import java.util.List;
import java.util.Scanner;
// add future feature branch for SQL integration.  create new branch after program is working. finish SQL version
// then merge back into master.
// Add dependency injection later.
//TODO I need to not return any heroes with a sub 50% winrate, and possibly limit the heroes returned to the top 5 or so
//TODO redo the entire menu based on new names and attributes for Hero.java etc.
@SpringBootApplication
public class HeroPickerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroPickerApplication.class, args);
        System.out.println("***** Welcome to the Dota2 Hero Picker App *****");
        System.out.println("-------------------------------------------------------------------------------------");
        ApplicationContext context = new AnnotationConfigApplicationContext(HeroPickerApplication.class);
        DataSource dataSource = createDataSource();
        JdbcHeroDao heroDao = new JdbcHeroDao(dataSource, context.getBean(RestTemplate.class));

        List<Hero> heroes = heroDao.fetchHeroesFromApi();

        // Print the list of heroes
        for (Hero hero : heroes) {
            System.out.println(hero.getName());
        }
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
