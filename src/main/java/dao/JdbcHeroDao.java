package dao;

import java.util.ArrayList;
import java.util.List;
import model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import service.HeroApiService;

import javax.sql.DataSource;

@Repository
public class JdbcHeroDao implements HeroDao {

    private JdbcTemplate jdbcTemplate;
    private RestTemplate restTemplate;
    private HeroApiService heroApiService;

    @Autowired
    public JdbcHeroDao(DataSource dataSource, RestTemplate restTemplate, HeroApiService heroApiService) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.restTemplate = restTemplate;
        this.heroApiService = heroApiService;
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private void createHeroTable() {
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

    public void createAndPopulateHeroesTable() {
        createHeroTable(); // Create the table if it doesn't exist

        List<Hero> heroes = heroApiService.fetchHeroesFromApi(); // Fetch heroes from the API

        for (Hero hero : heroes) {
            insertHero(hero); // Insert each hero into the table
        }
    }

    @Override
    public List<Hero> getHeroes() {
        if (!isHeroesTableExists()) {
            createAndPopulateHeroesTable();
        }

        List<Hero> heroes = new ArrayList<>();
        String sql = "SELECT * FROM heroes";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Hero hero = mapRowToHero(results);
            heroes.add(hero);
        }
        return heroes;
    }

    private boolean isHeroesTableExists() {
        String sql = "SELECT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = 'heroes')";
        return jdbcTemplate.queryForObject(sql, Boolean.class);
    }

    private void insertHero(Hero hero) {
        String sql = "INSERT INTO heroes (id, name, attribute_type, attack_type, pick1, pick2, pick3, pick4, " +
                "pick5, pick6, pick7, pick8, pro_picked, pro_wins, win1, win2, win3, win4, win5, win6, win7, " +
                "win8, hero_complexity, hero_position) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, hero.getId(), hero.getName(), hero.getPrimaryAttr(), hero.getAttackType(),
                hero.getPick1(), hero.getPick2(), hero.getPick3(), hero.getPick4(), hero.getPick5(), hero.getPick6(),
                hero.getPick7(), hero.getPick8(), hero.getProPicked(), hero.getProWins(), hero.getWin1(), hero.getWin2(),
                hero.getWin3(), hero.getWin4(), hero.getWin5(), hero.getWin6(), hero.getWin7(), hero.getWin8(),
                hero.getHeroComplexity(), hero.getHeroPosition());
    }

    private Hero mapRowToHero(SqlRowSet rs) {
        Hero hero = new Hero();
        hero.setId(rs.getInt("id"));
        hero.setName(rs.getString("name"));
        hero.setPrimaryAttr(rs.getString("attribute_type"));
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