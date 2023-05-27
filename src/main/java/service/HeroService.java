package service;

import hero.Hero;
import service.exception.FileStorageException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

public class HeroService {

    private List<Hero> heroes = new ArrayList<>();


    public void initialize() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.opendota.com/api/heroes";
        //TODO I need to check the format of the data this returns. Just testing for now.

        ResponseEntity<Hero[]> response = restTemplate.getForEntity(url, Hero[].class);
        Hero[] heroArray = response.getBody();

        if (heroArray != null) {
            heroes = Arrays.asList(heroArray);
        }
    }

    public List<Hero> getHeroes() {
        return heroes;
    }


    public List<Hero> filterByComplexityAndPosition(List<Hero> heroes, int complexity, int position) {
        // <= complexity so users can select the HIGHEST level of complexity, for example: max complexity 3 will return 1 2 and 3 
        return heroes.stream()
                .filter(hero -> hero.getComplexity() <= complexity && hero.getPosition() == position)
                .collect(Collectors.toList());
    }

    public List<Hero> sortByWinRate(List<Hero> heroes, int skillLevel) {
        switch (skillLevel) {
            case 1 -> heroes.sort(Comparator.comparing(Hero::getBelowArchonWinRate).reversed());
            case 2 -> heroes.sort(Comparator.comparing(Hero::getArchonWinRate).reversed());
            case 3 -> heroes.sort(Comparator.comparing(Hero::getLegendWinRate).reversed());
            case 4 -> heroes.sort(Comparator.comparing(Hero::getAncientWinRate).reversed());
            case 5 -> heroes.sort(Comparator.comparing(Hero::getAboveAncientWinRate).reversed());
            default -> throw new IllegalArgumentException("Invalid skill level: " + skillLevel);
        }
        return heroes;
    }

    }

