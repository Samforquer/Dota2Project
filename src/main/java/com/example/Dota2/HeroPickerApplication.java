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
        List<Hero> heroes = heroService.getHeroes();
    }






    private void run(HeroService heroService) {
        Scanner scanner = new Scanner(System.in);

        int complexity = promptForInteger(scanner, "Enter the complexity level (1-3): ", 1, 3);
        int position = promptForInteger(scanner, "Enter the position (1-5): ", 1, 5);
        int skillLevel = promptForInteger(scanner, "Enter the skill level (1-5): ", 1, 5);

        List<Hero> filteredHeroes = heroService.filterByComplexityAndPosition(heroService.getHeroes(), complexity, position);
        List<Hero> sortedHeroes = heroService.sortByWinRate(filteredHeroes, skillLevel);

        // Print the filtered heroes
        System.out.println("Filtered heroes:");
        for (Hero hero : filteredHeroes) {
            System.out.println(hero.getName());
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



//    public List<String> recommendHeroes(int position, int skillLevel, int complexity) {
//        // TODO: Implement recommendation algorithm based on user input
//        List<String> recommendedHeroes = new ArrayList<>();


    private void printMainMenu() {
        System.out.println("****** Welcome to the Dota 2 Hero picker app! ******");
        System.out.println("Please select the role you would like to play: (1-5)");
        System.out.println("1 = Hard Carry");
        System.out.println("2 = Midlane");
        System.out.println("3 = Offlane");
        System.out.println("4 = Soft Support");
        System.out.println("5 = Hard Support");

    }

    private void printSkillLevelMenu() {
        System.out.println("Select your skill level: (1-5): ");
        System.out.println("1 = Crusader or lower: (< 2000 MMR)");
        System.out.println("2 = Archon: (~2000-3000 MMR)");
        System.out.println("3 = Legend:  (~3000-4000 MMR)");
        System.out.println("4 = Ancient: (~4000-5000 MMR)");
        System.out.println("5 = Divine/Immortal: (5000+ MMR)");
    }

    private void printComplexityLevelMenu() {
        System.out.println("How complex of a hero would you like to play?");
        System.out.println("1 = Easy to play");
        System.out.println("2 = Moderately complicated to play");
        System.out.println("3 = Very complicated to play");
    }

    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(userInput.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }
}