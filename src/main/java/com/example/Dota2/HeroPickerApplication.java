package com.example.Dota2;

import hero.Hero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import service.FileService;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) // don't forget to remove the 'exclude' part later.
public class HeroPickerApplication {

	private static final String FIELD_DELIMITER = "\\,";
	private static final String FILE_BASE_PATH = "C:\\Users\\samfo\\OneDrive\\Desktop\\Dota2Project\\Dota2\\Dota2HeroCSV.csv";

	public static void main(String[] args) {
		SpringApplication.run(HeroPickerApplication.class, args);
		HeroPickerApplication.initialize();
	}

	private static void initialize() {

	}


}
