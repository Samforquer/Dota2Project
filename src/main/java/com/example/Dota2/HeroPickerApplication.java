package com.example.Dota2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
// add future feature branch for SQL integration.  create new branch after program is working. finish SQL version
// then merge back into master.
// Add dependency injection later.
//TODO I need to not return any heroes with a sub 50% winrate, and possibly limit the heroes returned to the top 5 or so
//TODO redo the entire menu based on new names and attributes for Hero.java etc.
@SpringBootApplication
public class HeroPickerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HeroPickerApplication.class, args);
        System.out.println("***** Welcome to the Dota2 Hero Picker App *****");
        System.out.println("-------------------------------------------------------------------------------------");

    }
}