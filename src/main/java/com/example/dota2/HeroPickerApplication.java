package com.example.dota2;

import com.example.dota2.model.Hero;
import com.example.dota2.service.HeroApiService;
import com.example.dota2.service.HeroFilterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class HeroPickerApplication {

    public static void main(String[] args) {
        // Get the HeroApiService instance from the application context
        ApplicationContext context = SpringApplication.run(HeroPickerApplication.class, args);
        HeroApiService heroApiService = context.getBean(HeroApiService.class);
        System.out.println("****************************************");
        System.out.println("Welcome to the Dota2 Hero Picker App");
        System.out.println("****************************************");
        System.out.println(" ");
        System.out.println(" ");
        Hero[] heroes = heroApiService.fetchHeroesFromApi();

        // Create an instance of HeroFilterService
        HeroFilterService heroFilterService = new HeroFilterService();

        // Filter heroes by win rate in bracket 4 -Archon for example
        List<Hero> filteredHeroes = heroFilterService.filterHeroesByWinRate(heroes, 4);

        // Print out the win rate of filtered heroes
        for (Hero hero : filteredHeroes) {
            double winRate = heroFilterService.calculateWinRate(hero, 4);
            System.out.println(hero.getName() + " - Win Rate: " + winRate + "%");
        }

    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}