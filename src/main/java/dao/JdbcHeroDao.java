package dao;

import model.Hero;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcHeroDao implements HeroDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcHeroDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hero> getHeroes() {
        String sql = "SELECT * FROM heroes";
        return jdbcTemplate.query(sql, new HeroMapper());
    }

    private static class HeroMapper implements RowMapper<Hero> {
        @Override
        public Hero mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hero hero = new Hero();
            hero.setId(rs.getInt("id"));
            hero.setName(rs.getString("name"));
            hero.setAttributeType(rs.getString("attribute_type"));
            hero.setAttackType(rs.getString("attack_type"));
            hero.setHeraldWinRate(rs.getBigDecimal("herald_win_rate"));
            hero.setGuardianWinRate(rs.getBigDecimal("guardian_win_rate"));
            hero.setCrusaderWinRate(rs.getBigDecimal("crusader_win_rate"));
            hero.setArchonWinRate(rs.getBigDecimal("archon_win_rate"));
            hero.setLegendWinRate(rs.getBigDecimal("legend_win_rate"));
            hero.setAncientWinRate(rs.getBigDecimal("ancient_win_rate"));
            hero.setDivineWinRate(rs.getBigDecimal("divine_win_rate"));
            hero.setImmortalWinRate(rs.getBigDecimal("immortal_win_rate"));
            hero.setProWinRate(rs.getBigDecimal("pro_win_rate"));
            // Map other fields as well
            return hero;
        }
    }
}