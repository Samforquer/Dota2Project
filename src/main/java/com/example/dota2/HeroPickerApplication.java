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

import java.util.Collections;
import java.util.List;

@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class HeroPickerApplication {

    public static void main(String[] args) {
        // Get the HeroApiService instance from the application context
        ApplicationContext context = SpringApplication.run(HeroPickerApplication.class, args);
        HeroApiService heroApiService = context.getBean(HeroApiService.class);
        Hero[] heroes = heroApiService.getAllHeroes();
        HeroFilterService heroFilterService = new HeroFilterService();

        System.out.println("****************************************");
        System.out.println("Welcome to the Dota2 Hero Picker App");
        System.out.println("****************************************");
        System.out.println(" ");
        System.out.println(" ");

// Todo how do I turn the following list into taking in the user input as the arguments? and print cleaner looking data
        List<Hero> filteredHeroes = heroFilterService.filterHeroes(heroes, 4, Collections.singletonList(3), 3);
        filteredHeroes.forEach(System.out::println);


//        // Print out the win rate of filtered heroes
//        for (Hero hero : filteredHeroes) {
//            double winRate = heroFilterService.calculateWinRate(hero, 4);
//            System.out.printf("%s - Win Rate: %.2f%% - Complexity: %d - Positions: %s%n",
//                    hero.getName(), winRate, hero.getHeroComplexity(), hero.getHeroPosition());
//        }
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}