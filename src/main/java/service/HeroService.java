package service;

import hero.Hero;
import service.exception.FileStorageException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HeroService {

    private List<Hero> heroes = new ArrayList<>();
    private static final String FIELD_DELIMITER = "\\,";
    private static final String FILE_BASE_PATH = "C:\\Users\\samfo\\OneDrive\\Documents\\currentDota2Data.csv";

    public void initialize() {
        try {
            List<Hero> lines = FileService.readContentsOfFile(FILE_BASE_PATH);
            for (Hero line : lines) {
                String[] fields = line.split(FIELD_DELIMITER);
                if (fields.length != 10) {
                    throw new RuntimeException("Error: Incorrect number of fields for hero: " + line + "in " + FILE_BASE_PATH);
                } else {
                    String name = fields[0];
                    String attributeType = fields[1];
                    String attackType = fields[2];
                    int position = Integer.parseInt(fields[3]);
                    int complexity = Integer.parseInt(fields[4]);
                    double belowArchonWinRate = Double.parseDouble(fields[5]);
                    double archonWinRate = Double.parseDouble(fields[6]);
                    double legendWinRate = Double.parseDouble(fields[7]);
                    double ancientWinRate = Double.parseDouble(fields[8]);
                    double aboveAncientWinRate = Double.parseDouble(fields[9]);

                    Hero hero = new Hero(name, attributeType, attackType, position, complexity, belowArchonWinRate,
                            archonWinRate, legendWinRate, ancientWinRate, aboveAncientWinRate);

                    heroes.add(hero);
                }
            }
        } catch (FileStorageException e) {
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

