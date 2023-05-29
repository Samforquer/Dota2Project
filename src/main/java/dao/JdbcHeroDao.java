package dao;
import hero.Hero;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class JdbcHeroDao implements HeroDao {
    private final JdbcTemplate jdbcTemplate;

    // not sure about the Autowired
    @Autowired
    JdbcHeroDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Hero> selectAll() {
        String sql = "SELECT * FROM heroes";
        List<Hero> heroes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Hero.class));
        return heroes;
    }

    @Override
    public List<Hero> list() {
        return null;
    }

    @Override
    public Hero get(int id) {
        return null;
    }

    @Override
    public List<Hero> searchByPosition(int position) {
        return null;
    }

    @Override
    public List<Hero> searchByWinRate(double winRate) {
        return null;
    }

    @Override
    public List<Hero> searchByPositionAndWinRate(int position, double winRate) {
        return null;
    }

    @Override
    public List<Hero> filterByPositionWinRateAndComplexity(int position, double winRate, int complexity) {
        return null;
    }

    @Override
    public List<Hero> getHeroes() {
        List<Hero> heroes = new ArrayList<>();
        String sql = "SELECT * FROM heroes";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Hero hero = mapRowtoHero(results);
            heroes.add(hero);
        }
        return heroes;
    }


    private Hero mapRowtoHero(SqlRowSet rs) {
        Hero hero = new Hero();
        hero.setName(rs.getString("localized_name")); // I need to make naming consistent across Java/SQL/JSON etc. or figure out what to do there.
        // How do I set the complexity or hero positions ? I may do it manually but is that weird to have inconsistency in the manual or auto populating of my database. for example: the heroes/ winrates are going to be the API
        // but there isn't an api to determine the position or complexity as far as I know.
        return hero;
    }
}
