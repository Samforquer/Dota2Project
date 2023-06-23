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
        Scanner scanner = new Scanner(System.in);
        // TODO add checks to make sure the user input is appropriate.
        System.out.println("Enter your skill bracket: (1-8) : 1 = Herald, 2 = Guardian, 3 = Crusader, 4 = Archon," +
                "5 = Legend, 6 = Ancient, 7 = Divine, 8 = Immortal: ");
        int bracket = scanner.nextInt();
        System.out.println("Enter your position: (1-5) : 1 = Carry, 2 = Mid Lane, 3 = Offlane, 4 = Soft Support," +
                " 5 = Hard Support: ");
        int position = scanner.nextInt();
        System.out.println("Enter the HIGHEST complexity level you're willing to play: " +
                "1 = Low, 2 = Medium, 3 = High: ");
        int complexity = scanner.nextInt();

//      I am not sure what the Collections.singletonList does exactly yet. Seems to work as expected for now.//todo look into this more
        List<Hero> filteredHeroes = heroFilterService.filterHeroes(heroes, bracket, Collections.singletonList(position), complexity);

        filteredHeroes.forEach(hero -> {
            double winRate = 0.0;
            switch (bracket) {
                // Todo I need to change the output to have 2 decimal places to show the user.
                case 1 -> winRate = hero.getWin1() / hero.getPick1() * 100;
                case 2 -> winRate = hero.getWin2() / hero.getPick2() * 100;
                case 3 -> winRate = hero.getWin3() / hero.getPick3() * 100;
                case 4 -> winRate = hero.getWin4() / hero.getPick4() * 100;
                case 5 -> winRate = hero.getWin5() / hero.getPick5() * 100;
                case 6 -> winRate = hero.getWin6() / hero.getPick6() * 100;
                case 7 -> winRate = hero.getWin7() / hero.getPick7() * 100;
                case 8 -> winRate = hero.getWin8() / hero.getPick8() * 100;

                // Add more cases for other brackets if needed
                default -> {
                }
                // Handle the case where the bracket name is invalid or not found
            }
            System.out.println("Hero ID: " + hero.getId());
            System.out.println("Name: " + hero.getName());
            System.out.println("Win Rate in " + bracket + ": " + winRate + "%");
            // Print other desired information about the hero
        });

// Todo how do I turn the following list into taking in the user input as the arguments? and print cleaner looking data

    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}