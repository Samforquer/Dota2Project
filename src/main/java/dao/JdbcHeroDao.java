package dao;
import hero.Hero;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


public class JdbcHeroDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired JdbcHeroDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
//    public List<Hero> selectAll(){
//        String sql = "SELECT * FROM hero";
//      List<Hero> results = jdbcTemplate.query(sql);
//        return results;
//    }

}
