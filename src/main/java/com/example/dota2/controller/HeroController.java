package com.example.dota2.controller;

import com.example.dota2.model.Hero;
import com.example.dota2.service.HeroApiService;
import com.example.dota2.service.HeroFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroApiService heroApiService;
    private final HeroFilterService heroFilterService;

    @Autowired
    public HeroController(HeroApiService heroApiService, HeroFilterService heroFilterService) {
        this.heroApiService = heroApiService;
        this.heroFilterService = heroFilterService;
    }

    @GetMapping
    public ResponseEntity<List<Hero>> getAllHeroes() {
        // Fetch all heroes from the OpenDota API
        Hero[] allHeroes = heroApiService.getAllHeroes();
        for (Hero hero : allHeroes) {
            Hero detailedHeroData = heroApiService.getHeroDetails(hero.getId());
            hero.setImg(detailedHeroData.getImg());
        }
        // Return all heroes as an HTTP response
        return ResponseEntity.ok(List.of(allHeroes));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Hero>> filterHeroes(
            @RequestParam int bracket,
            @RequestParam List<Integer> position,
            @RequestParam List<Integer> complexity
    ) {
        // Fetch all heroes from the OpenDota API
        Hero[] allHeroes = heroApiService.getAllHeroes();

        // Apply filtering criteria to get filtered heroes
        List<Hero> filteredHeroes = heroFilterService.filterHeroes(allHeroes, bracket, position, complexity);

        // Return the filtered heroes as an HTTP response
        return ResponseEntity.ok(filteredHeroes);
    }
}