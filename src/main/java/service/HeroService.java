package service;

import hero.Hero;
import service.exception.FileStorageException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HeroService {

    private List<Hero> heroes = new ArrayList<>();


    public void initialize() {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dota2_hero_database",
                "postgres", "postgres1");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM heroes")) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String attributeType = resultSet.getString("attribute_type");
                String attackType = resultSet.getString("attack_type");
                int position = resultSet.getInt("position");
                int complexity = resultSet.getInt("complexity");
                double belowArchonWinRate = resultSet.getDouble("below_archon_win_rate");
                double archonWinRate = resultSet.getDouble("archon_win_rate");
                double legendWinRate = resultSet.getDouble("legend_win_rate");
                double ancientWinRate = resultSet.getDouble("ancient_win_rate");
                double aboveAncientWinRate = resultSet.getDouble("above_ancient_win_rate");

                Hero hero = new Hero(name,attributeType,attackType,position,complexity,belowArchonWinRate,archonWinRate,
                        legendWinRate,ancientWinRate,aboveAncientWinRate);
                heroes.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Hero> getHeroes() {
        return heroes;
    }


    public List<Hero> filterByComplexityAndPosition(List<Hero> heroes, int complexity, int position) {
        // <= complexity so users can select the HIGHEST level of complexity, for example: max complexity 3 will return 1 2 and 3 
        return heroes.stream()
                .filter(hero -> hero.getComplexity() <= complexity && hero.getPosition() == position)
                .collect(Collectors.toList());
    }

    public List<Hero> sortByWinRate(List<Hero> heroes, int skillLevel) {
        switch (skillLevel) {
            case 1 -> heroes.sort(Comparator.comparing(Hero::getBelowArchonWinRate).reversed());
            case 2 -> heroes.sort(Comparator.comparing(Hero::getArchonWinRate).reversed());
            case 3 -> heroes.sort(Comparator.comparing(Hero::getLegendWinRate).reversed());
            case 4 -> heroes.sort(Comparator.comparing(Hero::getAncientWinRate).reversed());
            case 5 -> heroes.sort(Comparator.comparing(Hero::getAboveAncientWinRate).reversed());
            default -> throw new IllegalArgumentException("Invalid skill level: " + skillLevel);
        }
        return heroes;
    }

    }

