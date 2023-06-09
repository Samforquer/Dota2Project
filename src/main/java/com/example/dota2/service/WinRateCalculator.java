package com.example.dota2.service;

public class WinRateCalculator {
    public static double calculateWinRate(double pickCount, double winCount) {
        if (pickCount == 0) {
            return 0.0; // Avoid division by zero
        }
        return (winCount / pickCount) * 100;
    }
}