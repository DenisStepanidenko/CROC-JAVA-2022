package ru.croc.task13.recommendations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Parser {

    // преобразовываем файл с фильмами в мапу, где ключ - id фильма
    public static Map<Integer, String> parseFilms(String path) throws IOException {
        HashMap<Integer, String> listOfFilms = new HashMap<>();
        Path pathToTheFilms = Paths.get(path);
        try {
            List<String> allLinesInFile = Files.readAllLines(pathToTheFilms);
            for (String s : allLinesInFile) {
                String[] currentLine = s.split(",");
                Integer idOfFilm = Integer.valueOf(currentLine[0]);
                String nameOfFilm = currentLine[1];
                listOfFilms.put(idOfFilm, nameOfFilm);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfFilms;
    }

    // преобразовываем файл с историей просмотров в мапу, где ключ - id пользователя
    public static Map<Integer, ArrayList<Integer>> parseViews(String path) {
        HashMap<Integer, ArrayList<Integer>> listOfViews = new HashMap<>();
        Path pathToTheViews = Paths.get(path);
        int id = 0;
        try {
            List<String> allLinesInFile = Files.readAllLines(pathToTheViews); //вспомогающий List
            for (String s : allLinesInFile) {
                String[] currentLine = s.split(",");
                ArrayList<Integer> currentListOfViews = new ArrayList<>();
                for (String m : currentLine) {
                    currentListOfViews.add(Integer.parseInt(m));

                }
                listOfViews.put(id++, currentListOfViews);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfViews;
    }

}
