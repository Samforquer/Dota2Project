package com.example.dota2;
import java.util.Scanner;
import java.util.stream.Collectors;
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
        ApplicationContext context = SpringApplication.run(HeroPickerApplication.class, args);
        HeroApiService heroApiService = context.getBean(HeroApiService.class);
        Hero[] heroes = heroApiService.getAllHeroes();
        HeroFilterService heroFilterService = new HeroFilterService();

        System.out.println("****************************************");
        System.out.println("Welcome to the Dota2 Hero Picker App");
        System.out.println("****************************************");
        System.out.println(" ");
        System.out.println(" ");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your skill bracket: (1-8) : 1 = Herald, 2 = Guardian, 3 = Crusader, 4 = Archon," +
//                "5 = Legend, 6 = Ancient, 7 = Divine, 8 = Immortal");
//        int bracket = scanner.nextInt();
//        System.out.println("Enter your position: (1-5) : 1 = Carry, 2 = Mid Lane, 3 = Offlane, 4 = Soft Support," +
//                " 5 = Hard Support");
//        int position = scanner.nextInt();


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