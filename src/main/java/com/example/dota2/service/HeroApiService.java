package com.example.dota2.service;

import com.example.dota2.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class HeroApiService {
    private final RestTemplate restTemplate;

    @Autowired
    public HeroApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Hero[] fetchHeroesFromApi() {
        String apiUrl = "https://api.opendota.com/api/herostats";
        ResponseEntity<Hero[]> response = restTemplate.getForEntity(apiUrl, Hero[].class);
        return response.getBody();
    }

}

