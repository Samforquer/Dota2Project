package com.example.Dota2;

import hero.Hero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import service.FileService;
import service.exception.FileStorageException;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
// don't forget to remove the 'exclude' part later.
public class HeroPickerApplication {

    private static final String FIELD_DELIMITER = "\\,";
    private static final String FILE_BASE_PATH = "C:\\Users\\samfo\\OneDrive\\Documents\\currentDota2Data.csv";

    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(HeroPickerApplication.class, args);
        HeroPickerApplication.initialize();


    }

    private static void initialize() {
        try {
            List<String> heroDataList = FileService.readContentsOfFile(FILE_BASE_PATH); // is there any reason
            // I should make this a list of Hero objects?
            for (String line : heroDataList) {
                String[] heroFields = line.split(FIELD_DELIMITER);
                if (heroFields.length != 10) {
                    throw new RuntimeException("Error: Incorrect number of fields for hero: "
                            + line + " in" + FILE_BASE_PATH);
                }
                // while (fileScanner.hasNextLine()) {
                //            String line = fileScanner.nextLine();
                //            String[] heroAttributes = line.split(",");
                //            Hero hero = new Hero(heroAttributes[0],heroAttributes[1];
                //    heroList.add(hero);

            }
            System.out.println(heroDataList);
        } catch (FileStorageException e) {
            e.printStackTrace();
        }
    }
    //

    private void run() {
        // perform any if checks here for if the data has loaded in properly, etc..
        while (true) {
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection("Enter your selection below: "); // ?
            // add a check here to make sure its one of the 5 int options.
            if (mainMenuSelection == 1) {
                System.out.println("You've selected Hard Carry");
                printSkillLevelMenu();
            }

        }
    }

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
        System.out.println("Select your skill level: (1-5");
        System.out.println("1 = Crusader or lower: (< 2000 MMR)");
        System.out.println("2 = Archon: (~2000-3000 MMR)");
        System.out.println("3 = Legend:  (~3000-4000 MMR)");
        System.out.println("4 = Ancient: (~4000-5000 MMR)");
        System.out.println("5 = Divine/Immortal: (5000+ MMR)");
    }

    private void printComplexityLevelMenu() {
        System.out.println("How complex of a hero would you like to play?");
        System.out.println("1 = Very simple to play");
        System.out.println("2 = Moderately difficult to play");
        System.out.println("3 = Very difficult to play");
        // Definitely need to phrase this better or add some more clarification. Just a placeholder for now to test
        // functionality.
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