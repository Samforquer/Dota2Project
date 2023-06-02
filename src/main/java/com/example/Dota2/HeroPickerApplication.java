package com.example.Dota2;

import controller.HeroController;
import dao.HeroDao;
import dao.JdbcHeroDao;
import model.Hero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;
import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
@ComponentScan("controller")
@ComponentScan("dao")
@ComponentScan("service")
public class HeroPickerApplication {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HeroPickerApplication.class, args);
        try {
            Thread.sleep(60000); // Pause the main thread for 60 seconds (1 minute)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Get the JdbcHeroDao bean and pass the DataSource to its constructor
        JdbcHeroDao heroDao = context.getBean(JdbcHeroDao.class);
        DataSource dataSource = context.getBean(DataSource.class);
        heroDao.setDataSource(dataSource);
        System.out.println("***** Welcome to the Dota2 Hero Picker App *****");
        System.out.println("-------------------------------------------------------------------------------------");
// Retrieve the HeroController bean from the application context
        HeroController heroController = context.getBean(HeroController.class);

        // Fetch the hero data from the API
        List<Hero> heroes = heroController.getHeroes();

        // Print the hero items
        for (Hero hero : heroes) {
            System.out.println(hero);
        }

        // Close the application context
        context.close();
    }
    @Bean
        private static DataSource createDataSource () {
            // Create a DataSource with database connection details.
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl("jdbc:postgresql://localhost:5432/dota2_Heroes");
            dataSource.setUsername("postgres");
            dataSource.setPassword("postgres1");
            return dataSource;
        }
    }
