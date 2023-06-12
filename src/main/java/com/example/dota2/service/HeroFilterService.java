package com.example.dota2.service;

import com.example.dota2.model.Hero;

import java.util.ArrayList;
import java.util.List;

public class HeroFilterService {

    public List<Hero> filterHeroesByWinRate(Hero[] heroes, int bracket) {
        List<Hero> filteredHeroes = new ArrayList<>();

        for (Hero hero : heroes) {
            double winRate = calculateWinRate(hero, bracket);
            if (winRate >= 50.0) {
                filteredHeroes.add(hero);
            }
        }

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
        switch (bracket) {
            case 1:
                return hero.getPick1();
            case 2:
                return hero.getPick2();
            case 3:
                return hero.getPick3();
            case 4:
                return hero.getPick4();
            case 5:
                return hero.getPick5();
            case 6:
                return hero.getPick6();
            case 7:
                return hero.getPick7();
            case 8:
                return hero.getPick8();
            default:
                return 0;
        }
    }

    private int getWinCount(Hero hero, int bracket) {
        switch (bracket) {
            case 1:
                return hero.getWin1();
            case 2:
                return hero.getWin2();
            case 3:
                return hero.getWin3();
            case 4:
                return hero.getWin4();
            case 5:
                return hero.getWin5();
            case 6:
                return hero.getWin6();
            case 7:
                return hero.getWin7();
            case 8:
                return hero.getWin8();
            default:
                return 0;
        }
    }
}