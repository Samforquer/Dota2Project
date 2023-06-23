package com.example.dota2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

        System.out.println("Enter your skill bracket: (1-8) : 1 = Herald, 2 = Guardian, 3 = Crusader, 4 = Archon," +
                "5 = Legend, 6 = Ancient, 7 = Divine, 8 = Immortal: ");
        int bracket = scanner.nextInt();
        System.out.println("Enter your position: (1-5) : 1 = Carry, 2 = Mid Lane, 3 = Offlane, 4 = Soft Support," +
                " 5 = Hard Support: ");
        int position = scanner.nextInt();
        System.out.println("Enter the HIGHEST complexity level you're willing to play: " +
                "1 = Low, 2 = Medium, 3 = High: ");
        int complexity = scanner.nextInt();

        List<Hero> filteredHeroes = heroFilterService.filterHeroes(heroes, bracket, Collections.singletonList(position), complexity);

        // Sort the filteredHeroes list based on win rate
        filteredHeroes.sort(Comparator.comparingDouble(hero -> getWinRateForBracket((Hero) hero, bracket)).reversed());

        int nameWidth = 20;
        int complexityWidth = 12;
        int winRateWidth = 20;

        // Print the headers
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%-" + nameWidth + "s | %-" + complexityWidth + "s | %-" + winRateWidth + "s\n",
                "Hero Name", "Complexity", "Win Rate at Selected Bracket");
        System.out.println("-".repeat(nameWidth + complexityWidth + winRateWidth + 6));

        // Print each hero's information
        for (Hero hero : filteredHeroes) {
            double winRate = getWinRateForBracket(hero, bracket);
            System.out.printf("%-" + nameWidth + "s | %-" + complexityWidth + "s | %-" + winRateWidth + ".2f%%\n",
                    hero.getName(), hero.getHeroComplexity(), winRate);
        }
    }

    private static double getWinRateForBracket(Hero hero, int bracket) {
        return switch (bracket) {
            case 1 -> hero.getHeraldWinRate();
            case 2 -> hero.getGuardianWinRate();
            case 3 -> hero.getCrusaderWinRate();
            case 4 -> hero.getArchonWinRate();
            case 5 -> hero.getLegendWinRate();
            case 6 -> hero.getAncientWinRate();
            case 7 -> hero.getDivineWinRate();
            case 8 -> hero.getImmortalWinRate();
            default -> 0.0; // Handle the case where the bracket is invalid or not found
        };
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}