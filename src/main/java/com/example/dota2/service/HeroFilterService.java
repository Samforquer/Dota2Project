package com.example.dota2.service;

import com.example.dota2.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class HeroFilterService {
    public List<Hero> filterHeroes(Hero[] heroes, int bracket, List<Integer> position, List<Integer> complexity) {
        return Arrays.stream(heroes)
                // Heroes above or equal to 50% winrate should be shown.
                .filter(hero -> calculateWinRate(hero,bracket)>=50)
                .filter(hero -> hero.getHeroPosition().stream().anyMatch(position::contains))
                .filter(hero -> hero.getHeroComplexity().stream().anyMatch(complexity::contains))
                .collect(Collectors.toList());
        }



    public double calculateWinRate(Hero hero, int bracket) {
        double pickCount = getPickCount(hero, bracket);
        double winCount = getWinCount(hero, bracket);

        if (pickCount == 0) {
            return 0.0;
        }

        return winCount / pickCount * 100;
    }

    private double getPickCount(Hero hero, double bracket) {
        return switch ((int) bracket) {
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

    private double getWinCount(Hero hero, double bracket) {
        return switch ((int) bracket) {
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