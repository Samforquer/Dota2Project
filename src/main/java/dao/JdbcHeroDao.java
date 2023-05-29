package dao;
import model.Hero;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcHeroDao implements HeroDao {
    private final JdbcTemplate jdbcTemplate;
    JdbcHeroDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hero> getHeroes() {
        List<Hero> heroes = new ArrayList<>();
        String sql = "SELECT * FROM heroes";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Hero hero = mapRowToHero(results);
            heroes.add(hero);
        }
        return heroes;
    }


    private Hero mapRowToHero(SqlRowSet rs) {
        Hero hero = new Hero();
        hero.setName(rs.getString("localized_name"));
        return hero;
    }
}
