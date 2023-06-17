package com.example.dota2.service;

import com.example.dota2.model.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeroFilterService {
    public List<Hero> filterHeroes(Hero[] heroes, int bracket, List<Integer> position, int complexity) {
        List<Hero> filteredHeroes = Arrays.stream(heroes)
                .filter(hero -> calculateWinRate(hero,bracket)>=48)
                .filter(hero -> hero.getHeroPosition().stream().anyMatch(position::contains))
                .filter(hero -> hero.getHeroComplexity()<=complexity)
                .collect(Collectors.toList());
                 return filteredHeroes;
        }



    public double calculateWinRate(Hero hero, int bracket) {
        int pickCount = getPickCount(hero, bracket);
        int winCount = getWinCount(hero, bracket);

        if (pickCount == 0) {
            return 0.0; // Avoid division by zero
        }

        return (double) winCount / pickCount * 100;
    }

    private int getPickCount(Hero hero, int bracket) {
        return switch (bracket) {
            case 1 -> hero.getPick1();
            case 2 -> hero.getPick2();
            case 3 -> hero.getPick3();
            case 4 -> hero.getPick4();
            case 5 -> hero.getPick5();
            case 6 -> hero.getPick6();
            case 7 -> hero.getPick7();
            case 8 -> hero.getPick8();
            default -> 0;
        };
    }

    private int getWinCount(Hero hero, int bracket) {
        return switch (bracket) {
            case 1 -> hero.getWin1();
            case 2 -> hero.getWin2();
            case 3 -> hero.getWin3();
            case 4 -> hero.getWin4();
            case 5 -> hero.getWin5();
            case 6 -> hero.getWin6();
            case 7 -> hero.getWin7();
            case 8 -> hero.getWin8();
            default -> 0;
        };
    }

}