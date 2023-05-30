package dao;

import model.Hero;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper; // perhaps this would be another way to look into?
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcHeroDao implements HeroDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcHeroDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hero> getHeroes() {
        List<Hero> heroes = new ArrayList<>();
        String sql = "SELECT * FROM heroes";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
        Hero hero = mapRowToHero(results);
        heroes.add(hero);
    }
    return heroes;
}

    private Hero mapRowToHero(SqlRowSet rs){
        Hero hero = new Hero();
        hero.setId(rs.getInt("id"));
        hero.setName(rs.getString("name"));
        hero.setAttributeType(rs.getString("attribute_type"));
        hero.setAttackType(rs.getString("attack_type"));
        hero.setPick1(rs.getInt("pick1"));
        hero.setPick2(rs.getInt("pick2"));
        hero.setPick3(rs.getInt("pick3"));
        hero.setPick4(rs.getInt("pick4"));
        hero.setPick5(rs.getInt("pick5"));
        hero.setPick6(rs.getInt("pick6"));
        hero.setPick7(rs.getInt("pick7"));
        hero.setPick8(rs.getInt("pick8"));
        hero.setProPicked(rs.getInt("pro_picked"));
        hero.setProWins(rs.getInt("pro_wins"));
        hero.setWin1(rs.getInt("win1"));
        hero.setWin2(rs.getInt("win2"));
        hero.setWin3(rs.getInt("win3"));
        hero.setWin4(rs.getInt("win4"));
        hero.setWin5(rs.getInt("win5"));
        hero.setWin6(rs.getInt("win6"));
        hero.setWin7(rs.getInt("win7"));
        hero.setWin8(rs.getInt("win8"));
        hero.setHeroComplexity(rs.getInt("hero_complexity"));
        hero.setHeroPosition(rs.getInt("hero_position"));
        return hero;

    }
}