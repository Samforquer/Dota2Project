package com.example.dota2.service;

import com.example.dota2.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service

public class HeroApiService {
    private final RestTemplate restTemplate;
@Autowired
    public HeroApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Hero> fetchHeroesFromApi() {
        String apiUrl = "https://api.opendota.com/api/herostats";
        ResponseEntity<Hero[]> response = restTemplate.getForEntity(apiUrl, Hero[].class);
        Hero[] heroes = response.getBody();
        return Arrays.asList(heroes != null ? heroes : new Hero[0]);
    }

}
    // Implement methods for fetching and filtering hero data from the API
    // Implement the logic to fetch all heroes from the API
        // Example code:
        // Make API request to fetch hero data
        // Parse the response and create a list of Hero objects
        // Return the list of heroes
    // Add more methods as needed for filtering and manipulating hero data
