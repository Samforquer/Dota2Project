package service;

import hero.Hero;
import service.exception.FileStorageException;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService {

    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(filename, appendFile);
                PrintWriter writer = new PrintWriter(fileOutputStream)
        ) {
            writer.println(contents);
        } catch (FileNotFoundException e) {
            throw new FileStorageException("File " + filename + " was not found.");
        } catch (Exception e) {
            throw new FileStorageException("Unable to close file output stream.");
        }
    }


    public static List<Hero> readContentsOfFile(String filename) throws FileStorageException {
        List<Hero> heroes = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.useDelimiter(",");
            // skip the header row
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");

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
        } catch (FileNotFoundException e) {
            throw new FileStorageException("File " + filename + " was not found.");
        }
        return heroes;
    }
}
