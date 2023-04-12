package service;

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


    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        List<String> results = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                results.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new FileStorageException("File " + filename + " was not found.");
        }
        return results;
    }
}
