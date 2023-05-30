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
       return null; //not sure how to do this.
    }
}