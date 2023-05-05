package com.example.Dota2;

import hero.Hero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import service.FileService;
import service.HeroService;
import service.exception.FileStorageException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// add future feature branch for SQL integration.  create new branch after program is working. finish SQL version
// then merge back into master.

// Add dependency injection later.


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
// don't forget to remove the 'exclude' part later.
public class HeroPickerApplication {


    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        // SpringApplication.run(HeroPickerApplication.class, args);
        HeroPickerApplication app = new HeroPickerApplication();
        HeroService heroService = new HeroService();
        heroService.initialize();
        app.run(heroService);
    }

    private void run(HeroService heroService) {
        Scanner scanner = new Scanner(System.in);

        int complexity = promptForInteger(scanner, "Enter the max complexity of Hero you wish to play" +
                " (1 = low, 2 = medium, 3 = high skill): ", 1, 3);
        int position = promptForInteger(scanner, "Enter the position (1 = Carry, 2 = Midlane, 3 = Offlane," +
                " 4 = Soft Support, 5 = Hard Support): ", 1, 5);
        int skillLevel = promptForInteger(scanner, "Enter your skill bracket (1 = Below Archon, 2 = Archon, 3 = Legend," +
                " 4 = Ancient, 5 = Above Ancient): ", 1, 5);

        List<Hero> filteredHeroes = heroService.filterByComplexityAndPosition(heroService.getHeroes(), complexity, position);
//    TODO I need to figure out how to sort the filtered heroes by win rate in Desc. order.
        List<Hero> sortedHeroes = heroService.sortByWinRate(filteredHeroes, skillLevel);



        // TODO I want to make this look better when printed out, and have Headers above things
        //  for example Hero Name || Position || Win Rate for chosen bracket and then have columns of the associated data
        //  below.

        System.out.println("Here are the top recommended Heroes based on your selections, good luck! : ");
        for (Hero hero : filteredHeroes) {
            switch (skillLevel) {
                case 1 -> System.out.println(hero.getName() + " " + hero.getPosition() + " " + hero.getBelowArchonWinRate());
                case 2 -> System.out.println(hero.getName() + " " + hero.getPosition() + " " + hero.getArchonWinRate());
                case 3 -> System.out.println(hero.getName() + " " + hero.getPosition() + " " + hero.getLegendWinRate());
                case 4 -> System.out.println(hero.getName() + " " + hero.getPosition() + " " + hero.getAncientWinRate());
                case 5 -> System.out.println(hero.getName() + " " + hero.getPosition() + " " + hero.getAboveAncientWinRate());
                default -> System.out.println("Invalid skill level.");
            }


        }
    }

    private static int promptForInteger(Scanner scanner, String prompt, int min, int max) {
        int value = 0;
        do {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Ignore invalid input
            }
        } while (value < min || value > max);
        return value;
    }
}