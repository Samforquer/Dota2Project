package service;

import model.Hero;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service

public class HeroApiService {
    private final RestTemplate restTemplate;

    public HeroApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Hero> fetchHeroesFromApi() {
        String apiUrl = "https://api.opendota.com/api/herostats";
        ResponseEntity<Hero[]> response = restTemplate.getForEntity(apiUrl, Hero[].class);
        Hero[] heroes = response.getBody();
        return Arrays.asList(heroes);
    }
}