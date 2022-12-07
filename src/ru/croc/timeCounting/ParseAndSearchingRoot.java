package ru.croc.task15.timeCounting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ParseAndSearchingRoot {
    private static Organization root;

    public static Organization parseAndSearchingRoot(String path) throws IOException {
        Path pathToTheFile = Paths.get(path);
        Map<String, Organization> organizations = new HashMap<>();
        List<String> allLinesInFile = Files.readAllLines(pathToTheFile);
        for (String s : allLinesInFile) {
            String[] currentLine = s.split(",");
            Organization current = new Organization(Integer.parseInt(currentLine[2]), currentLine[0], currentLine[1]);
            organizations.put(current.getName(), current);
            if (current.getNameOfParent().equals("-")) {
                root = current;
            } else {
                organizations.get(current.getNameOfParent()).updateChildDepartments(current);
            }
        }

        return root;
    }
}
