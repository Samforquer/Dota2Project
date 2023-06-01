package dao;
import model.Hero;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class JdbcHeroDao implements HeroDao {
    private final JdbcTemplate jdbcTemplate;
    private final RestTemplate restTemplate;
    public JdbcHeroDao(DataSource dataSource, RestTemplate restTemplate) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.restTemplate = restTemplate;
    }
    public void createHeroTable() {
        String sql = "CREATE TABLE IF NOT EXISTS heroes (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "attribute_type VARCHAR(255) NOT NULL," +
                "attack_type VARCHAR(255) NOT NULL," +
                "pick1 INT," +
                "pick2 INT," +
                "pick3 INT," +
                "pick4 INT," +
                "pick5 INT," +
                "pick6 INT," +
                "pick7 INT," +
                "pick8 INT," +
                "pro_picked INT," +
                "pro_wins INT," +
                "win1 INT," +
                "win2 INT," +
                "win3 INT," +
                "win4 INT," +
                "win5 INT," +
                "win6 INT," +
                "win7 INT," +
                "win8 INT," +
                "hero_complexity INT," +
                "hero_position INT" +
                ")";
        jdbcTemplate.execute(sql);
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

    public List<Hero> fetchHeroesFromApi() {
        String apiUrl = "https://api.example.com/heroes";
        ResponseEntity<Hero[]> response = restTemplate.getForEntity(apiUrl, Hero[].class);
        Hero[] heroes = response.getBody();
        return Arrays.asList(heroes);
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