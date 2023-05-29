package dao;

import model.Hero;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import service.WinRateCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HeroMapper {
    private final WinRateCalculator winRateCalculator;

    public HeroMapper(WinRateCalculator winRateCalculator) {
        this.winRateCalculator = winRateCalculator;
    }

    public List<Hero> mapRowSetToHeroes(SqlRowSet rowSet) {
        List<Hero> heroes = new ArrayList<>();

        while (rowSet.next()) {
            Hero hero = mapRowToHero(rowSet);
            heroes.add(hero);
        }

        return heroes;
    }

    private Hero mapRowToHero(SqlRowSet rs) {
        Hero hero = new Hero();
        hero.setName(rs.getString("localized_name"));

        // Get the pick and win numbers for each position
        int[] picks = new int[8];
        int[] wins = new int[8];
        for (int i = 1; i <= 8; i++) {
            picks[i - 1] = rs.getInt(i + "_pick");
            wins[i - 1] = rs.getInt(i + "_win");
        }

        // Calculate and set the win rates
        hero.setHeraldWinRate(BigDecimal.valueOf(winRateCalculator.calculateWinRate(wins[0], picks[0])));
        hero.setGuardianWinRate(BigDecimal.valueOf(winRateCalculator.calculateWinRate(wins[1], picks[1])));
        hero.setCrusaderWinRate(BigDecimal.valueOf(winRateCalculator.calculateWinRate(wins[2], picks[2])));
        hero.setArchonWinRate(BigDecimal.valueOf(winRateCalculator.calculateWinRate(wins[3], picks[3])));
        hero.setLegendWinRate(BigDecimal.valueOf(winRateCalculator.calculateWinRate(wins[4], picks[4])));
        hero.setAncientWinRate(BigDecimal.valueOf(winRateCalculator.calculateWinRate(wins[5], picks[5])));
        hero.setDivineWinRate(BigDecimal.valueOf(winRateCalculator.calculateWinRate(wins[6], picks[6])));
        hero.setImmortalWinRate(BigDecimal.valueOf(winRateCalculator.calculateWinRate(wins[7], picks[7])));
        return hero;

    }
}