package com.example.dota2;

import com.example.dota2.model.Hero;
import com.example.dota2.service.HeroApiService;
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
        // Get the HeroApiService instance from the application context
        ApplicationContext context = SpringApplication.run(HeroPickerApplication.class, args);
        HeroApiService heroApiService = context.getBean(HeroApiService.class);
        System.out.println("****************************************");
        System.out.println("Welcome to the Dota2 Hero Picker App");
        System.out.println("****************************************");
        System.out.println(" ");
        System.out.println(" ");
        // Call the run method to print out all the heroes
        HeroPickerApplication heroPickerApplication = new HeroPickerApplication();
        heroPickerApplication.run(heroApiService);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public void run(HeroApiService heroApiService) {
        Hero[] heroes = heroApiService.fetchHeroesFromApi();
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}