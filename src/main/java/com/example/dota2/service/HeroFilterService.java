package com.example.dota2.service;

import com.example.dota2.model.Hero;

import java.util.ArrayList;
import java.util.List;

public class HeroFilterService {
    public double calculateWinRate(double pickCount, double winCount) {
        if (pickCount == 0) {
            return 0.0; // Avoid division by zero
        }
        return (winCount / pickCount) * 100;
    }


}