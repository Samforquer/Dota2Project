
package com.example.dota2.controller;

import com.example.dota2.service.HeroApiService;
import com.example.dota2.model.Hero;
import com.example.dota2.service.HeroApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private final HeroApiService heroApiService;

    @Autowired
    public HeroController(HeroApiService heroApiService) {
        this.heroApiService = heroApiService;
    }

    @GetMapping
    public List<Hero> getAllHeroes() {
        // Implement the logic to fetch and return all heroes from the HeroApiService
        return heroApiService.getAllHeroes();
    }

    // Add more methods as needed to handle different HTTP endpoints
}