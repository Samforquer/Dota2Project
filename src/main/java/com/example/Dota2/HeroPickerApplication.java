package com.example.Dota2;

import hero.Hero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import service.FileService;
import service.exception.FileStorageException;

import java.util.List;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
// don't forget to remove the 'exclude' part later.
public class HeroPickerApplication {

    private static final String FIELD_DELIMITER = "\\,";
    private static final String FILE_BASE_PATH = "C:\\Users\\samfo\\OneDrive\\Documents\\currentDota2Data.csv";

    public static void main(String[] args) {
        SpringApplication.run(HeroPickerApplication.class, args);
        HeroPickerApplication.initialize();
    }

    private static void initialize() {
        try {
            List<String> heroDataList = FileService.readContentsOfFile(FILE_BASE_PATH); // is there any reason I should make this a list of Hero objects?
            for (String line : heroDataList) {
                String[] heroFields = line.split(FIELD_DELIMITER);
                if (heroFields.length != 9) {
                    throw new RuntimeException("Error: Incorrect number of fields for hero: " + line + " in" + FILE_BASE_PATH);
                }
            }
        } catch (FileStorageException e) {
            e.printStackTrace();
        }


    }
}
