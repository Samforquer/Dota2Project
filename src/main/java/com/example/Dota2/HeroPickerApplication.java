package com.example.Dota2;
import dao.HeroMapper;
import model.Hero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import service.WinRateCalculator;

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

        // Create the data source
        DataSource dataSource = createDataSource();

        // Create a JdbcTemplate with the DataSource
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // Fetch data from the database
        String sql = "SELECT * FROM heroes";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        // Create instances of HeroMapper and WinRateCalculator
        WinRateCalculator winRateCalculator = new WinRateCalculator();
        HeroMapper heroMapper = new HeroMapper(winRateCalculator);

        // Map the SqlRowSet to a list of Hero objects
        List<Hero> heroes = heroMapper.mapRowSetToHeroes(rowSet);

        // Print the mapped heroes
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    private static DataSource createDataSource() {
        // Create a DataSource with your database connection details
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/dota2Heroes");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        return dataSource;
    }
}