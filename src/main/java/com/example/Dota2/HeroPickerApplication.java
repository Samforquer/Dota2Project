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

    private final Scanner keyboard = new Scanner(System.in);
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

    private void run(){
        // perform any if checks here for if the data has loaded in properly, etc..
        while(true){
            printMainMenu();
            int mainMenuSelection = promptForRoleSelection(keyboard.nextLine()); // ?
            if(mainMenuSelection == 1){
                printCarryMenu();
            }

    }
    }
        private void printMainMenu(){
            System.out.println("****** Welcome to the Dota 2 Hero picker app! ******");
            System.out.println("Please select the role you would like to play: (1-5)");
            System.out.println("1 = Carry");
            System.out.println("2 = Midlane");
            System.out.println("3 = Offlane");
            System.out.println("4 = Soft Support");
            System.out.println("5 = Hard Support");

        }
        private void printCarryMenu(){
            System.out.println("Select your skill level: (1-5");
            System.out.println("");
        }
        private void printSkillLevelSelectMenu(){

        }
    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

        private int promptForRoleSelection(String prompt){
            System.out.println();

        return 0; // Change this later
        }
}