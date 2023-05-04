package dao;

import java.util.List;
import hero.Hero;

public interface HeroDao {

    List<Hero> list();

    Hero get (int id);

    List<Hero> searchByPosition(int position);

    List<Hero> searchByWinRate(double winRate);

    List<Hero> searchByPositionAndWinRate(int position, double winRate);
    // I am not sure what I'm going to do with the filter method yet.
    List<Hero> filterByPositionWinRateAndComplexity(int position, double winRate, int complexity);


}

