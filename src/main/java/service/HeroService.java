package service;

import hero.Hero;
import service.exception.FileStorageException;

import java.util.ArrayList;
import java.util.List;

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


    public List<Hero> filterByComplexity(List<Hero> heroes, int complexity) {
        List<Hero> filteredHeroes = new ArrayList<>();
        for (Hero hero : heroes) {
            if (hero.getComplexity() == complexity) {
                filteredHeroes.add(hero);
            }
        }
        return filteredHeroes;
    }
}
