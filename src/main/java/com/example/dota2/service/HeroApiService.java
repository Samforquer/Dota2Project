package com.example.dota2.service;

import com.example.dota2.model.Hero;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;

@Service

public class HeroApiService {
    private final RestTemplate restTemplate;

    @Autowired
    public HeroApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void populateLocalData(Hero[] heroes) {
        try {
            // Read the local JSON file
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("complexity-positions");

            // Parse the JSON file using Jackson ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            Hero[] localHeroData = objectMapper.readValue(inputStream, Hero[].class);

            // Populate the remaining variables for each Hero object
            for (int i = 0; i < heroes.length; i++) {
                heroes[i].setHeroComplexity(localHeroData[i].getHeroComplexity());
                heroes[i].setHeroPosition(localHeroData[i].getHeroPosition());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Hero[] getAllHeroes() {
        String apiUrl = "https://api.opendota.com/api/herostats";
        ResponseEntity<Hero[]> response = restTemplate.getForEntity(apiUrl, Hero[].class);
        Hero[] heroes = response.getBody();

        if (heroes != null) {
            populateLocalData(heroes);
        }

        return heroes;
    }


}

